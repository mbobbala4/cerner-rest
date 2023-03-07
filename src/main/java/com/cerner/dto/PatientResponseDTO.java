package com.cerner.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.cerner.model.Patient;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"statusCode",
"statusMessage",
"responseMessages",
"results"
})
@Generated("jsonschema2pojo")
public class PatientResponseDTO {
	
	public PatientResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


@JsonProperty("statusCode")
private String statusCode;
@JsonProperty("statusMessage")
private String statusMessage;
@JsonProperty("responseMessages")
private String responseMessages;
public List<Patient>  getResults() {
	return results;
}

public void setResults(List<Patient>  results) {
	this.results = results;
}


@JsonProperty("results")
private List<Patient> results;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("statusCode")
public String getStatusCode() {
return statusCode;
}

@JsonProperty("statusCode")
public void setStatusCode(String statusCode) {
this.statusCode = statusCode;
}

@JsonProperty("statusMessage")
public String getStatusMessage() {
return statusMessage;
}

@JsonProperty("statusMessage")
public void setStatusMessage(String statusMessage) {
this.statusMessage = statusMessage;
}

@JsonProperty("responseMessages")
public String getResponseMessages() {
return responseMessages;
}

@JsonProperty("responseMessages")
public void setResponseMessages(String responseMessages) {
this.responseMessages = responseMessages;
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