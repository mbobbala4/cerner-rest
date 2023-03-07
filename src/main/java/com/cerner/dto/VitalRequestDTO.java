
package com.cerner.dto;

import java.util.LinkedHashMap;
import java.util.List;
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
    "patientId",
    "pv"
})
@Generated("jsonschema2pojo")
public class VitalRequestDTO {
	
	public VitalRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


    @JsonProperty("patientId")
    private int patientId;
    
    @JsonProperty("encounterId")
    private int encounterId;
     
    public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	@JsonProperty("pv")
    @Valid
    private List<Pv> pv;
    
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("patientId")
    public int getPatientId() {
        return patientId;
    }

    @JsonProperty("patientId")
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @JsonProperty("pv")
    public List<Pv> getPv() {
        return pv;
    }

    @JsonProperty("pv")
    public void setPv(List<Pv> pv) {
        this.pv = pv;
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
