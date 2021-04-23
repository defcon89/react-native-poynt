package com.reactlibrary.beans;

import java.util.ArrayList;
import java.util.Date;

public class BookingDetailResponse {

    private Booking booking;
    private ArrayList<Participants> participants;
    private ArrayList<Departures> departures;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ArrayList<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participants> participants) {
        this.participants = participants;
    }

    public ArrayList<Departures> getDepartures() {
        return departures;
    }

    public void setDepartures(ArrayList<Departures> departures) {
        this.departures = departures;
    }


    static public class Booking {
        private String id;
        private String entity_customer_id;
        private String status;
        private String note;
        private Date created_at;
        private Date updated_at;
        private Date deleted_at;
        private String total_amount;
        private float participant_count;
        private String payment_type_id;
        private String entity_id;
        private Date booking_date;
        private String user_creator_id;
        private Date confirm_date;
        private Date paid_date;
        private Date cancel_date;
        private String discount_rule_list_id;
        private String participant_counters;
        private String booking_code;
        private float disable_export_sale_operation;
        private String filiale;
        private String total_amount_net;
        private String geo_position;
        private String ref_id;

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

        public void setDeleted_at(Date deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public float getParticipant_count() {
            return participant_count;
        }

        public void setParticipant_count(float participant_count) {
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

        public void setConfirm_date(Date confirm_date) {
            this.confirm_date = confirm_date;
        }

        public Date getPaid_date() {
            return paid_date;
        }

        public void setPaid_date(Date paid_date) {
            this.paid_date = paid_date;
        }

        public Date getCancel_date() {
            return cancel_date;
        }

        public void setCancel_date(Date cancel_date) {
            this.cancel_date = cancel_date;
        }

        public String getDiscount_rule_list_id() {
            return discount_rule_list_id;
        }

        public void setDiscount_rule_list_id(String discount_rule_list_id) {
            this.discount_rule_list_id = discount_rule_list_id;
        }

        public String getParticipant_counters() {
            return participant_counters;
        }

        public void setParticipant_counters(String participant_counters) {
            this.participant_counters = participant_counters;
        }

        public String getBooking_code() {
            return booking_code;
        }

        public void setBooking_code(String booking_code) {
            this.booking_code = booking_code;
        }

        public float getDisable_export_sale_operation() {
            return disable_export_sale_operation;
        }

        public void setDisable_export_sale_operation(float disable_export_sale_operation) {
            this.disable_export_sale_operation = disable_export_sale_operation;
        }

        public String getFiliale() {
            return filiale;
        }

        public void setFiliale(String filiale) {
            this.filiale = filiale;
        }

        public String getTotal_amount_net() {
            return total_amount_net;
        }

        public void setTotal_amount_net(String total_amount_net) {
            this.total_amount_net = total_amount_net;
        }

        public String getGeo_position() {
            return geo_position;
        }

        public void setGeo_position(String geo_position) {
            this.geo_position = geo_position;
        }

        public String getRef_id() {
            return ref_id;
        }

        public void setRef_id(String ref_id) {
            this.ref_id = ref_id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    static public class Participants {
        private String id;
        private String trip_booking_id;
        private String entity_id;
        private String description;
        private String age_range_code;
        private String meeting_point_id;
        private String return_point_id;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private String lang_code;
        private String nation_code;
        private String trip_booking_participant_ref_id;
        private float ticket_printed;
        private Nation nation;
        private Entity entity;
        private Domain domain;

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

        public String getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(String entity_id) {
            this.entity_id = entity_id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAge_range_code() {
            return age_range_code;
        }

        public void setAge_range_code(String age_range_code) {
            this.age_range_code = age_range_code;
        }

        public String getMeeting_point_id() {
            return meeting_point_id;
        }

        public void setMeeting_point_id(String meeting_point_id) {
            this.meeting_point_id = meeting_point_id;
        }

        public String getReturn_point_id() {
            return return_point_id;
        }

        public void setReturn_point_id(String return_point_id) {
            this.return_point_id = return_point_id;
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

        public String getLang_code() {
            return lang_code;
        }

        public void setLang_code(String lang_code) {
            this.lang_code = lang_code;
        }

        public String getNation_code() {
            return nation_code;
        }

        public void setNation_code(String nation_code) {
            this.nation_code = nation_code;
        }

        public String getTrip_booking_participant_ref_id() {
            return trip_booking_participant_ref_id;
        }

        public void setTrip_booking_participant_ref_id(String trip_booking_participant_ref_id) {
            this.trip_booking_participant_ref_id = trip_booking_participant_ref_id;
        }

        public float getTicket_printed() {
            return ticket_printed;
        }

        public void setTicket_printed(float ticket_printed) {
            this.ticket_printed = ticket_printed;
        }

        public Nation getNation() {
            return nation;
        }

        public void setNation(Nation nation) {
            this.nation = nation;
        }

        public Entity getEntity() {
            return entity;
        }

        public void setEntity(Entity entity) {
            this.entity = entity;
        }

        public Domain getDomain() {
            return domain;
        }

        public void setDomain(Domain domain) {
            this.domain = domain;
        }


        static public class Nation {
            private String id;
            private String code;
            private String description;
            private String continent;
            private String code_iso;
            private float extra_cee;
            private float black_list;
            private String created_at;
            private String updated_at;
            private String lang_code;

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

            public String getContinent() {
                return continent;
            }

            public void setContinent(String continent) {
                this.continent = continent;
            }

            public String getCode_iso() {
                return code_iso;
            }

            public void setCode_iso(String code_iso) {
                this.code_iso = code_iso;
            }

            public float getExtra_cee() {
                return extra_cee;
            }

            public void setExtra_cee(float extra_cee) {
                this.extra_cee = extra_cee;
            }

            public float getBlack_list() {
                return black_list;
            }

            public void setBlack_list(float black_list) {
                this.black_list = black_list;
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

            public String getLang_code() {
                return lang_code;
            }

            public void setLang_code(String lang_code) {
                this.lang_code = lang_code;
            }
        }

        static public class Entity {
            private String id;
            private String code;
            private String description;
            private String primary_email;
            private String piva;
            private String fiscal_code;
            private float natural_person;
            private String firstname;
            private String lastname;
            private String birth_location;
            private String birth_day;
            private String gender;
            private String user_id;
            private Date created_at;
            private Date updated_at;
            private String primary_address_id;
            private Date deleted_at;
            private String external_site_user_reference;
            private String external_site_user_name;
            private String external_site_user_created_at;
            private String contact_list_id;
            private String external_site_user_password;
            private String birth_province;
            private String website_url;
            private String contacts;
            private String accounting_email;
            private String operational_email;
            private String external_domain_id;
            private String phone_number;
            private String fax;
            private String reg_imp;
            private String cap_soc;
            private String cellphone;

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

            public String getPrimary_email() {
                return primary_email;
            }

            public void setPrimary_email(String primary_email) {
                this.primary_email = primary_email;
            }

            public String getPiva() {
                return piva;
            }

            public void setPiva(String piva) {
                this.piva = piva;
            }

            public String getFiscal_code() {
                return fiscal_code;
            }

            public void setFiscal_code(String fiscal_code) {
                this.fiscal_code = fiscal_code;
            }

            public float getNatural_person() {
                return natural_person;
            }

            public void setNatural_person(float natural_person) {
                this.natural_person = natural_person;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getBirth_location() {
                return birth_location;
            }

            public void setBirth_location(String birth_location) {
                this.birth_location = birth_location;
            }

            public String getBirth_day() {
                return birth_day;
            }

            public void setBirth_day(String birth_day) {
                this.birth_day = birth_day;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
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

            public String getPrimary_address_id() {
                return primary_address_id;
            }

            public void setPrimary_address_id(String primary_address_id) {
                this.primary_address_id = primary_address_id;
            }

            public Date getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Date deleted_at) {
                this.deleted_at = deleted_at;
            }

            public String getExternal_site_user_reference() {
                return external_site_user_reference;
            }

            public void setExternal_site_user_reference(String external_site_user_reference) {
                this.external_site_user_reference = external_site_user_reference;
            }

            public String getExternal_site_user_name() {
                return external_site_user_name;
            }

            public void setExternal_site_user_name(String external_site_user_name) {
                this.external_site_user_name = external_site_user_name;
            }

            public String getExternal_site_user_created_at() {
                return external_site_user_created_at;
            }

            public void setExternal_site_user_created_at(String external_site_user_created_at) {
                this.external_site_user_created_at = external_site_user_created_at;
            }

            public String getContact_list_id() {
                return contact_list_id;
            }

            public void setContact_list_id(String contact_list_id) {
                this.contact_list_id = contact_list_id;
            }

            public String getExternal_site_user_password() {
                return external_site_user_password;
            }

            public void setExternal_site_user_password(String external_site_user_password) {
                this.external_site_user_password = external_site_user_password;
            }

            public String getBirth_province() {
                return birth_province;
            }

            public void setBirth_province(String birth_province) {
                this.birth_province = birth_province;
            }

            public String getWebsite_url() {
                return website_url;
            }

            public void setWebsite_url(String website_url) {
                this.website_url = website_url;
            }

            public String getContacts() {
                return contacts;
            }

            public void setContacts(String contacts) {
                this.contacts = contacts;
            }

            public String getAccounting_email() {
                return accounting_email;
            }

            public void setAccounting_email(String accounting_email) {
                this.accounting_email = accounting_email;
            }

            public String getOperational_email() {
                return operational_email;
            }

            public void setOperational_email(String operational_email) {
                this.operational_email = operational_email;
            }

            public String getExternal_domain_id() {
                return external_domain_id;
            }

            public void setExternal_domain_id(String external_domain_id) {
                this.external_domain_id = external_domain_id;
            }

            public String getPhone_number() {
                return phone_number;
            }

            public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getReg_imp() {
                return reg_imp;
            }

            public void setReg_imp(String reg_imp) {
                this.reg_imp = reg_imp;
            }

            public String getCap_soc() {
                return cap_soc;
            }

            public void setCap_soc(String cap_soc) {
                this.cap_soc = cap_soc;
            }

            public String getCellphone() {
                return cellphone;
            }

            public void setCellphone(String cellphone) {
                this.cellphone = cellphone;
            }
        }

        static public class Domain {
            private String id;
            private String code;
            private String display_name;
            private String description;
            private float enabled;
            private String creator_id;
            private Date created_at;
            private Date updated_at;
            private String domain_path;
            private String entity_id;
            private String logo;
            private String laravel_through_key;

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

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public float getEnabled() {
                return enabled;
            }

            public void setEnabled(float enabled) {
                this.enabled = enabled;
            }

            public String getCreator_id() {
                return creator_id;
            }

            public void setCreator_id(String creator_id) {
                this.creator_id = creator_id;
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

            public String getDomain_path() {
                return domain_path;
            }

            public void setDomain_path(String domain_path) {
                this.domain_path = domain_path;
            }

            public String getEntity_id() {
                return entity_id;
            }

            public void setEntity_id(String entity_id) {
                this.entity_id = entity_id;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getLaravel_through_key() {
                return laravel_through_key;
            }

            public void setLaravel_through_key(String laravel_through_key) {
                this.laravel_through_key = laravel_through_key;
            }
        }
    }

    static public class Departures {
        private String id;
        private String trip_booking_id;
        private String trip_package_id;
        private String deleted_at;
        private String created_at;
        private String updated_at;
        private String actual_trip_id;
        Participant_counters participant_counters;
        private String default_meeting_point_list_item_id;
        private String ref_id;
        private String tour_operator_booking_ref;
        private String tour_operator_booking_status;
        private String tour_operator_booking_commit_status;
        private String tour_operator_booking_data;
        private ActualTripsResponse actual_trip;

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

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
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

        public String getActual_trip_id() {
            return actual_trip_id;
        }

        public void setActual_trip_id(String actual_trip_id) {
            this.actual_trip_id = actual_trip_id;
        }

        public Participant_counters getParticipant_counters() {
            return participant_counters;
        }

        public void setParticipant_counters(Participant_counters participant_counters) {
            this.participant_counters = participant_counters;
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

        public ActualTripsResponse getActual_trip() {
            return actual_trip;
        }

        public void setActual_trip(ActualTripsResponse actual_trip) {
            this.actual_trip = actual_trip;
        }

        static public class Participant_counters {
            private int total;
            private int ADT;
            private int SNR;
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

            public int getCHD() {
                return CHD;
            }

            public void setCHD(int CHD) {
                this.CHD = CHD;
            }

            public int getINF() {
                return INF;
            }

            public void setINF(int INF) {
                this.INF = INF;
            }
        }
    }
}
