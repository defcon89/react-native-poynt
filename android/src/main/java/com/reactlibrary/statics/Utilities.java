package com.reactlibrary.statics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.squareup.okhttp.MediaType;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings({"WeakerAccess"})
final public class Utilities {
    private static final String TAG = "Utilities";

    private static final Pattern bound = Pattern.compile("\\b(\\w)");

    public static String titleize(final String input) {
        StringBuffer sb = new StringBuffer(input.length());
        Matcher mat = bound.matcher(input);
        while (mat.find()) {
            mat.appendReplacement(sb, mat.group().toUpperCase());
        }
        mat.appendTail(sb);
        return sb.toString();
    }

    public static boolean isHtmlText(String text) {
        return text != null && !(!text.contains("html>") || !text.contains("</html>"));
    }

    public static String getVisualDateTextFromJson(String jsonDate, String format) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ITALIAN);
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ITALIAN);
        Date d;
        try {
            d = df.parse(jsonDate);
        } catch (ParseException e) {
            try {
                d = df2.parse(jsonDate);
            } catch (ParseException pe) {
                Log.e(TAG, "", pe);
                return null;
            }
        }
        return getVisualDateText(d, format, true);
    }

    public static String getVisualDateText(Date date, String format) {
        return getVisualDateText(date, format, false);
    }

    public static String getVisualDateText(Date date, boolean addTimeZone) {
        return getVisualDateText(date, null, addTimeZone);
    }

    public static String getVisualOnlyDateText(Date date, boolean addTimeZone) {
        return getVisualDateText(date, "dd/MM/yy", addTimeZone);
    }

    public static String formatTimeWithoutSeconds(String time) {
        if (time.length() > 5) return time.substring(0, 5);
        return time;
    }

    public static String getVisualDateText(Date date, String format, boolean addTimeZone) {
        if (format == null) format = "dd/MM/yy HH:mm";
        try {
            DateFormat dateFormat = new SimpleDateFormat(format, Locale.ITALIAN);
            long datetime = date.getTime();
            if (addTimeZone) {
                // this not work
                //df.setTimeZone(TimeZone.getTimeZone("Europe/Amsterdam"));
                int rawTzOffset = TimeZone.getDefault().getOffset(new Date().getTime());
                datetime += rawTzOffset;
            }
            return dateFormat.format(datetime);
        } catch (Exception e) {
            Log.e(TAG, "", e);
            return date.toString();
        }
    }

    public static float getDensityPixelFactor(Context context) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }

    public static Bitmap createQRCodeFromString(String text) {
        try {
            return Utilities.createQRCodeFromString(text, 400, 400);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPxToDp(Context context, float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }


    public static Bitmap createQRCodeFromString(String text, Integer width, Integer height) throws WriterException {
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        return barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, width, height);
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
}
