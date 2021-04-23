package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

public class TripResourceProperties {

    
    @SerializedName("adult_to")
    private StringProperty adult_to;

    
    @SerializedName("child_from")
    private StringProperty child_from;

    
    @SerializedName("child_to")
    private StringProperty child_to;

    
    @SerializedName("resource_sub_types")
    private StringProperty resource_sub_types;

    
    @SerializedName("resource_type")
    private StringProperty resource_type;

    
    @SerializedName("allow_no_allotment_rule")
    private StringProperty allow_no_allotment_rule;

    
    @SerializedName("price")
    private StringProperty price;

    
    public StringProperty getResource_sub_types() {
        return resource_sub_types;
    }

    public void setResource_sub_types( StringProperty resource_sub_types) {
        this.resource_sub_types = resource_sub_types;
    }

    
    public StringProperty getResource_type() {
        return resource_type;
    }

    public void setResource_type( StringProperty resource_type) {
        this.resource_type = resource_type;
    }

    
    public StringProperty getAllow_no_allotment_rule() {
        return allow_no_allotment_rule;
    }

    public void setAllow_no_allotment_rule(StringProperty allow_no_allotment_rule) {
        this.allow_no_allotment_rule = allow_no_allotment_rule;
    }

    
    public StringProperty getAdultTo() {
        return adult_to;
    }

    
    public StringProperty getChildFrom() {
        return child_from;
    }

    
    public StringProperty getChildTo() {
        return child_to;
    }

    
    public StringProperty getPrice() {
        return price;
    }
}
