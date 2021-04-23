package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

public class TripBookingPackageProperties {
    @SerializedName("going_trip_booking_package_id")
    private StringProperty going_trip_booking_package_id;
    @SerializedName("is_return_trip_included")
    private StringProperty is_return_trip_included;
    @SerializedName("pratica_code")
    private StringProperty pratica_code;
    @SerializedName("remain_allotments")
    private StringProperty remain_allotments;

    @SerializedName("return_trip_booking_package_id")
    private StringProperty return_trip_booking_package_id;

    public StringProperty getGoing_trip_booking_package_id() {
        return going_trip_booking_package_id;
    }

    public StringProperty getIsReturnTripIncluded() {
        return is_return_trip_included;
    }

    public StringProperty getPraticaCode() {
        return pratica_code;
    }

    public StringProperty getRemainAllotments() {
        return remain_allotments;
    }

    public StringProperty getReturnTripBookingPackageId() {
        return return_trip_booking_package_id;
    }
}
