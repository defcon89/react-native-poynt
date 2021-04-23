package com.reactlibrary.beans;
import com.google.gson.annotations.SerializedName;

public class ActualTripProperties {
    
    @SerializedName("actual_trip_audioguide_languages")
    private ArrayProperty actual_trip_audioguide_languages;

    
    @SerializedName("actual_trip_guide_languages")
    private ArrayProperty actual_trip_guide_languages;

    
    @SerializedName("allotment_blocked_by_trip_resource_id")
    private StringProperty allotment_blocked_by_trip_resource_id;

    
    @SerializedName("default_max_allotment")
    private StringProperty default_max_allotment;

    
    @SerializedName("participant_counters")
    private StringProperty participant_counters;

    
    public ArrayProperty getActual_trip_audioguide_languages() {
        return actual_trip_audioguide_languages;
    }

    public void setActual_trip_audioguide_languages( ArrayProperty actual_trip_audioguide_languages) {
        this.actual_trip_audioguide_languages = actual_trip_audioguide_languages;
    }

    
    public ArrayProperty getActual_trip_guide_languages() {
        return actual_trip_guide_languages;
    }

    public void setActual_trip_guide_languages( ArrayProperty actual_trip_guide_languages) {
        this.actual_trip_guide_languages = actual_trip_guide_languages;
    }

    
    public StringProperty getAllotment_blocked_by_trip_resource_id() {
        return allotment_blocked_by_trip_resource_id;
    }

    public void setAllotment_blocked_by_trip_resource_id( StringProperty allotment_blocked_by_trip_resource_id) {
        this.allotment_blocked_by_trip_resource_id = allotment_blocked_by_trip_resource_id;
    }

    
    public StringProperty getDefault_max_allotment() {
        return default_max_allotment;
    }

    public void setDefault_max_allotment( StringProperty default_max_allotment) {
        this.default_max_allotment = default_max_allotment;
    }

    
    public StringProperty getParticipant_counters() {
        return participant_counters;
    }

    public void setParticipant_counters( StringProperty participant_counters) {
        this.participant_counters = participant_counters;
    }
}
