package com.reactlibrary.beans;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class EntityResponse {
    @SerializedName("id")
    private String id;

    @SerializedName("code")
    private String code;

    @SerializedName("description")
    private String description;

    @SerializedName("primary_email")
    private String primary_email;

    @SerializedName("piva")
    private String piva;

    @SerializedName("fiscal_code")
    private String fiscal_code;

    @SerializedName("natural_person")
    private int natural_person;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;
    
    @SerializedName("birth_location")
    private String birth_location;
    
    @SerializedName("birth_day")
    private Date birth_day;
    
    @SerializedName("gender")
    private String gender;
    
    @SerializedName("user_id")
    private String user_id;

    @SerializedName("properties")
    private Properties properties;

    @SerializedName("primary_address")
    private PrimaryAddress primary_address;

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

    public int getNatural_person() {
        return natural_person;
    }

    public void setNatural_person(int natural_person) {
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
    
    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
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
    
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    
    public PrimaryAddress getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(PrimaryAddress primary_address) {
        this.primary_address = primary_address;
    }
    
    public static class PrimaryAddress {

        @SerializedName("id")
        private String id;

        
        @SerializedName("zip_code")
        private String zip_code;

        
        @SerializedName("city")
        private String city;

        
        @SerializedName("street")
        private String street;

        
        @SerializedName("number")
        private String number;

        
        @SerializedName("province")
        private String province;

        
        @SerializedName("locality")
        private String locality;

        
        @SerializedName("note")
        private String note;

        
        @SerializedName("nation_code")
        private String nation_code;

        
        @SerializedName("point_map_url")
        private String point_map_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        
        public String getZip_code() {
            return zip_code;
        }

        public void setZip_code( String zip_code) {
            this.zip_code = zip_code;
        }

        
        public String getCity() {
            return city;
        }

        public void setCity( String city) {
            this.city = city;
        }

        
        public String getStreet() {
            return street;
        }

        public void setStreet( String street) {
            this.street = street;
        }

        
        public String getNumber() {
            return number;
        }

        public void setNumber( String number) {
            this.number = number;
        }

        
        public String getProvince() {
            return province;
        }

        public void setProvince( String province) {
            this.province = province;
        }

        
        public String getLocality() {
            return locality;
        }

        public void setLocality( String locality) {
            this.locality = locality;
        }

        
        public String getNote() {
            return note;
        }

        public void setNote( String note) {
            this.note = note;
        }

        
        public String getNation_code() {
            return nation_code;
        }

        public void setNation_code( String nation_code) {
            this.nation_code = nation_code;
        }

        
        public String getPoint_map_url() {
            return point_map_url;
        }

        public void setPoint_map_url( String point_map_url) {
            this.point_map_url = point_map_url;
        }
    }

    public static class Properties{
        
        @SerializedName("created_from_billing")
        private StringProperty created_from_billing;

        
        public StringProperty getCreated_from_billing() {
            return created_from_billing;
        }

        public void setCreated_from_billing( StringProperty created_from_billing) {
            this.created_from_billing = created_from_billing;
        }
    }
}
