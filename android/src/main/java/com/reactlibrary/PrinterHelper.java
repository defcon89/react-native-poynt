package com.reactlibrary;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.reactlibrary.beans.ActualTripsResponse;
import com.reactlibrary.beans.BookingDetailResponse;
import com.reactlibrary.beans.BookingPreviewResponse;
import com.reactlibrary.beans.BookingResponse;
import com.reactlibrary.beans.DomainInfoResponse;
import com.reactlibrary.beans.TripPackagesResponse;
import com.reactlibrary.beans.UserResponse;
import com.reactlibrary.statics.Utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Nullable;

import co.poynt.api.model.Order;

import static com.reactlibrary.statics.Utilities.createQRCodeFromString;
import static com.reactlibrary.statics.Utilities.getGson;

public class PrinterHelper {

    public static String createQRCodeText(String order_id) {
        return "{ \"trip_booking_id\": null,\"trip_booking_code\": null, \"trip_booking_package_id\": null, \"trip_booking_participant_id\": null, \"origin_channel_booking_id\": \"" + order_id + "\" }";
    }

    public static String createQRCodeText(String tripBookingId, String tripBookingCode, String tripBookingPackageId, String tripBookingParticipantId, String originalId) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("trip_booking_id", tripBookingId == null ? JSONObject.NULL : tripBookingId);
            jsonObject.put("trip_booking_code", tripBookingCode == null ? JSONObject.NULL : tripBookingCode);
            jsonObject.put("trip_booking_package_id", tripBookingPackageId == null ? JSONObject.NULL : tripBookingPackageId);
            jsonObject.put("trip_booking_participant_id", tripBookingParticipantId == null ? JSONObject.NULL : tripBookingParticipantId);
            jsonObject.put("origin_channel_booking_id", originalId == null ? JSONObject.NULL : originalId);
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static Bitmap createVoucher(ReactApplicationContext context, String domain_text, String user_text, String booking_string, boolean hidePrice) {
        View inflatedFrame = LayoutInflater.from(context).inflate(R.layout.print_voucher, null);
        RelativeLayout frameLayout = inflatedFrame.findViewById(R.id.screen);
        ImageView qrCode = frameLayout.findViewById(R.id.qrcode);

        Gson gson = getGson();
        BookingDetailResponse booking = gson.fromJson(booking_string, BookingDetailResponse.class);

        TextView agent = frameLayout.findViewById(R.id.agent);

        UserResponse userResponse = gson.fromJson(user_text, UserResponse.class);
        agent.setText(userResponse.getUser().getAccess_id() + " " + userResponse.getUser().getName());

        Date voucherDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);
        String voucherDateString = dateFormat.format(voucherDate);
        TextView voucherDateTextView = frameLayout.findViewById(R.id.voucher_date);
        voucherDateTextView.setText(voucherDateString);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.ITALY);
        String voucherTimeString = timeFormat.format(voucherDate);
        TextView voucherTimeTextView = frameLayout.findViewById(R.id.voucher_time);
        voucherTimeTextView.setText(voucherTimeString);

        Bitmap qrcode = createQRCodeFromString(PrinterHelper.createQRCodeText(booking.getBooking().getId(), booking.getBooking().getBooking_code(), booking.getDepartures().get(0).getTrip_package_id(), null, ""));
        qrCode.setImageBitmap(qrcode);

        TextView pckageName = frameLayout.findViewById(R.id.package_name);
        TripPackagesResponse pckg = booking.getDepartures().get(0).getActual_trip().getPckg();
        pckageName.setText(pckg.getDescription());

        ActualTripsResponse at_going = null;
        ActualTripsResponse at_return = null;
        for (BookingDetailResponse.Departures departure : booking.getDepartures()) {
            if (departure.getActual_trip().getType().equals("return")) {
                at_return = departure.getActual_trip();
            }
            if (!departure.getActual_trip().getType().equals("return")) {
                at_going = departure.getActual_trip();
            }
        }

        TextView travelPoint = frameLayout.findViewById(R.id.travel_point);
        travelPoint.setText(at_going.getMeeting_point_list_description());

        Integer SNR = booking.getDepartures().get(0).getParticipant_counters().getSNR();
        Integer ADT = booking.getDepartures().get(0).getParticipant_counters().getADT();
        Integer CHD = booking.getDepartures().get(0).getParticipant_counters().getCHD();
        Integer INF = booking.getDepartures().get(0).getParticipant_counters().getINF();
        String text_paxes = "";
        TextView paxes = frameLayout.findViewById(R.id.paxes);
        if (SNR != null && SNR > 0) {
            text_paxes += SNR + " x SNR\n";
        }
        if (ADT != null && ADT > 0) {
            text_paxes += ADT + " x ADT\n";
        }
        if (CHD != null && CHD > 0) {
            text_paxes += CHD + " x CHD\n";
        }
        if (INF != null && INF > 0) {
            text_paxes += INF + " x INF\n";
        }
        paxes.setText(text_paxes);


        DomainInfoResponse domain = gson.fromJson(domain_text, DomainInfoResponse.class);
        String voucherText = "";
        try {
            voucherText = domain.getEntity().getDescription() + ", "
                    + domain.getEntity().getPrimary_address().getStreet() + " "
                    + domain.getEntity().getPrimary_address().getNumber() + ", "
                    + domain.getEntity().getPrimary_address().getCity() + " "
                    + "(" + domain.getEntity().getPrimary_address().getProvince() + ") "
                    + domain.getEntity().getPrimary_address().getZip_code() + ", "
                    + "P.iva " + domain.getEntity().getPiva();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextView business_info = frameLayout.findViewById(R.id.business_info);
        business_info.setText(voucherText);

        TextView travelDate = frameLayout.findViewById(R.id.travel_date_time);
        String time = at_going.getStart_time();
        String date_time = dateFormat.format(at_going.getStart_day());
        if (time != null) date_time += " " + Utilities.formatTimeWithoutSeconds(time);
        travelDate.setText(date_time);

        LinearLayout return_layout = frameLayout.findViewById(R.id.return_layout);
        return_layout.setVisibility(View.GONE);
        if (at_return != null) {
            return_layout.setVisibility(View.VISIBLE);

            TextView travelReturnPoint = frameLayout.findViewById(R.id.travel_return_point);
            travelReturnPoint.setText(at_return.getMeeting_point_list_description());

            TextView travelDateReturn = frameLayout.findViewById(R.id.travel_return_date_time);
            String return_time = at_return.getStart_time();
            String return_date_time = dateFormat.format(at_return.getStart_day());
            if (return_time != null)
                return_date_time += " " + Utilities.formatTimeWithoutSeconds(return_time);
            travelDateReturn.setText(return_date_time);
        }

        TextView pckgCode = frameLayout.findViewById(R.id.pckg_code);
        pckgCode.setText(pckg.getCode());

        TextView priceText = frameLayout.findViewById(R.id.price);
        if(hidePrice){
            priceText.setVisibility(View.GONE);
        }else {
            priceText.setText(booking.getBooking().getTotal_amount() + "€");
        }

        TextView booking_code = frameLayout.findViewById(R.id.booking_code);
        booking_code.setText(booking.getBooking().getBooking_code());

        frameLayout.setDrawingCacheEnabled(true);
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
        frameLayout.buildDrawingCache(true);
        return frameLayout.getDrawingCache();
    }

    public static Bitmap createVoucherSingle(ReactApplicationContext context, String domain_text, String user_text, String tripBooking_text, String pkg_text, String booking_preview_text, String tripBookingParticipant_text, String ticket_text) {
        Gson gson = getGson();
        BookingResponse.TripBooking tripBooking = gson.fromJson(tripBooking_text, BookingResponse.TripBooking.class);
        TripPackagesResponse pkg = gson.fromJson(pkg_text, TripPackagesResponse.class);
        BookingPreviewResponse booking_preview = gson.fromJson(booking_preview_text, BookingPreviewResponse.class);
        BookingResponse.TripBooking.TripBookingParticipant tripBookingParticipant = gson.fromJson(tripBookingParticipant_text, BookingResponse.TripBooking.TripBookingParticipant.class);
        BookingResponse.Ticket ticket = gson.fromJson(ticket_text, BookingResponse.Ticket.class);

        BookingResponse.TripBooking.TripBookingPackage tripBookingPackage = tripBooking.getPackages().get(0);
        Bitmap qrcode = createQRCodeFromString(PrinterHelper.createQRCodeText(tripBooking.getId(), tripBooking.getBooking_code(), tripBookingPackage.getId(), tripBookingParticipant.getId(), tripBooking.getId()));

        View inflatedFrame = LayoutInflater.from(context).inflate(R.layout.print_voucher, null);
        RelativeLayout frameLayout = inflatedFrame.findViewById(R.id.screen);
        ImageView qrCode = frameLayout.findViewById(R.id.qrcode);
        qrCode.setImageBitmap(qrcode);

        TextView agent = frameLayout.findViewById(R.id.agent);
        UserResponse userResponse = gson.fromJson(user_text, UserResponse.class);
        agent.setText(userResponse.getUser().getAccess_id() + " " + userResponse.getUser().getName());

        Date voucherDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);
        String voucherDateString = dateFormat.format(voucherDate);
        TextView voucherDateTextView = frameLayout.findViewById(R.id.voucher_date);
        voucherDateTextView.setText(voucherDateString);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.ITALY);
        String voucherTimeString = timeFormat.format(voucherDate);
        TextView voucherTimeTextView = frameLayout.findViewById(R.id.voucher_time);
        voucherTimeTextView.setText(voucherTimeString);

        TextView pckageName = frameLayout.findViewById(R.id.package_name);
        pckageName.setText(pkg.getDescription());

        TextView travelPoint = frameLayout.findViewById(R.id.travel_point);
        travelPoint.setText(booking_preview.getPreview().getTrip().getGoing().getActual_trip().getMeeting_point_list_description());

        String text_paxes = "";
        if ("ADT".equals(tripBookingParticipant.getAgeRangeCode())) {
            text_paxes = "1 x ADT";
        }
        if ("SNR".equals(tripBookingParticipant.getAgeRangeCode())) {
            text_paxes = "1 x SNR";
        }
        if ("CHD".equals(tripBookingParticipant.getAgeRangeCode())) {
            text_paxes = "1 x CHD";
        }
        if ("INF".equals(tripBookingParticipant.getAgeRangeCode())) {
            text_paxes = "1 x INF";
        }

        TextView paxes = frameLayout.findViewById(R.id.paxes);
        paxes.setText(text_paxes);

        DomainInfoResponse domain = gson.fromJson(domain_text, DomainInfoResponse.class);
        String voucherText = "";
        try {
            voucherText = domain.getEntity().getDescription() + ", "
                    + domain.getEntity().getPrimary_address().getStreet() + " "
                    + domain.getEntity().getPrimary_address().getNumber() + ", "
                    + domain.getEntity().getPrimary_address().getCity() + " "
                    + "(" + domain.getEntity().getPrimary_address().getProvince() + ") "
                    + domain.getEntity().getPrimary_address().getZip_code() + ", "
                    + "P.iva " + domain.getEntity().getPiva();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextView business_info = frameLayout.findViewById(R.id.business_info);
        business_info.setText(voucherText);

        TextView travelDate = frameLayout.findViewById(R.id.travel_date_time);
        String time = booking_preview.getPreview().getTrip().getGoing().getActual_trip().getStart_time();
        String date_time = dateFormat.format(booking_preview.getPreview().getTrip().getGoing().getActual_trip().getStart_day());
        if (time != null) date_time += " " + Utilities.formatTimeWithoutSeconds(time);
        travelDate.setText(date_time);

        LinearLayout return_layout = frameLayout.findViewById(R.id.return_layout);
        return_layout.setVisibility(View.GONE);
        if (booking_preview.getPreview().getTrip().getTrip_return() != null) {
            return_layout.setVisibility(View.VISIBLE);

            TextView travelReturnPoint = frameLayout.findViewById(R.id.travel_return_point);
            travelReturnPoint.setText(booking_preview.getPreview().getTrip().getTrip_return().getActual_trip().getMeeting_point_list_description());

            TextView travelDateReturn = frameLayout.findViewById(R.id.travel_return_date_time);
            String return_time = booking_preview.getPreview().getTrip().getTrip_return().getActual_trip().getStart_time();
            String return_date_time = dateFormat.format(booking_preview.getPreview().getTrip().getTrip_return().getActual_trip().getStart_day());
            if (return_time != null)
                return_date_time += " " + Utilities.formatTimeWithoutSeconds(return_time);
            travelDateReturn.setText(return_date_time);
        }

        TextView pckgCode = frameLayout.findViewById(R.id.pckg_code);
        pckgCode.setText(pkg.getCode());

        TextView priceText = frameLayout.findViewById(R.id.price);
        priceText.setVisibility(View.VISIBLE);
        priceText.setText(ticket.getPrice() + "€");

        TextView booking_code = frameLayout.findViewById(R.id.booking_code);
        booking_code.setText(tripBooking.getBooking_code());

        frameLayout.setDrawingCacheEnabled(true);
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
        frameLayout.buildDrawingCache(true);
        return frameLayout.getDrawingCache();
    }

}
