package com.reactlibrary.beans;
import com.google.gson.annotations.SerializedName;

public class TripPackageProperties {

    //--------------------
    
    @SerializedName("adult_to")
    private StringProperty adult_to;

    
    @SerializedName("child_from")
    private StringProperty child_from;

    
    @SerializedName("child_to")
    private StringProperty child_to;

    
    @SerializedName("disabled_participant_categories")
    private ArrayProperty disabled_participant_categories;

    
    @SerializedName("email")
    private StringProperty email;

    
    @SerializedName("note_booking")
    private StringProperty note_booking;

    
    @SerializedName("phone")
    private StringProperty phone;

    
    @SerializedName("price")
    private StringProperty price;

    
    @SerializedName("price_type")
    private StringProperty price_type;

    
    @SerializedName("priority_order")
    private StringProperty priority_order;

    // -------------------------------------------------

    
    public StringProperty getAdult_to() {
        return adult_to;
    }

    public void setAdult_to( StringProperty adult_to) {
        this.adult_to = adult_to;
    }

    
    public StringProperty getChild_from() {
        return child_from;
    }

    public void setChild_from( StringProperty child_from) {
        this.child_from = child_from;
    }

    
    public StringProperty getChild_to() {
        return child_to;
    }

    public void setChild_to( StringProperty child_to) {
        this.child_to = child_to;
    }

    
    public ArrayProperty getDisabled_participant_categories() {
        return disabled_participant_categories;
    }

    public void setDisabled_participant_categories( ArrayProperty disabled_participant_categories) {
        this.disabled_participant_categories = disabled_participant_categories;
    }

    
    public StringProperty getEmail() {
        return email;
    }

    public void setEmail( StringProperty email) {
        this.email = email;
    }

    
    public StringProperty getNote_booking() {
        return note_booking;
    }

    public void setNote_booking( StringProperty note_booking) {
        this.note_booking = note_booking;
    }

    
    public StringProperty getPhone() {
        return phone;
    }

    public void setPhone( StringProperty phone) {
        this.phone = phone;
    }

    
    public StringProperty getPrice() {
        return price;
    }

    public void setPrice( StringProperty price) {
        this.price = price;
    }

    
    public StringProperty getPrice_type() {
        return price_type;
    }

    public void setPrice_type( StringProperty price_type) {
        this.price_type = price_type;
    }

    
    public StringProperty getPriority_order() {
        return priority_order;
    }

    public void setPriority_order( StringProperty priority_order) {
        this.priority_order = priority_order;
    }

}
