package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Nullable;


public class BookingPreviewResponse {

    @SerializedName("preview")
    private Preview preview;

    
    public static class Preview {

        @SerializedName("date")
        private Date date;

        @SerializedName("total_amount")
        private Double total_amount;

        @SerializedName("coupon_amount")
        private Double coupon_amount;

        @SerializedName("coupon_amount_netto")
        private Double coupon_amount_netto;

        @SerializedName("total_amount_netto")
        private Double total_amount_netto;

        @SerializedName("coupons")
        private ArrayList<Coupon> coupons;

        @SerializedName("trip")
        private Trip trip;

        @SerializedName("participants")
        private Participants participants;

        @SerializedName("candidate_return_trips")
        private ArrayList<ActualTripsResponse> candidate_return_trips;

        @SerializedName("errors")
        private ArrayList<String> errors;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Double getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(Double total_amount) {
            this.total_amount = total_amount;
        }

        public Double getCoupon_amount() {
            return coupon_amount;
        }

        public void setCoupon_amount(Double coupon_amount) {
            this.coupon_amount = coupon_amount;
        }

        public Double getCoupon_amount_netto() {
            return coupon_amount_netto;
        }

        public void setCoupon_amount_netto(Double coupon_amount_netto) {
            this.coupon_amount_netto = coupon_amount_netto;
        }

        public Double getTotal_amount_netto() {
            return total_amount_netto;
        }

        public void setTotal_amount_netto(Double total_amount_netto) {
            this.total_amount_netto = total_amount_netto;
        }

        public ArrayList<Coupon> getCoupons() {
            return coupons;
        }

        public void setCoupons(ArrayList<Coupon> coupons) {
            this.coupons = coupons;
        }

        public Trip getTrip() {
            return trip;
        }

        public void setTrip(Trip trip) {
            this.trip = trip;
        }

        public Participants getParticipants() {
            return participants;
        }

        public void setParticipants(Participants participants) {
            this.participants = participants;
        }

        public ArrayList<ActualTripsResponse> getCandidate_return_trips() {
            return candidate_return_trips;
        }

        public void setCandidate_return_trips(ArrayList<ActualTripsResponse> candidate_return_trips) {
            this.candidate_return_trips = candidate_return_trips;
        }

        public ArrayList<String> getErrors() {
            return errors;
        }

        public void setErrors(ArrayList<String> errors) {
            this.errors = errors;
        }

        
        public static class Coupon {

            @SerializedName("id")
            private String id;

            @SerializedName("name")
            private String name;

            @SerializedName("description")
            private String description;

            @SerializedName("code")
            private String code;

            @SerializedName("total")
            private Double total;

            @SerializedName("total_net")
            private Double total_net;

            public Double getTotal_net() {
                return total_net;
            }

            public void setTotal_net(Double total_net) {
                this.total_net = total_net;
            }

            public Double getTotal() {
                return total;
            }

            public void setTotal(Double total) {
                this.total = total;
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

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }
        }

        
        public static class Trip {

            @SerializedName("going")
            private Going going;

            @Nullable
            @SerializedName("return")
            private Return trip_return;

            @Nullable
            public Return getTrip_return() {
                return trip_return;
            }

            public void setTrip_return(@Nullable Return trip_return) {
                this.trip_return = trip_return;
            }

            public Going getGoing() {
                return going;
            }

            public void setGoing(Going going) {
                this.going = going;
            }


            
            public static class Return {

                @SerializedName("actual_trip")
                private ActualTripsResponse actual_trip;

                @SerializedName("resources")
                private ArrayList<Resource> resources;

                @SerializedName("meeting_point_unified_list_item_id")
                private String meeting_point_unified_list_item_id;

                public String getMeeting_point_unified_list_item_id() {
                    return meeting_point_unified_list_item_id;
                }

                public void setMeeting_point_unified_list_item_id(String meeting_point_unified_list_item_id) {
                    this.meeting_point_unified_list_item_id = meeting_point_unified_list_item_id;
                }

                public ArrayList<Resource> getResources() {
                    return resources;
                }

                public void setResources(ArrayList<Resource> resources) {
                    this.resources = resources;
                }

                public ActualTripsResponse getActual_trip() {
                    return actual_trip;
                }

                public void setActual_trip(ActualTripsResponse actual_trip) {
                    this.actual_trip = actual_trip;
                }
            }

            
            public static class Going {

                @SerializedName("actual_trip")
                private ActualTripsResponse actual_trip;

                @SerializedName("resources")
                private ArrayList<Resource> resources;

                @SerializedName("meeting_point_unified_list_item_id")
                private String meeting_point_unified_list_item_id;

                public String getMeeting_point_unified_list_item_id() {
                    return meeting_point_unified_list_item_id;
                }

                public void setMeeting_point_unified_list_item_id(String meeting_point_unified_list_item_id) {
                    this.meeting_point_unified_list_item_id = meeting_point_unified_list_item_id;
                }

                public ArrayList<Resource> getResources() {
                    return resources;
                }

                public void setResources(ArrayList<Resource> resources) {
                    this.resources = resources;
                }

                public ActualTripsResponse getActual_trip() {
                    return actual_trip;
                }

                public void setActual_trip(ActualTripsResponse actual_trip) {
                    this.actual_trip = actual_trip;
                }
            }

            
            public static class Resource {

                @SerializedName("trip_resource_id")
                private String trip_resource_id;

                @SerializedName("optional")
                private Integer optional;

                @SerializedName("activated")
                private Integer activated;

                @SerializedName("activable")
                private Integer activable;

                @Nullable
                @SerializedName("meeting_point_id")
                private String meeting_point_id;

                @Nullable
                @SerializedName("price")
                private Double price;

                @Nullable
                @SerializedName("price_netto")
                private Double price_netto;

                @Nullable
                public Double getPrice_netto() {
                    return price_netto;
                }

                public void setPrice_netto(@Nullable Double price_netto) {
                    this.price_netto = price_netto;
                }

                @Nullable
                public Double getPrice() {
                    return price;
                }

                public void setPrice(@Nullable Double price) {
                    this.price = price;
                }

                @Nullable
                public String getMeeting_point_id() {
                    return meeting_point_id;
                }

                public void setMeeting_point_id(@Nullable String meeting_point_id) {
                    this.meeting_point_id = meeting_point_id;
                }

                public Boolean isActivable() {
                    return activable > 0;
                }

                public void setActivable(Boolean activable) {
                    this.activable = activable ? 1 : 0;
                }

                public Boolean isActivated() {
                    return activated > 0;
                }

                public void setActivated(Boolean activated) {
                    this.activated = activated ? 1 : 0;
                }

                public Boolean isOptional() {
                    return optional > 0;
                }

                public void setOptional(Boolean optional) {
                    this.optional = optional ? 1 : 0;
                }

                public String getTrip_resource_id() {
                    return trip_resource_id;
                }

                public void setTrip_resource_id(String trip_resource_id) {
                    this.trip_resource_id = trip_resource_id;
                }
            }
        }

        
        public static class Participants{

            @SerializedName("ADT")
            private Integer ADT;

            @SerializedName("CHD")
            private Integer CHD;

            @SerializedName("INF")
            private Integer INF;

            @SerializedName("SNR")
            private Integer SNR;

            public Integer getSNR() {
                return SNR;
            }

            public void setSNR(Integer SNR) {
                this.SNR = SNR;
            }

            public Integer getINF() {
                return INF;
            }

            public void setINF(Integer INF) {
                this.INF = INF;
            }

            public Integer getCHD() {
                return CHD;
            }

            public void setCHD(Integer CHD) {
                this.CHD = CHD;
            }

            public Integer getADT() {
                return ADT;
            }

            public void setADT(Integer ADT) {
                this.ADT = ADT;
            }
        }
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }


    public boolean isInvalid(){
        return getPreview() == null || getPreview().getTotal_amount() == null || getPreview().getTrip() == null || getPreview().getTrip().getGoing() == null || getPreview().getErrors().size() > 0;
    }

    public boolean hasErrors(){
        return getPreview() != null && getPreview().getErrors() != null && getPreview().getErrors().size() > 0;
    }
}
