package com.reactlibrary;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.reactlibrary.beans.ActualTripsResponse;
import com.reactlibrary.beans.BookingDetailResponse;
import com.reactlibrary.beans.BookingPreviewResponse;
import com.reactlibrary.beans.BookingResponse;
import com.reactlibrary.beans.DomainInfoResponse;
import com.reactlibrary.beans.TripBookingReport;
import com.reactlibrary.beans.TripPackagesResponse;
import com.reactlibrary.beans.UserResponse;
import com.reactlibrary.statics.Utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    public static Bitmap createVoucher(ReactApplicationContext context, String domain_text, String user_text, String booking_string, String voucher_text, boolean hidePrice) {
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

        String businessInfo = "";
        DomainInfoResponse domain = gson.fromJson(domain_text, DomainInfoResponse.class);
        try {
            businessInfo = domain.getEntity().getDescription() + ", "
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
        business_info.setText(businessInfo);

        String voucherText = voucher_text;
        TextView voucher_text_extra = frameLayout.findViewById(R.id.voucher_text_extra);
        voucher_text_extra.setVisibility(View.GONE);
        if (!voucherText.isEmpty()) {
            voucher_text_extra.setVisibility(View.VISIBLE);
            voucher_text_extra.setText(voucherText);
        }

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
        if (hidePrice) {
            priceText.setVisibility(View.GONE);
        } else {
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

    public static Bitmap createVoucherSingle(ReactApplicationContext context, String domain_text, String user_text, String booking_string, String ticket_text, String voucher_text, boolean hidePrice) {
        View inflatedFrame = LayoutInflater.from(context).inflate(R.layout.print_voucher, null);
        RelativeLayout frameLayout = inflatedFrame.findViewById(R.id.screen);
        ImageView qrCode = frameLayout.findViewById(R.id.qrcode);


        Gson gson = getGson();
        BookingDetailResponse booking = gson.fromJson(booking_string, BookingDetailResponse.class);
        BookingResponse.Ticket ticket = gson.fromJson(ticket_text, BookingResponse.Ticket.class);

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

        Bitmap qrcode = createQRCodeFromString(PrinterHelper.createQRCodeText(booking.getBooking().getId(), booking.getBooking().getBooking_code(), booking.getDepartures().get(0).getTrip_package_id(), ticket.getTrip_booking_participant_id(), booking.getBooking().getId()));
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

        TextView paxes = frameLayout.findViewById(R.id.paxes);
        String text_paxes = "";
        if ("ADT".equals(ticket.getAgeRangeCode())) {
            text_paxes = "1 x ADT";
        }
        if ("SNR".equals(ticket.getAgeRangeCode())) {
            text_paxes = "1 x SNR";
        }
        if ("CHD".equals(ticket.getAgeRangeCode())) {
            text_paxes = "1 x CHD";
        }
        if ("INF".equals(ticket.getAgeRangeCode())) {
            text_paxes = "1 x INF";
        }
        paxes.setText(text_paxes);

        String businessInfo = "";
        DomainInfoResponse domain = gson.fromJson(domain_text, DomainInfoResponse.class);
        try {
            businessInfo = domain.getEntity().getDescription() + ", "
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
        business_info.setText(businessInfo);

        String voucherText = voucher_text;
        TextView voucher_text_extra = frameLayout.findViewById(R.id.voucher_text_extra);
        voucher_text_extra.setVisibility(View.GONE);
        if (!voucherText.isEmpty()) {
            voucher_text_extra.setVisibility(View.VISIBLE);
            voucher_text_extra.setText(voucherText);
        }

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
        priceText.setText(ticket.getPrice() + "€");
        priceText.setVisibility(View.VISIBLE);
        if (hidePrice) {
            priceText.setVisibility(View.GONE);
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

    public static Bitmap createVoucherSingle(ReactApplicationContext context, String domain_text, String user_text, String tripBooking_text, String pkg_text, String booking_preview_text, String tripBookingParticipant_text, String ticket_text, String voucher_text) {
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

        String businessInfo = "";
        DomainInfoResponse domain = gson.fromJson(domain_text, DomainInfoResponse.class);
        try {
            businessInfo = domain.getEntity().getDescription() + ", "
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
        business_info.setText(businessInfo);

        String voucherText = voucher_text;
        TextView voucher_text_extra = frameLayout.findViewById(R.id.voucher_text_extra);
        voucher_text_extra.setVisibility(View.GONE);
        if (!voucherText.isEmpty()) {
            voucher_text_extra.setVisibility(View.VISIBLE);
            voucher_text_extra.setText(voucherText);
        }

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

    public static Bitmap createSalesSummaryTicket(ReactApplicationContext context, String tripBookingsReport_text) {
        double totalPrice = 0.0;
        double cashPrice = 0.0;
        double ccPrice = 0.0;
        int cancelled_vouchers = 0;
        int printed_vouchers = 0;

        Gson gson = getGson();
        List<TripBookingReport> tripBookings = gson.fromJson(tripBookingsReport_text, new TypeToken<List<TripBookingReport>>() {
        }.getType());
        View inflatedFrame = LayoutInflater.from(context).inflate(R.layout.print_sales_summary, null);

        TextView timestamp = inflatedFrame.findViewById(R.id.timestamp);
        LinearLayout container = inflatedFrame.findViewById(R.id.sales_container);
        TextView totalSales = inflatedFrame.findViewById(R.id.total_sales);
        TextView cashSales = inflatedFrame.findViewById(R.id.cash_sales);
        TextView ccSales = inflatedFrame.findViewById(R.id.cc_sales);
        TextView canceledOrders = inflatedFrame.findViewById(R.id.canceled_orders);
        TextView printedVouchers = inflatedFrame.findViewById(R.id.printed_voucher);
        View canceledOrdersLayout = inflatedFrame.findViewById(R.id.canceled_orders_layout);
        View printedVoucherLayout = inflatedFrame.findViewById(R.id.printed_voucher_layout);

        Date timestampDate = new Date();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ITALY);
        timestamp.setText(dateTimeFormat.format(timestampDate));

        String packageName = null;
        for (TripBookingReport order : tripBookings) {
            BookingDetailResponse.Departures.Participant_counters paxes = order.getParticipant_counters();
            printed_vouchers += paxes.getSNR() + paxes.getADT() + paxes.getCHD() + paxes.getINF();
            if (!order.getTrip_booking().getStatus().equals("confirmed")) {
                cancelled_vouchers += paxes.getSNR() + paxes.getADT() + paxes.getCHD() + paxes.getINF();
                continue;
            }

            if (packageName == null || !packageName.equals(order.getTrip_package().getId())) {
                LinearLayout headerView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.item_print_sale_header, null);
                TripPackagesResponse pckg = order.getTrip_package();
                TextView packageTextCode = headerView.findViewById(R.id.package_code);
                TextView packageTextName = headerView.findViewById(R.id.package_name);
                packageTextCode.setText(pckg.getCode());
                packageTextName.setText(pckg.getDescription());
                container.addView(headerView);
            }
            LinearLayout itemView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.item_print_sale, null);
            TextView participants = itemView.findViewById(R.id.participants);
            TextView meetingPoint = itemView.findViewById(R.id.meeting_point);
            TextView price = itemView.findViewById(R.id.price);
            TextView priceBase = itemView.findViewById(R.id.price_total);

            Integer SNR = paxes.getSNR();
            Integer ADT = paxes.getADT();
            Integer CHD = paxes.getCHD();
            Integer INF = paxes.getINF();
            String text_paxes = "";

            text_paxes += order.getTrip_booking().getBooking_code() + "\n";
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
            participants.setText(text_paxes);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);
            String meetingDate = dateFormat.format(order.getActual_trip().getStart_day());
            String meetingPointName = order.getActual_trip().getMeeting_point_list_description();
            String meetingPointTime = order.getActual_trip().getStart_time();
            meetingPoint.setText(meetingDate + " - " + meetingPointName + (meetingPointTime != null ? " - " + Utilities.formatTimeWithoutSeconds(meetingPointTime) : ""));
            price.setText(order.getTotal_amount() + " €");
            Double discountAmount = order.getCoupon_amount();
            if (discountAmount != null && discountAmount < 0) {
                double totalDiscounted = Math.round((order.getTotal_amount() - discountAmount) * 100);
                priceBase.setVisibility(View.VISIBLE);
                priceBase.setText(totalDiscounted + " €");
                priceBase.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                priceBase.setVisibility(View.GONE);
            }

            container.addView(itemView);
            packageName = order.getTrip_package().getId();


            totalPrice += order.getTotal_amount();
            if (order.getTrip_booking().getProperties() != null && order.getTrip_booking().getProperties().getOrigin_channel_extra() != null) {
                BookingResponse.TripBooking.TripBookingPropertiesBean.OriginChannelExtra extra = order.getTrip_booking().getProperties().getOrigin_channel_extra();
                if (extra.getValue() != null && extra.getValue().getPayment_method() != null) {
                    if (extra.getValue().getPayment_method().equals("poynt_cc")) {
                        ccPrice += order.getTotal_amount();
                    } else {
                        cashPrice += order.getTotal_amount();
                    }
                } else {
                    cashPrice += order.getTotal_amount();
                }
            } else {
                cashPrice += order.getTotal_amount();
            }
        }

        totalPrice = Math.round(totalPrice * 100) / 100;
        cashPrice = Math.round(cashPrice * 100) / 100;
        ccPrice = Math.round(ccPrice * 100) / 100;

        totalSales.setText(totalPrice + "€");
        cashSales.setText(cashPrice + "€");
        ccSales.setText(ccPrice + "€");

        if (cancelled_vouchers > 0) canceledOrdersLayout.setVisibility(View.VISIBLE);
        if (tripBookings.size() > 0) printedVoucherLayout.setVisibility(View.VISIBLE);
        canceledOrders.setText(String.valueOf(cancelled_vouchers));
        printedVouchers.setText(String.valueOf(printed_vouchers));

        inflatedFrame.setDrawingCacheEnabled(true);
        inflatedFrame.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        inflatedFrame.layout(0, 0, inflatedFrame.getMeasuredWidth(), inflatedFrame.getMeasuredHeight());
        inflatedFrame.buildDrawingCache(true);
        return inflatedFrame.getDrawingCache();
    }

}
