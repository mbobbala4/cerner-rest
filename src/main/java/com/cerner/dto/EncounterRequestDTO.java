package com.cerner.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"facility_id",
"patient_id"
})
@Generated("jsonschema2pojo")
public class EncounterRequestDTO {

@JsonProperty("id")
private Integer id;
@JsonProperty("facility_id")
private Integer facilityId;
@JsonProperty("patient_id")
private Integer patientId;
@JsonProperty("act_ind")
private Integer actInd;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("facility_id")
public Integer getFacilityId() {
return facilityId;
}

@JsonProperty("facility_id")
public void setFacilityId(Integer facilityId) {
this.facilityId = facilityId;
}

@JsonProperty("patient_id")
public Integer getPatientId() {
return patientId;
}

@JsonProperty("patient_id")
public void setPatientId(Integer patientId) {
this.patientId = patientId;
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