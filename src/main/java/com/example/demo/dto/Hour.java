
package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Hour {

    @JsonProperty("hourFrom")
    private String hourFrom;
    @JsonProperty("hourTo")
    private String hourTo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hourFrom")
    public String getHourFrom() {
        return hourFrom;
    }

    @JsonProperty("hourFrom")
    public void setHourFrom(String hourFrom) {
        this.hourFrom = hourFrom;
    }

    @JsonProperty("hourTo")
    public String getHourTo() {
        return hourTo;
    }

    @JsonProperty("hourTo")
    public void setHourTo(String hourTo) {
        this.hourTo = hourTo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
