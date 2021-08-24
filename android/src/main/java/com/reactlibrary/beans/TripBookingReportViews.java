package com.reactlibrary.beans;

import java.util.ArrayList;
import java.util.Date;

public class TripBookingReportViews {
    private String id;
    private String trip_booking_id;
    private String trip_booking_package_id;
    private String actual_trip_id;
    private String included_actual_trip_return_id;
    private String return_trip_booking_package_id;
    private String trip_booking_payment_type_id;
    private Date trip_booking_booking_date;
    private Date actual_trip_start_day;
    private String actual_trip_start_time;
    private String trip_package_id;
    private Integer is_return_trip_included;
    private String trip_booking_booking_code;
    private String pratica_code;
    private String trip_booking_origin_channel_voucher_code;
    private String trip_booking_origin_channel_booking_id;
    private String trip_booking_entity_customer_id;
    private String trip_booking_entity_id;
    private String trip_booking_created_by;
    private String trip_booking_origin_channel_code;
    private String trip_booking_status;
    private Date trip_booking_has_been_confirmed;
    private String trip_booking_branch_code;
    private String trip_package_description;
    private String trip_package_code;
    private String actual_trip_meeting_point_list_description;
    private String trip_booking_entity_name;
    private BookingDetailResponse.Departures.Participant_counters trip_booking_participant_counters;
    private Integer actual_trip_participant_presences;
    private String trip_booking_entity_customer_name;
    private String trip_booking_payment_type_name;
    private Double total_amount;
    private Double total_amount_net;
    private Double coupon_amount;
    private Double coupon_amount_net;
    private String trip_booking_note;
    private ArrayList<String> discount_ids;
    private ArrayList<String> active_trip_resource_ids;
    private ArrayList<String> trip_category_ids;
    private Date last_updated_at;
    private Date trip_booking_created_at;
    private Date trip_booking_updated_at;
    private Date created_at;
    private Date updated_at;
    private String trip_booking_created_by_name;
    private String trip_booking_entity_code;
    private String trip_booking_entity_customer_code;
    private String full_value;

    public String getTrip_booking_entity_customer_code() {
        return trip_booking_entity_customer_code;
    }

    public void setTrip_booking_entity_customer_code(String trip_booking_entity_customer_code) {
        this.trip_booking_entity_customer_code = trip_booking_entity_customer_code;
    }

    public String getTrip_booking_entity_code() {
        return trip_booking_entity_code;
    }

    public void setTrip_booking_entity_code(String trip_booking_entity_code) {
        this.trip_booking_entity_code = trip_booking_entity_code;
    }

    public String getTrip_booking_created_by_name() {
        return trip_booking_created_by_name;
    }

    public void setTrip_booking_created_by_name(String trip_booking_created_by_name) {
        this.trip_booking_created_by_name = trip_booking_created_by_name;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getTrip_booking_updated_at() {
        return trip_booking_updated_at;
    }

    public void setTrip_booking_updated_at(Date trip_booking_updated_at) {
        this.trip_booking_updated_at = trip_booking_updated_at;
    }

    public Date getTrip_booking_created_at() {
        return trip_booking_created_at;
    }

    public void setTrip_booking_created_at(Date trip_booking_created_at) {
        this.trip_booking_created_at = trip_booking_created_at;
    }

    public Date getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(Date last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    public ArrayList<String> getTrip_category_ids() {
        return trip_category_ids;
    }

    public void setTrip_category_ids(ArrayList<String> trip_category_ids) {
        this.trip_category_ids = trip_category_ids;
    }

    public ArrayList<String> getActive_trip_resource_ids() {
        return active_trip_resource_ids;
    }

    public void setActive_trip_resource_ids(ArrayList<String> active_trip_resource_ids) {
        this.active_trip_resource_ids = active_trip_resource_ids;
    }

    public ArrayList<String> getDiscount_ids() {
        return discount_ids;
    }

    public void setDiscount_ids(ArrayList<String> discount_ids) {
        this.discount_ids = discount_ids;
    }

    public String getTrip_booking_note() {
        return trip_booking_note;
    }

    public void setTrip_booking_note(String trip_booking_note) {
        this.trip_booking_note = trip_booking_note;
    }

    public Double getCoupon_amount_net() {
        return coupon_amount_net;
    }

    public void setCoupon_amount_net(Double coupon_amount_net) {
        this.coupon_amount_net = coupon_amount_net;
    }

    public Double getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(Double coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    public Double getTotal_amount_net() {
        return total_amount_net;
    }

    public void setTotal_amount_net(Double total_amount_net) {
        this.total_amount_net = total_amount_net;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getTrip_booking_payment_type_name() {
        return trip_booking_payment_type_name;
    }

    public void setTrip_booking_payment_type_name(String trip_booking_payment_type_name) {
        this.trip_booking_payment_type_name = trip_booking_payment_type_name;
    }

    public String getTrip_booking_entity_customer_name() {
        return trip_booking_entity_customer_name;
    }

    public void setTrip_booking_entity_customer_name(String trip_booking_entity_customer_name) {
        this.trip_booking_entity_customer_name = trip_booking_entity_customer_name;
    }

    public Integer getActual_trip_participant_presences() {
        return actual_trip_participant_presences;
    }

    public void setActual_trip_participant_presences(Integer actual_trip_participant_presences) {
        this.actual_trip_participant_presences = actual_trip_participant_presences;
    }

    public BookingDetailResponse.Departures.Participant_counters getTrip_booking_participant_counters() {
        return trip_booking_participant_counters;
    }

    public void setTrip_booking_participant_counters(BookingDetailResponse.Departures.Participant_counters trip_booking_participant_counters) {
        this.trip_booking_participant_counters = trip_booking_participant_counters;
    }

    public String getTrip_booking_entity_name() {
        return trip_booking_entity_name;
    }

    public void setTrip_booking_entity_name(String trip_booking_entity_name) {
        this.trip_booking_entity_name = trip_booking_entity_name;
    }

    public String getActual_trip_meeting_point_list_description() {
        return actual_trip_meeting_point_list_description;
    }

    public void setActual_trip_meeting_point_list_description(String actual_trip_meeting_point_list_description) {
        this.actual_trip_meeting_point_list_description = actual_trip_meeting_point_list_description;
    }

    public String getTrip_package_code() {
        return trip_package_code;
    }

    public void setTrip_package_code(String trip_package_code) {
        this.trip_package_code = trip_package_code;
    }

    public String getTrip_package_description() {
        return trip_package_description;
    }

    public void setTrip_package_description(String trip_package_description) {
        this.trip_package_description = trip_package_description;
    }

    public String getTrip_booking_branch_code() {
        return trip_booking_branch_code;
    }

    public void setTrip_booking_branch_code(String trip_booking_branch_code) {
        this.trip_booking_branch_code = trip_booking_branch_code;
    }

    public Date getTrip_booking_has_been_confirmed() {
        return trip_booking_has_been_confirmed;
    }

    public void setTrip_booking_has_been_confirmed(Date trip_booking_has_been_confirmed) {
        this.trip_booking_has_been_confirmed = trip_booking_has_been_confirmed;
    }

    public String getTrip_booking_status() {
        return trip_booking_status;
    }

    public void setTrip_booking_status(String trip_booking_status) {
        this.trip_booking_status = trip_booking_status;
    }

    public String getTrip_booking_origin_channel_code() {
        return trip_booking_origin_channel_code;
    }

    public void setTrip_booking_origin_channel_code(String trip_booking_origin_channel_code) {
        this.trip_booking_origin_channel_code = trip_booking_origin_channel_code;
    }

    public String getTrip_booking_created_by() {
        return trip_booking_created_by;
    }

    public void setTrip_booking_created_by(String trip_booking_created_by) {
        this.trip_booking_created_by = trip_booking_created_by;
    }

    public String getTrip_booking_entity_id() {
        return trip_booking_entity_id;
    }

    public void setTrip_booking_entity_id(String trip_booking_entity_id) {
        this.trip_booking_entity_id = trip_booking_entity_id;
    }

    public String getTrip_booking_entity_customer_id() {
        return trip_booking_entity_customer_id;
    }

    public void setTrip_booking_entity_customer_id(String trip_booking_entity_customer_id) {
        this.trip_booking_entity_customer_id = trip_booking_entity_customer_id;
    }

    public String getTrip_booking_origin_channel_booking_id() {
        return trip_booking_origin_channel_booking_id;
    }

    public void setTrip_booking_origin_channel_booking_id(String trip_booking_origin_channel_booking_id) {
        this.trip_booking_origin_channel_booking_id = trip_booking_origin_channel_booking_id;
    }

    public String getTrip_booking_origin_channel_voucher_code() {
        return trip_booking_origin_channel_voucher_code;
    }

    public void setTrip_booking_origin_channel_voucher_code(String trip_booking_origin_channel_voucher_code) {
        this.trip_booking_origin_channel_voucher_code = trip_booking_origin_channel_voucher_code;
    }

    public String getPratica_code() {
        return pratica_code;
    }

    public void setPratica_code(String pratica_code) {
        this.pratica_code = pratica_code;
    }

    public String getTrip_booking_booking_code() {
        return trip_booking_booking_code;
    }

    public void setTrip_booking_booking_code(String trip_booking_booking_code) {
        this.trip_booking_booking_code = trip_booking_booking_code;
    }

    public Integer getIs_return_trip_included() {
        return is_return_trip_included;
    }

    public void setIs_return_trip_included(Integer is_return_trip_included) {
        this.is_return_trip_included = is_return_trip_included;
    }

    public String getTrip_package_id() {
        return trip_package_id;
    }

    public void setTrip_package_id(String trip_package_id) {
        this.trip_package_id = trip_package_id;
    }

    public String getActual_trip_start_time() {
        return actual_trip_start_time;
    }

    public void setActual_trip_start_time(String actual_trip_start_time) {
        this.actual_trip_start_time = actual_trip_start_time;
    }

    public Date getActual_trip_start_day() {
        return actual_trip_start_day;
    }

    public void setActual_trip_start_day(Date actual_trip_start_day) {
        this.actual_trip_start_day = actual_trip_start_day;
    }

    public Date getTrip_booking_booking_date() {
        return trip_booking_booking_date;
    }

    public void setTrip_booking_booking_date(Date trip_booking_booking_date) {
        this.trip_booking_booking_date = trip_booking_booking_date;
    }

    public String getTrip_booking_payment_type_id() {
        return trip_booking_payment_type_id;
    }

    public void setTrip_booking_payment_type_id(String trip_booking_payment_type_id) {
        this.trip_booking_payment_type_id = trip_booking_payment_type_id;
    }

    public String getReturn_trip_booking_package_id() {
        return return_trip_booking_package_id;
    }

    public void setReturn_trip_booking_package_id(String return_trip_booking_package_id) {
        this.return_trip_booking_package_id = return_trip_booking_package_id;
    }

    public String getIncluded_actual_trip_return_id() {
        return included_actual_trip_return_id;
    }

    public void setIncluded_actual_trip_return_id(String included_actual_trip_return_id) {
        this.included_actual_trip_return_id = included_actual_trip_return_id;
    }

    public String getActual_trip_id() {
        return actual_trip_id;
    }

    public void setActual_trip_id(String actual_trip_id) {
        this.actual_trip_id = actual_trip_id;
    }

    public String getTrip_booking_package_id() {
        return trip_booking_package_id;
    }

    public void setTrip_booking_package_id(String trip_booking_package_id) {
        this.trip_booking_package_id = trip_booking_package_id;
    }

    public String getTrip_booking_id() {
        return trip_booking_id;
    }

    public void setTrip_booking_id(String trip_booking_id) {
        this.trip_booking_id = trip_booking_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_value() {
        return full_value;
    }

    public void setFull_value(String full_value) {
        this.full_value = full_value;
    }


    public static class PaymentData {
        private String transaction_id;
        private String payment_method;
        private String payment_method_title;
        private Date date_paid;

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getPayment_method_title() {
            return payment_method_title;
        }

        public void setPayment_method_title(String payment_method_title) {
            this.payment_method_title = payment_method_title;
        }

        public Date getDate_paid() {
            return date_paid;
        }

        public void setDate_paid(Date date_paid) {
            this.date_paid = date_paid;
        }
    }
}