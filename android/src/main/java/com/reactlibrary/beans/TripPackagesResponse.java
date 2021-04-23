package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class TripPackagesResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("code")
    private String code;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    @SerializedName("deleted_at")
    private Date deleted_at;

    @SerializedName("trip_service_catalog_list_id")
    private String trip_service_catalog_list_id;

    @SerializedName("tour_operator_id")
    private String tour_operator_id;

    @SerializedName("publish_on_web")
    private int publish_on_web;

    @SerializedName("published_at")
    private Date published_at;

    @SerializedName("active_status")
    private int active_status;

    @SerializedName("default_lang")
    private String default_lang;

    @SerializedName("active_language_codes")
    private List<String> active_language_codes;

    @SerializedName("max_people")
    private int max_people;

    @SerializedName("master_image")
    private String master_image;

    @SerializedName("properties")
    private TripPackageProperties properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    
    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at( Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getTrip_service_catalog_list_id() {
        return trip_service_catalog_list_id;
    }

    public void setTrip_service_catalog_list_id(String trip_service_catalog_list_id) {
        this.trip_service_catalog_list_id = trip_service_catalog_list_id;
    }

    public String getTour_operator_id() {
        return tour_operator_id;
    }

    public void setTour_operator_id(String tour_operator_id) {
        this.tour_operator_id = tour_operator_id;
    }

    public int getPublish_on_web() {
        return publish_on_web;
    }

    public void setPublish_on_web(int publish_on_web) {
        this.publish_on_web = publish_on_web;
    }

    public Date getPublished_at() {
        return published_at;
    }

    public void setPublished_at(Date published_at) {
        this.published_at = published_at;
    }

    public int getActive_status() {
        return active_status;
    }

    public void setActive_status(int active_status) {
        this.active_status = active_status;
    }

    public String getDefault_lang() {
        return default_lang;
    }

    public void setDefault_lang(String default_lang) {
        this.default_lang = default_lang;
    }

    public List<String> getActive_language_codes() {
        return active_language_codes;
    }

    public void setActive_language_codes(List<String> active_language_codes) {
        this.active_language_codes = active_language_codes;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public String getMaster_image() {
        return master_image;
    }

    public void setMaster_image(String master_image) {
        this.master_image = master_image;
    }

    public TripPackageProperties getProperties() {
        return properties;
    }
}
