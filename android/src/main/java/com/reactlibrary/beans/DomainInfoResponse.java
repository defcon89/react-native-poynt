package com.reactlibrary.beans;

public class DomainInfoResponse {

    private String id;
    private String display_name;
    private String logo_file_id;
    Entity entity;


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getLogo_file_id() {
        return logo_file_id;
    }

    public Entity getEntity() {
        return entity;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setLogo_file_id(String logo_file_id) {
        this.logo_file_id = logo_file_id;
    }

    public void setEntity(Entity entityObject) {
        this.entity = entityObject;
    }

    public static class Entity {
        private String id;
        private String code;
        private String description;
        private String primary_email;
        private String piva;
        private String fiscal_code;
        private float natural_person;
        private String firstname = null;
        private String lastname = null;
        private String birth_location = null;
        private String birth_day = null;
        private String gender = null;
        private String user_id = null;
        private String created_at;
        private String updated_at;
        private String primary_address_id;
        private String deleted_at = null;
        private String external_site_user_reference = null;
        private String external_site_user_name = null;
        private String external_site_user_created_at = null;
        private String contact_list_id;
        private String external_site_user_password = null;
        private String birth_province = null;
        private String website_url;
        Contacts contacts;
        private String accounting_email = null;
        private String operational_email = null;
        private String external_domain_id = null;
        private String phone_number;
        private String fax;
        private String reg_imp;
        private String cap_soc;
        private String cellphone;
        Primary_address primary_address;
        Domain domain;


        // Getter Methods

        public String getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public String getPrimary_email() {
            return primary_email;
        }

        public String getPiva() {
            return piva;
        }

        public String getFiscal_code() {
            return fiscal_code;
        }

        public float getNatural_person() {
            return natural_person;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getBirth_location() {
            return birth_location;
        }

        public String getBirth_day() {
            return birth_day;
        }

        public String getGender() {
            return gender;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getPrimary_address_id() {
            return primary_address_id;
        }

        public String getDeleted_at() {
            return deleted_at;
        }

        public String getExternal_site_user_reference() {
            return external_site_user_reference;
        }

        public String getExternal_site_user_name() {
            return external_site_user_name;
        }

        public String getExternal_site_user_created_at() {
            return external_site_user_created_at;
        }

        public String getContact_list_id() {
            return contact_list_id;
        }

        public String getExternal_site_user_password() {
            return external_site_user_password;
        }

        public String getBirth_province() {
            return birth_province;
        }

        public String getWebsite_url() {
            return website_url;
        }

        public Contacts getContacts() {
            return contacts;
        }

        public String getAccounting_email() {
            return accounting_email;
        }

        public String getOperational_email() {
            return operational_email;
        }

        public String getExternal_domain_id() {
            return external_domain_id;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public String getFax() {
            return fax;
        }

        public String getReg_imp() {
            return reg_imp;
        }

        public String getCap_soc() {
            return cap_soc;
        }

        public String getCellphone() {
            return cellphone;
        }

        public Primary_address getPrimary_address() {
            return primary_address;
        }

        public Domain getDomain() {
            return domain;
        }

        // Setter Methods

        public void setId(String id) {
            this.id = id;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrimary_email(String primary_email) {
            this.primary_email = primary_email;
        }

        public void setPiva(String piva) {
            this.piva = piva;
        }

        public void setFiscal_code(String fiscal_code) {
            this.fiscal_code = fiscal_code;
        }

        public void setNatural_person(float natural_person) {
            this.natural_person = natural_person;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public void setBirth_location(String birth_location) {
            this.birth_location = birth_location;
        }

        public void setBirth_day(String birth_day) {
            this.birth_day = birth_day;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public void setPrimary_address_id(String primary_address_id) {
            this.primary_address_id = primary_address_id;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public void setExternal_site_user_reference(String external_site_user_reference) {
            this.external_site_user_reference = external_site_user_reference;
        }

        public void setExternal_site_user_name(String external_site_user_name) {
            this.external_site_user_name = external_site_user_name;
        }

        public void setExternal_site_user_created_at(String external_site_user_created_at) {
            this.external_site_user_created_at = external_site_user_created_at;
        }

        public void setContact_list_id(String contact_list_id) {
            this.contact_list_id = contact_list_id;
        }

        public void setExternal_site_user_password(String external_site_user_password) {
            this.external_site_user_password = external_site_user_password;
        }

        public void setBirth_province(String birth_province) {
            this.birth_province = birth_province;
        }

        public void setWebsite_url(String website_url) {
            this.website_url = website_url;
        }

        public void setContacts(Contacts contactsObject) {
            this.contacts = contactsObject;
        }

        public void setAccounting_email(String accounting_email) {
            this.accounting_email = accounting_email;
        }

        public void setOperational_email(String operational_email) {
            this.operational_email = operational_email;
        }

        public void setExternal_domain_id(String external_domain_id) {
            this.external_domain_id = external_domain_id;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public void setReg_imp(String reg_imp) {
            this.reg_imp = reg_imp;
        }

        public void setCap_soc(String cap_soc) {
            this.cap_soc = cap_soc;
        }

        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }

        public void setPrimary_address(Primary_address primary_addressObject) {
            this.primary_address = primary_addressObject;
        }

        public void setDomain(Domain domainObject) {
            this.domain = domainObject;
        }
    }

    public static class Domain {
        private String id;
        private String code;
        private String display_name;
        private String description;
        private float enabled;
        private String creator_id = null;
        private String created_at = null;
        private String updated_at;
        private String domain_path;
        private String entity_id;
        private String logo;
        private String laravel_through_key;


        // Getter Methods

        public String getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public String getDescription() {
            return description;
        }

        public float getEnabled() {
            return enabled;
        }

        public String getCreator_id() {
            return creator_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getDomain_path() {
            return domain_path;
        }

        public String getEntity_id() {
            return entity_id;
        }

        public String getLogo() {
            return logo;
        }

        public String getLaravel_through_key() {
            return laravel_through_key;
        }

        // Setter Methods

        public void setId(String id) {
            this.id = id;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setEnabled(float enabled) {
            this.enabled = enabled;
        }

        public void setCreator_id(String creator_id) {
            this.creator_id = creator_id;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public void setDomain_path(String domain_path) {
            this.domain_path = domain_path;
        }

        public void setEntity_id(String entity_id) {
            this.entity_id = entity_id;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public void setLaravel_through_key(String laravel_through_key) {
            this.laravel_through_key = laravel_through_key;
        }
    }

    public static class Primary_address {
        private String id;
        private String zip_code = null;
        private String city;
        private String street;
        private String number;
        private String province = null;
        private String region = null;
        private String locality = null;
        private String note = null;
        private String created_at;
        private String updated_at;
        private String nation_code;
        private String point_map_url = null;


        // Getter Methods

        public String getId() {
            return id;
        }

        public String getZip_code() {
            return zip_code;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public String getNumber() {
            return number;
        }

        public String getProvince() {
            return province;
        }

        public String getRegion() {
            return region;
        }

        public String getLocality() {
            return locality;
        }

        public String getNote() {
            return note;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getNation_code() {
            return nation_code;
        }

        public String getPoint_map_url() {
            return point_map_url;
        }

        // Setter Methods

        public void setId(String id) {
            this.id = id;
        }

        public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public void setNation_code(String nation_code) {
            this.nation_code = nation_code;
        }

        public void setPoint_map_url(String point_map_url) {
            this.point_map_url = point_map_url;
        }
    }

    public static class Contacts {
        private String fax;
        private String reg_imp;
        private String cap_soc;


        // Getter Methods

        public String getFax() {
            return fax;
        }

        public String getReg_imp() {
            return reg_imp;
        }

        public String getCap_soc() {
            return cap_soc;
        }

        // Setter Methods

        public void setFax(String fax) {
            this.fax = fax;
        }

        public void setReg_imp(String reg_imp) {
            this.reg_imp = reg_imp;
        }

        public void setCap_soc(String cap_soc) {
            this.cap_soc = cap_soc;
        }
    }
}
