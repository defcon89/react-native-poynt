package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;


public class TripBookingResourceProperties {
    @SerializedName("is_return_trip_included")
    private StringProperty is_return_trip_included;
    @SerializedName("meeting_point_id")
    private StringProperty meeting_point_id;

    public StringProperty getMeetingPointId() {
        return meeting_point_id;
    }

    public StringProperty getIsReturnTripIncluded() {
        return is_return_trip_included;
    }
}
