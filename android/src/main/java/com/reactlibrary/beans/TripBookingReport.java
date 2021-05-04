package com.reactlibrary.beans;

import java.util.Date;

public class TripBookingReport {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrip_booking_id() {
        return trip_booking_id;
    }

    public void setTrip_booking_id(String trip_booking_id) {
        this.trip_booking_id = trip_booking_id;
    }

    public String getTrip_package_id() {
        return trip_package_id;
    }

    public void setTrip_package_id(String trip_package_id) {
        this.trip_package_id = trip_package_id;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
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

    public String getActual_trip_id() {
        return actual_trip_id;
    }

    public void setActual_trip_id(String actual_trip_id) {
        this.actual_trip_id = actual_trip_id;
    }

    public String getDefault_meeting_point_list_item_id() {
        return default_meeting_point_list_item_id;
    }

    public void setDefault_meeting_point_list_item_id(String default_meeting_point_list_item_id) {
        this.default_meeting_point_list_item_id = default_meeting_point_list_item_id;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getTour_operator_booking_ref() {
        return tour_operator_booking_ref;
    }

    public void setTour_operator_booking_ref(String tour_operator_booking_ref) {
        this.tour_operator_booking_ref = tour_operator_booking_ref;
    }

    public String getTour_operator_booking_status() {
        return tour_operator_booking_status;
    }

    public void setTour_operator_booking_status(String tour_operator_booking_status) {
        this.tour_operator_booking_status = tour_operator_booking_status;
    }

    public String getTour_operator_booking_commit_status() {
        return tour_operator_booking_commit_status;
    }

    public void setTour_operator_booking_commit_status(String tour_operator_booking_commit_status) {
        this.tour_operator_booking_commit_status = tour_operator_booking_commit_status;
    }

    public String getTour_operator_booking_data() {
        return tour_operator_booking_data;
    }

    public void setTour_operator_booking_data(String tour_operator_booking_data) {
        this.tour_operator_booking_data = tour_operator_booking_data;
    }

    public Integer getParticipant_presences() {
        return participant_presences;
    }

    public void setParticipant_presences(Integer participant_presences) {
        this.participant_presences = participant_presences;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Double getTotal_amount_net() {
        return total_amount_net;
    }

    public void setTotal_amount_net(Double total_amount_net) {
        this.total_amount_net = total_amount_net;
    }

    public BookingDetailResponse.Departures.Participant_counters getParticipant_counters() {
        return participant_counters;
    }

    public void setParticipant_counters(BookingDetailResponse.Departures.Participant_counters participant_counters) {
        this.participant_counters = participant_counters;
    }

    public BookingResponse.TripBooking getTrip_booking() {
        return trip_booking;
    }

    public void setTrip_booking(BookingResponse.TripBooking trip_booking) {
        this.trip_booking = trip_booking;
    }

    public TripPackagesResponse getTrip_package() {
        return trip_package;
    }

    public void setTrip_package(TripPackagesResponse trip_package) {
        this.trip_package = trip_package;
    }

    public ActualTripsResponse getActual_trip() {
        return actual_trip;
    }

    public void setActual_trip(ActualTripsResponse actual_trip) {
        this.actual_trip = actual_trip;
    }

    private String trip_booking_id;
    private String trip_package_id;
    private Date deleted_at;
    private Date created_at;
    private Date updated_at;
    private String actual_trip_id;
    private String default_meeting_point_list_item_id;
    private String ref_id;
    private String tour_operator_booking_ref;
    private String tour_operator_booking_status;
    private String tour_operator_booking_commit_status;
    private String tour_operator_booking_data;
    private Integer participant_presences;
    private Double total_amount;
    private Double total_amount_net;
    private Double coupon_amount;
    private BookingDetailResponse.Departures.Participant_counters participant_counters;
    private BookingResponse.TripBooking trip_booking;
    private TripPackagesResponse trip_package;
    private ActualTripsResponse actual_trip;

    public Double getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(Double coupon_amount) {
        this.coupon_amount = coupon_amount;
    }
}
