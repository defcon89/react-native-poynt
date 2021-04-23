package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserResponse {

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public class User {

        @SerializedName("id")
        private String id;

        @SerializedName("access_id")
        private String access_id;

        @SerializedName("name")
        private String name;

        @SerializedName("email")
        private String email;

        @SerializedName("created_at")
        private Date created_at;

        @SerializedName("updated_at")
        private Date updated_at;

        @SerializedName("role_id")
        private String role_id;

        @SerializedName("deleted_at")
        private Date deleted_at;

        @SerializedName("access_username")
        private String access_username;

        @SerializedName("role")
        private Role role;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAccess_id() {
            return access_id;
        }

        public void setAccess_id(String access_id) {
            this.access_id = access_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public Date getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Date deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getAccess_username() {
            return access_username;
        }

        public void setAccess_username(String access_username) {
            this.access_username = access_username;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }


        public class Role {
            @SerializedName("id")
            private String id;

            @SerializedName("code")
            private String code;

            @SerializedName("description")
            private String description;

            @SerializedName("level")
            private int level;

            @SerializedName("name")
            private String name;

            @SerializedName("created_at")
            private Date created_at;

            @SerializedName("updated_at")
            private Date updated_at;

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

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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
        }

    }
}
