package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;


public class BookingResponse {


    @SerializedName("trip_booking")
    private TripBooking tripBooking;

    @SerializedName("tickets")
    private List<Ticket> tickets;

    public TripBooking getTripBooking() {
        return tripBooking;
    }

    public void setTripBooking(TripBooking tripBooking) {
        this.tripBooking = tripBooking;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    
    public static class Ticket{
        @SerializedName("trip_booking_participant_id")
        private String trip_booking_participant_id;

        @SerializedName("age_range_code")
        private String age_range_code;

        @SerializedName("price")
        private String price;

        public String getAgeRangeCode() {
            return age_range_code;
        }

        public String getPrice() {
            return price;
        }

        public String getTrip_booking_participant_id() {
            return trip_booking_participant_id;
        }
    }

    @SuppressWarnings("unused")
    
    public static class TripBooking {

        @SerializedName("id")
        private String id;

        @SerializedName("entity_customer_id")
        private String entity_customer_id;

        @SerializedName("status")
        private String status;

        @SerializedName("note")
        private String note;

        @SerializedName("created_at")
        private Date created_at;

        @SerializedName("updated_at")
        private Date updated_at;

        @SerializedName("deleted_at")
        private Date deleted_at;

        @SerializedName("total_amount")
        private Double total_amount;

        @SerializedName("participant_count")
        private Integer participant_count;

        @SerializedName("payment_type_id")
        private String payment_type_id;

        @SerializedName("entity_id")
        private String entity_id;

        @SerializedName("booking_date")
        private Date booking_date;

        @SerializedName("user_creator_id")
        private String user_creator_id;

        
        @SerializedName("confirm_date")
        private Date confirm_date;

        
        @SerializedName("paid_date")
        private Date paid_date;

        
        @SerializedName("cancel_date")
        private Date cancel_date;

        
        @SerializedName("discount_rule_list_id")
        private String discount_rule_list_id;

        @SerializedName("participant_counters")
        private ParticipantCountersBean participant_counters;

        @SerializedName("booking_code")
        private String booking_code;

        @SerializedName("disable_export_sale_operation")
        private int disable_export_sale_operation;

        
        @SerializedName("filiale")
        private String filiale;

        @SerializedName("total_amount_net")
        private Double total_amount_net;

        @SerializedName("properties")
        private TripBookingPropertiesBean properties;

        @SerializedName("allowed_actions")
        private List<String> allowed_actions;

        @SerializedName("packages")
        private List<TripBookingPackage> packages;

        @SerializedName("participants")
        private List<TripBookingParticipant> participants;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEntity_customer_id() {
            return entity_customer_id;
        }

        public void setEntity_customer_id(String entity_customer_id) {
            this.entity_customer_id = entity_customer_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
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

        public Double getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(Double total_amount) {
            this.total_amount = total_amount;
        }

        public int getParticipant_count() {
            return participant_count;
        }

        public void setParticipant_count(int participant_count) {
            this.participant_count = participant_count;
        }

        public String getPayment_type_id() {
            return payment_type_id;
        }

        public void setPayment_type_id(String payment_type_id) {
            this.payment_type_id = payment_type_id;
        }

        public String getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(String entity_id) {
            this.entity_id = entity_id;
        }

        public Date getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(Date booking_date) {
            this.booking_date = booking_date;
        }

        public String getUser_creator_id() {
            return user_creator_id;
        }

        public void setUser_creator_id(String user_creator_id) {
            this.user_creator_id = user_creator_id;
        }

        
        public Date getConfirm_date() {
            return confirm_date;
        }

        public void setConfirm_date( Date confirm_date) {
            this.confirm_date = confirm_date;
        }

        
        public Date getPaid_date() {
            return paid_date;
        }

        public void setPaid_date( Date paid_date) {
            this.paid_date = paid_date;
        }

        
        public Date getCancel_date() {
            return cancel_date;
        }

        public void setCancel_date( Date cancel_date) {
            this.cancel_date = cancel_date;
        }

        
        public String getDiscount_rule_list_id() {
            return discount_rule_list_id;
        }

        public void setDiscount_rule_list_id( String discount_rule_list_id) {
            this.discount_rule_list_id = discount_rule_list_id;
        }

        public ParticipantCountersBean getParticipant_counters() {
            return participant_counters;
        }

        public void setParticipant_counters(ParticipantCountersBean participant_counters) {
            this.participant_counters = participant_counters;
        }

        public String getBooking_code() {
            return booking_code;
        }

        public void setBooking_code(String booking_code) {
            this.booking_code = booking_code;
        }

        public int getDisable_export_sale_operation() {
            return disable_export_sale_operation;
        }

        public void setDisable_export_sale_operation(int disable_export_sale_operation) {
            this.disable_export_sale_operation = disable_export_sale_operation;
        }

        
        public String getFiliale() {
            return filiale;
        }

        public void setFiliale( String filiale) {
            this.filiale = filiale;
        }

        public Double getTotal_amount_net() {
            return total_amount_net;
        }

        public void setTotal_amount_net(Double total_amount_net) {
            this.total_amount_net = total_amount_net;
        }

        public TripBookingPropertiesBean getProperties() {
            return properties;
        }

        public void setProperties(TripBookingPropertiesBean properties) {
            this.properties = properties;
        }

        public List<String> getAllowed_actions() {
            return allowed_actions;
        }

        public void setAllowed_actions(List<String> allowed_actions) {
            this.allowed_actions = allowed_actions;
        }

        public List<TripBookingPackage> getPackages() {
            return packages;
        }

        public List<TripBookingParticipant> getParticipants() {
            return participants;
        }

        
        public static class ParticipantCountersBean {

            private int total;
            private int SNR;
            private int ADT;
            private int CHD;
            private int INF;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getADT() {
                return ADT;
            }

            public void setADT(int ADT) {
                this.ADT = ADT;
            }

            public int getSNR() {
                return SNR;
            }

            public void setSNR(int SNR) {
                this.SNR = SNR;
            }

            public int getINF() {
                return INF;
            }

            public void setINF(int INF) {
                this.INF = INF;
            }

            public int getCHD() {
                return CHD;
            }

            public void setCHD(int CHD) {
                this.CHD = CHD;
            }
        }

        
        public static class TripBookingPropertiesBean {

        }

        @SuppressWarnings("unused")
        
        public static class TripBookingPackage {

            /**
             * id : f521a496-ef1a-4480-945a-ca7a3f67530e
             * trip_booking_id : 344cd817-88c6-4d5e-8967-6500e9b9287f
             * trip_package_id : 396d0162-3771-4ec1-b485-088f771ffc30
             * deleted_at : null
             * created_at : 2020-02-12T14:41:32.000000Z
             * updated_at : 2020-02-12T14:41:35.000000Z
             * actual_trip_id : fdb31c68-f324-4dc4-a9e5-b0356f5907c0
             * participant_counters : {"total":3,"ADT":3}
             * default_meeting_point_list_item_id : 076a2f96-46d0-4ded-a29c-4ad4b47c99f0
             * properties : {"failed_checks":{"property_definition_id":"9d6ee2a4-ed23-4cce-9c78-cfe705759571","name":"Controlli Falliti","value":null,"type":"json"},"free_allotments":{"property_definition_id":"ef50dbb1-52ad-40d4-8df1-01b03c58da90","name":"Posti Liberi","value":null,"type":"number"},"going_trip_booking_package_id":{"property_definition_id":"71848e54-e8eb-4c79-bdc1-1681a03af834","name":"Id of going trip_booking_packages, if setted mean this is a return included","value":null,"type":"string"},"is_return_trip_included":{"property_definition_id":"2fb7caf6-33dd-45c4-a773-6767fc43bb41","name":"Questo pacchetto è un ritorno incluso","value":null,"type":"number"},"pratica_code":{"property_definition_id":"0395c442-5539-4055-861e-29202c4ba5fd","name":"pratica_code","value":null,"type":"string"},"remain_allotments":{"property_definition_id":"4a12a5f9-695d-4c16-809b-2d0098b9155b","name":"remain_allotments","value":null,"type":"string"},"return_trip_booking_package_id":{"property_definition_id":"6df367fa-82df-45d3-aa35-607fa12f7244","name":"Id of return trip_booking_packages, if setted mean this is a going trip","value":null,"type":"string"}}
             * allowed_actions : ["delete","edit","view_detail"]
             */

            @SerializedName("id")
            private String id;

            @SerializedName("trip_booking_id")
            private String trip_booking_id;

            @SerializedName("trip_package_id")
            private String trip_package_id;

            @SerializedName("deleted_at")
            private Date deleted_at;

            @SerializedName("created_at")
            private Date created_at;

            @SerializedName("updated_at")
            private Date updated_at;

            @SerializedName("actual_trip_id")
            private String actual_trip_id;

            
            @SerializedName("actual_trip")
            private ActualTripsResponse actual_trip;

            
            @SerializedName("trip_package")
            private TripPackagesResponse trip_package;

            @SerializedName("participant_counters")
            private ParticipantCountersBean participant_counters;

            @SerializedName("default_meeting_point_list_item_id")
            private String default_meeting_point_list_item_id;

            @SerializedName("properties")
            private TripBookingPackageProperties properties;

            @SerializedName("allowed_actions")
            private List<String> allowed_actions;

            @SerializedName("trip_booking_resources")
            private List<TripBookingResource> trip_booking_resources;

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

            public Object getDeleted_at() {
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

            public ActualTripsResponse getActual_trip() {
                return actual_trip;
            }

            public void setActual_trip(ActualTripsResponse actual_trip) {
                this.actual_trip = actual_trip;
            }

            public TripPackagesResponse getTrip_package() {
                return trip_package;
            }

            public void setTrip_package(TripPackagesResponse trip_package) {
                this.trip_package = trip_package;
            }

            public ParticipantCountersBean getParticipant_counters() {
                return participant_counters;
            }

            public void setParticipant_counters(ParticipantCountersBean participant_counters) {
                this.participant_counters = participant_counters;
            }

            public String getDefault_meeting_point_list_item_id() {
                return default_meeting_point_list_item_id;
            }

            public void setDefault_meeting_point_list_item_id(String default_meeting_point_list_item_id) {
                this.default_meeting_point_list_item_id = default_meeting_point_list_item_id;
            }

            public TripBookingPackageProperties getProperties() {
                return properties;
            }

            public void setProperties(TripBookingPackageProperties properties) {
                this.properties = properties;
            }

            public List<String> getAllowed_actions() {
                return allowed_actions;
            }

            public void setAllowed_actions(List<String> allowed_actions) {
                this.allowed_actions = allowed_actions;
            }

            
            public static class TripBookingResource {

                /**
                 * id : 2f594540-634c-4985-8792-a0a12e306649
                 * trip_booking_package_id : f521a496-ef1a-4480-945a-ca7a3f67530e
                 * trip_resource_id : bcf4ae60-423a-403c-8b68-83d996893cbe
                 * optional : 0
                 * activated : 1
                 * deleted_at : null
                 * created_at : 2020-02-12T14:41:33.000000Z
                 * updated_at : 2020-02-12T14:41:35.000000Z
                 * participant_counters : {"total":3,"ADT":3}
                 * trip_booking_id : 344cd817-88c6-4d5e-8967-6500e9b9287f
                 * properties : {"free_allotments":{"property_definition_id":"239a4bb3-629c-44cf-9a49-ecce6184e748","name":"Posti Liberi","value":null,"type":"number"},"is_return_trip_included":{"property_definition_id":"91e5ff44-6a96-4ad2-8c44-196c7ffe2786","name":"Questa risorsa è di un ritorno incluso","value":null,"type":"number"},"meeting_point_id":{"property_definition_id":"da7a6f8b-f2ec-4193-bea8-0569ba97dde5","name":"Punto di ritrovo selezionato","value":null,"type":"string"},"remain_allotments":{"property_definition_id":"e26a9b6a-d96f-42c5-9c24-8190c58320c2","name":"remain_allotments","value":null,"type":"string"}}
                 * allowed_actions : ["delete","edit","view_detail"]
                 * total_amount : 0
                 * max_allotment : -1
                 * trip_resource : {"id":"bcf4ae60-423a-403c-8b68-83d996893cbe","code":"000153","description":"Accompagnatore FP IVREA","full_description":"Accompagnatore FP IVREA","created_at":"2019-12-05T11:40:27.000000Z","updated_at":"2019-12-05T11:40:27.000000Z","deleted_at":null,"trip_service_catalog_list_id":null,"allotment_type":"free","staff_list_id":null,"entity_supplier_id":null,"properties":{"adult_to":{"property_definition_id":"4508ab44-d64d-45b6-a09c-3ab01e790f01","name":"Adulti fino a","value":null,"type":"number"},"allow_no_allotment_rule":{"property_definition_id":"26bdbdd9-89a1-4e67-8478-e1722edde8f0","name":"Permetti nessun allotment","value":null,"type":"number"},"child_from":{"property_definition_id":"d28861aa-924d-4422-b62e-e767540f95ed","name":"Bambini da","value":null,"type":"number"},"child_to":{"property_definition_id":"8523540c-0045-4930-9e3a-8af44eec94e2","name":"Bambini fino a","value":null,"type":"number"},"price":{"property_definition_id":"cefcff26-bf22-409e-a278-a7cafe7ce843","name":"Prezzo","value":null,"type":"number"},"resource_sub_types":{"property_definition_id":"bae8d7ef-8ef1-4967-8d30-f19f11acf847","name":"Tipologia","value":"ACC","type":"string"},"resource_type":{"property_definition_id":"130f8543-5975-4835-b2e8-ca096dff19f8","name":"Tipo Risorsa","value":"accompagnatore/guida","type":"option_value","label":"Accompagnatore/Guida"},"synchronized_at":{"property_definition_id":"b8b48f65-9001-4069-a6bc-0740bc2fc2de","name":"Data Ultima Sincronizzazione","value":"2020-02-12 00:15:27","type":"string"}},"allowed_actions":["delete","edit","view_detail"],"active_language_codes":[]}
                 */

                private String id;
                private String trip_booking_package_id;
                private String trip_resource_id;
                private int optional;
                private int activated;
                private Date deleted_at;
                private Date created_at;
                private Date updated_at;
                private ParticipantCountersBean participant_counters;
                private String trip_booking_id;
                private TripBookingResourceProperties properties;
                private int total_amount;
                private int max_allotment;
                private TripResourceBean trip_resource;
                private List<String> allowed_actions;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTrip_booking_package_id() {
                    return trip_booking_package_id;
                }

                public void setTrip_booking_package_id(String trip_booking_package_id) {
                    this.trip_booking_package_id = trip_booking_package_id;
                }

                public String getTrip_resource_id() {
                    return trip_resource_id;
                }

                public void setTrip_resource_id(String trip_resource_id) {
                    this.trip_resource_id = trip_resource_id;
                }

                public int getOptional() {
                    return optional;
                }

                public void setOptional(int optional) {
                    this.optional = optional;
                }

                public int getActivated() {
                    return activated;
                }

                public void setActivated(int activated) {
                    this.activated = activated;
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

                public ParticipantCountersBean getParticipant_counters() {
                    return participant_counters;
                }

                public void setParticipant_counters(ParticipantCountersBean participant_counters) {
                    this.participant_counters = participant_counters;
                }

                public String getTrip_booking_id() {
                    return trip_booking_id;
                }

                public void setTrip_booking_id(String trip_booking_id) {
                    this.trip_booking_id = trip_booking_id;
                }

                public TripBookingResourceProperties getProperties() {
                    return properties;
                }

                public void setProperties(TripBookingResourceProperties properties) {
                    this.properties = properties;
                }

                public int getTotal_amount() {
                    return total_amount;
                }

                public void setTotal_amount(int total_amount) {
                    this.total_amount = total_amount;
                }

                public int getMax_allotment() {
                    return max_allotment;
                }

                public void setMax_allotment(int max_allotment) {
                    this.max_allotment = max_allotment;
                }

                public TripResourceBean getTrip_resource() {
                    return trip_resource;
                }

                public void setTrip_resource(TripResourceBean trip_resource) {
                    this.trip_resource = trip_resource;
                }

                public List<String> getAllowed_actions() {
                    return allowed_actions;
                }

                public void setAllowed_actions(List<String> allowed_actions) {
                    this.allowed_actions = allowed_actions;
                }

                
                public static class TripResourceBean {
                    /**
                     * id : bcf4ae60-423a-403c-8b68-83d996893cbe
                     * code : 000153
                     * description : Accompagnatore FP IVREA
                     * full_description : Accompagnatore FP IVREA
                     * created_at : 2019-12-05T11:40:27.000000Z
                     * updated_at : 2019-12-05T11:40:27.000000Z
                     * deleted_at : null
                     * trip_service_catalog_list_id : null
                     * allotment_type : free
                     * staff_list_id : null
                     * entity_supplier_id : null
                     * properties : {"adult_to":{"property_definition_id":"4508ab44-d64d-45b6-a09c-3ab01e790f01","name":"Adulti fino a","value":null,"type":"number"},"allow_no_allotment_rule":{"property_definition_id":"26bdbdd9-89a1-4e67-8478-e1722edde8f0","name":"Permetti nessun allotment","value":null,"type":"number"},"child_from":{"property_definition_id":"d28861aa-924d-4422-b62e-e767540f95ed","name":"Bambini da","value":null,"type":"number"},"child_to":{"property_definition_id":"8523540c-0045-4930-9e3a-8af44eec94e2","name":"Bambini fino a","value":null,"type":"number"},"price":{"property_definition_id":"cefcff26-bf22-409e-a278-a7cafe7ce843","name":"Prezzo","value":null,"type":"number"},"resource_sub_types":{"property_definition_id":"bae8d7ef-8ef1-4967-8d30-f19f11acf847","name":"Tipologia","value":"ACC","type":"string"},"resource_type":{"property_definition_id":"130f8543-5975-4835-b2e8-ca096dff19f8","name":"Tipo Risorsa","value":"accompagnatore/guida","type":"option_value","label":"Accompagnatore/Guida"},"synchronized_at":{"property_definition_id":"b8b48f65-9001-4069-a6bc-0740bc2fc2de","name":"Data Ultima Sincronizzazione","value":"2020-02-12 00:15:27","type":"string"}}
                     * allowed_actions : ["delete","edit","view_detail"]
                     * active_language_codes : []
                     */

                    private String id;
                    private String code;
                    private String description;
                    private String full_description;
                    private String created_at;
                    private String updated_at;
                    private String deleted_at;
                    private String trip_service_catalog_list_id;
                    private String allotment_type;
                    private String staff_list_id;
                    private String entity_supplier_id;
                    private TripResourceProperties properties;
                    private List<String> allowed_actions;
                    private List<String> active_language_codes;

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

                    public String getFull_description() {
                        return full_description;
                    }

                    public void setFull_description(String full_description) {
                        this.full_description = full_description;
                    }

                    public String getCreated_at() {
                        return created_at;
                    }

                    public void setCreated_at(String created_at) {
                        this.created_at = created_at;
                    }

                    public String getUpdated_at() {
                        return updated_at;
                    }

                    public void setUpdated_at(String updated_at) {
                        this.updated_at = updated_at;
                    }

                    public String getDeleted_at() {
                        return deleted_at;
                    }

                    public void setDeleted_at(String deleted_at) {
                        this.deleted_at = deleted_at;
                    }

                    public String getTrip_service_catalog_list_id() {
                        return trip_service_catalog_list_id;
                    }

                    public void setTrip_service_catalog_list_id(String trip_service_catalog_list_id) {
                        this.trip_service_catalog_list_id = trip_service_catalog_list_id;
                    }

                    public String getAllotment_type() {
                        return allotment_type;
                    }

                    public void setAllotment_type(String allotment_type) {
                        this.allotment_type = allotment_type;
                    }

                    public String getStaff_list_id() {
                        return staff_list_id;
                    }

                    public void setStaff_list_id(String staff_list_id) {
                        this.staff_list_id = staff_list_id;
                    }

                    public String getEntity_supplier_id() {
                        return entity_supplier_id;
                    }

                    public void setEntity_supplier_id(String entity_supplier_id) {
                        this.entity_supplier_id = entity_supplier_id;
                    }

                    public TripResourceProperties getProperties() {
                        return properties;
                    }

                    public void setProperties(TripResourceProperties properties) {
                        this.properties = properties;
                    }

                    public List<String> getAllowed_actions() {
                        return allowed_actions;
                    }

                    public void setAllowed_actions(List<String> allowed_actions) {
                        this.allowed_actions = allowed_actions;
                    }

                    public List<?> getActive_language_codes() {
                        return active_language_codes;
                    }

                    public void setActive_language_codes(List<String> active_language_codes) {
                        this.active_language_codes = active_language_codes;
                    }
                }
            }
        }

        
        public static class TripBookingParticipant {
            @SerializedName("id")
            private String id;
            @SerializedName("age_range_code")
            private String age_range_code;

            public String getId() {
                return id;
            }

            public String getAgeRangeCode() {
                return age_range_code;
            }

            
            public Ticket getTicket(List<Ticket> tickets) {
                if(tickets == null) return null;

                for (BookingResponse.Ticket ticket: tickets) {
                    if(this.getId().equals(ticket.getTrip_booking_participant_id())) return ticket;
                }
                return null;
            }
        }
    }


}
