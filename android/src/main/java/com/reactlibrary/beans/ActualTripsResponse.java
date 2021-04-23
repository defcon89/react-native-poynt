package com.reactlibrary.beans;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class ActualTripsResponse {

    @SerializedName("id")
    private String id;


    @SerializedName("code")
    private String code;

    @SerializedName("start_day")
    private Date start_day;

    @SerializedName("end_day")
    private Date end_day;

    @SerializedName("lenght")
    private int lenght;

    @SerializedName("type")
    private String type;

    @SerializedName("start_time")
    private String start_time;

    @SerializedName("end_time")
    private String end_time;

    @SerializedName("min_allotment")
    private Integer min_allotment;

    @SerializedName("max_allotment")
    private Integer max_allotment;

    @SerializedName("confirm_date")
    private Date confirm_date;

    @SerializedName("start_status")
    private String start_status;

    @SerializedName("note")
    private String note;

    @SerializedName("trip_package_id")
    private String trip_package_id;

    @SerializedName("consumed_allotment")
    private int consumed_allotment;

    @SerializedName("length_type")
    private String length_type;

    @SerializedName("meeting_point_list_id")
    private String meeting_point_list_id;

    @SerializedName("properties")
    private ActualTripProperties properties;

    @SerializedName("meeting_point_list_description")
    private String meeting_point_list_description;

    @SerializedName("total_participants")
    private Integer total_participants;

    @SerializedName("start_date_time")
    private Date start_date_time;

    @SerializedName("staff_elements")
    private ArrayList<Staff> staff_elements;

    @SerializedName("package")
    private TripPackagesResponse pckg;

    @SerializedName("resources")
    private ArrayList<Resource> resources;

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

    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public Date getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getMin_allotment() {
        return min_allotment;
    }

    public void setMin_allotment(int min_allotment) {
        this.min_allotment = min_allotment;
    }

    public Integer getMax_allotment() {
        return max_allotment;
    }

    public void setMax_allotment(int max_allotment) {
        this.max_allotment = max_allotment;
    }

    public Date getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(Date confirm_date) {
        this.confirm_date = confirm_date;
    }

    public String getStart_status() {
        return start_status;
    }

    public void setStart_status(String start_status) {
        this.start_status = start_status;
    }

    public Integer getTotal_participants() {
        if(total_participants == null) return getConsumed_allotment();
        return total_participants;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTrip_package_id() {
        return trip_package_id;
    }

    public void setTrip_package_id(String trip_package_id) {
        this.trip_package_id = trip_package_id;
    }

    public int getConsumed_allotment() {
        return consumed_allotment;
    }

    public void setConsumed_allotment(int consumed_allotment) {
        this.consumed_allotment = consumed_allotment;
    }

    public String getLength_type() {
        return length_type;
    }

    public void setLength_type(String length_type) {
        this.length_type = length_type;
    }

    public String getMeeting_point_list_id() {
        return meeting_point_list_id;
    }

    public void setMeeting_point_list_id(String meeting_point_list_id) {
        this.meeting_point_list_id = meeting_point_list_id;
    }

    public ActualTripProperties getProperties() {
        return properties;
    }

    public void setProperties(ActualTripProperties properties) {
        this.properties = properties;
    }

    public String getMeeting_point_list_description() {
        return meeting_point_list_description;
    }

    public void setMeeting_point_list_description(String meeting_point_list_description) {
        this.meeting_point_list_description = meeting_point_list_description;
    }

    public Date getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(Date start_date_time) {
        this.start_date_time = start_date_time;
    }

    public ArrayList<Staff> getStaff_elements() {
        return staff_elements;
    }

    public void setStaff_elements(ArrayList<Staff> staff_elements) {
        this.staff_elements = staff_elements;
    }

    public TripPackagesResponse getPckg() {
        return pckg;
    }

    public void setPckg(TripPackagesResponse pckg) {
        this.pckg = pckg;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public static class Pckg {

        @SerializedName("id")
        private String id;

        @SerializedName("code")
        private String code;

        @SerializedName("description")
        private String description;

        @SerializedName("publish_on_web")
        private int publish_on_web;

        @SerializedName("published_at")
        private Date published_at;

        @SerializedName("default_lang")
        private String default_lang;

        @SerializedName("properties")
        private TripPackageProperties properties;

        @SerializedName("active_language_codes")
        private ArrayList<String> active_language_codes;

        @SerializedName("max_people")
        private int max_people;

        @SerializedName("master_image")
        private String master_image;

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

        public String getDefault_lang() {
            return default_lang;
        }

        public void setDefault_lang(String default_lang) {
            this.default_lang = default_lang;
        }

        public TripPackageProperties getProperties() {
            return properties;
        }

        public void setProperties(TripPackageProperties properties) {
            this.properties = properties;
        }

        public ArrayList<String> getActive_language_codes() {
            return active_language_codes;
        }

        public void setActive_language_codes(ArrayList<String> active_language_codes) {
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
    }

    public static class Resource {

        @SerializedName("id")
        private String id;

        @SerializedName("code")
        private String code;

        @SerializedName("description")
        private String description;

        @SerializedName("full_description")
        private String full_description;

        @SerializedName("allotment_type")
        private String allotment_type;

        @SerializedName("properties")
        private TripResourceProperties properties;

        @SerializedName("active_language_codes")
        private ArrayList<String> active_language_codes;

        @SerializedName("pivot")
        private Pivot pivot;

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

        public String getAllotment_type() {
            return allotment_type;
        }

        public void setAllotment_type(String allotment_type) {
            this.allotment_type = allotment_type;
        }

        public TripResourceProperties getProperties() {
            return properties;
        }

        public void setProperties(TripResourceProperties properties) {
            this.properties = properties;
        }

        public ArrayList<String> getActive_language_codes() {
            return active_language_codes;
        }

        public void setActive_language_codes(ArrayList<String> active_language_codes) {
            this.active_language_codes = active_language_codes;
        }

        public Pivot getPivot() {
            return pivot;
        }

        public void setPivot(Pivot pivot) {
            this.pivot = pivot;
        }

        public static class Pivot {

            @SerializedName("trip_package_id")
            private String trip_package_id;

            @SerializedName("trip_resource_id")
            private String trip_resource_id;

            @SerializedName("optional_resource")
            private Integer optional_resource;

            @SerializedName("meeting_point_unified_list_id")
            private String meeting_point_unified_list_id;

            public String getTrip_package_id() {
                return trip_package_id;
            }

            public void setTrip_package_id(String trip_package_id) {
                this.trip_package_id = trip_package_id;
            }

            public String getTrip_resource_id() {
                return trip_resource_id;
            }

            public void setTrip_resource_id(String trip_resource_id) {
                this.trip_resource_id = trip_resource_id;
            }

            public Boolean isOptional_resource() {
                return optional_resource > 0;
            }

            public void setOptional_resource(Boolean optional_resource) {
                this.optional_resource = optional_resource ? 1 : 0;
            }

            public String getMeeting_point_unified_list_id() {
                return meeting_point_unified_list_id;
            }

            public void setMeeting_point_unified_list_id(String meeting_point_unified_list_id) {
                this.meeting_point_unified_list_id = meeting_point_unified_list_id;
            }
        }
    }

    public static class Staff {

        @SerializedName("id")
        private String id;

        @SerializedName("entity_staff_element_id")
        private String entity_staff_element_id;

        @SerializedName("list_id")
        private String list_id;

        @SerializedName("note")
        private String note;

        @SerializedName("entity_staff_element")
        private StaffElement entity_staff_element;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEntity_staff_element_id() {
            return entity_staff_element_id;
        }

        public void setEntity_staff_element_id(String entity_staff_element_id) {
            this.entity_staff_element_id = entity_staff_element_id;
        }

        public String getList_id() {
            return list_id;
        }

        public void setList_id(String list_id) {
            this.list_id = list_id;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public StaffElement getEntity_staff_element() {
            return entity_staff_element;
        }

        public void setEntity_staff_element(StaffElement entity_staff_element) {
            this.entity_staff_element = entity_staff_element;
        }


        public static class StaffElement {
            @SerializedName("id")
            private String id;

            @SerializedName("code")
            private String code;

            @SerializedName("entity_id")
            private String entity_id;

            @SerializedName("properties")
            private Properties properties;

            @SerializedName("description")
            private String description;

            @SerializedName("entity")
            private EntityResponse entity;

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

            public String getEntity_id() {
                return entity_id;
            }

            public void setEntity_id(String entity_id) {
                this.entity_id = entity_id;
            }

            public Properties getProperties() {
                return properties;
            }

            public void setProperties(Properties properties) {
                this.properties = properties;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public EntityResponse getEntity() {
                return entity;
            }

            public void setEntity(EntityResponse entity) {
                this.entity = entity;
            }

            public static class Properties{

                @SerializedName("staff_type")
                private StringProperty staff_type;

                public StringProperty getStaff_type() {
                    return staff_type;
                }

                public void setStaff_type(StringProperty staff_type) {
                    this.staff_type = staff_type;
                }
            }
        }

    }

}
