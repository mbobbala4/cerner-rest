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
"age",
"address",
"name",
"gender",
"dateOfBirth"
})
@Generated("jsonschema2pojo")
public class PatientRequestDTO {
	
	public PatientRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


@JsonProperty("id")
private Integer id;
@JsonProperty("age")
private Integer age;
@JsonProperty("address")
private String address;
@JsonProperty("name")
private String name;
@JsonProperty("gender")
private String gender;
@JsonProperty("dateOfBirth")
private String dateOfBirth;
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

@JsonProperty("age")
public Integer getAge() {
return age;
}

@JsonProperty("age")
public void setAge(Integer age) {
this.age = age;
}

@JsonProperty("address")
public String getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(String address) {
this.address = address;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("gender")
public String getGender() {
return gender;
}

@JsonProperty("gender")
public void setGender(String gender) {
this.gender = gender;
}

@JsonProperty("dateOfBirth")
public String getDateOfBirth() {
return dateOfBirth;
}

@JsonProperty("dateOfBirth")
public void setDateOfBirth(String dateOfBirth) {
this.dateOfBirth = dateOfBirth;
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
