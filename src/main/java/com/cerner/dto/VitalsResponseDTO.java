package com.cerner.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.cerner.model.Vitals;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"responseMessages",
"results"
})
@Generated("jsonschema2pojo")
public class VitalsResponseDTO {
	
	public VitalsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



@JsonProperty("responseMessages")
private String responseMessages;
public List<Vitals>  getResults() {
	return results;
}

public void setResults(List<Vitals>  results) {
	this.results = results;
}


@JsonProperty("results")
private List<Vitals> results;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


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