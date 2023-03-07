
package com.cerner.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "value:",
    "uom",
    "updateDate"
})
@Generated("jsonschema2pojo")
public class Pv {
	
	public Pv() {
		super();
		// TODO Auto-generated constructor stub
	}


    @JsonProperty("name")
    private String name;
    
    @JsonProperty("value:")
    private int value;
    
    @JsonProperty("uom")
    private String uom;
    
//    @JsonProperty("updateDate")
//    private String updateDate;
    
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("value:")
    public int getValue() {
        return value;
    }

    @JsonProperty("value:")
    public void setValue(int value) {
        this.value = value;
    }

    @JsonProperty("uom")
    public String getUom() {
        return uom;
    }

    @JsonProperty("uom")
    public void setUom(String uom) {
        this.uom = uom;
    }

//    @JsonProperty("updateDate")
//    public String getUpdateDate() {
//        return updateDate;
//    }
//
//    @JsonProperty("updateDate")
//    public void setUpdateDate(String updateDate) {
//        this.updateDate = updateDate;
//    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
