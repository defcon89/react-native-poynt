package com.reactlibrary.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArrayProperty {
    @SerializedName("property_definition_id")
    private String property_definition_id;

    @SerializedName("name")
    private String name;

    @SerializedName("value")
    private List<String> value;

    @SerializedName("type")
    private String type;

    public String getProperty_definition_id() {
        return property_definition_id;
    }

    public void setProperty_definition_id(String property_definition_id) {
        this.property_definition_id = property_definition_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
