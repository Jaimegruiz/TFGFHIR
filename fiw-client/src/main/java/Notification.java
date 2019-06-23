/*
 * Copyright (C) 2016 Orange
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Notification model
 */
public class Notification {

	/**
     * Format model
     */
    public enum Format {
        normalized, keyValues, values;
    }
    /*
     * Tengo q hablarlo con Isabel, no se como representar atributos que son opcionales
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<List<String>> attrs;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<List<String>> exceptAttrs;
	
	
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	Optional<HttpFiw> http;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	Optional<HttpCustomFiw> httpCustom;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<Format> attrsFormat;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	Optional<List<String>> metadata;
	*/
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<String> attrs;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<String> exceptAttrs;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    HttpFiw http;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    HttpCustomFiw httpCustom;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Format attrsFormat;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<String> metadata;
    
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
	Long timesSent;
    @JsonInclude(JsonInclude.Include.NON_NULL)
	Instant lastNotification;
    @JsonInclude(JsonInclude.Include.NON_NULL)
	Instant lastFailure;
    @JsonInclude(JsonInclude.Include.NON_NULL)
	Instant lastSuccess;


    public Notification() {
    	
    }


	public List<String> getAttrs() {
		return attrs;
	}


	public void setAttrs(List<String> attrs) {
		this.attrs = attrs;
	}


	public List<String> getExceptAttrs() {
		return exceptAttrs;
	}


	public void setExceptAttrs(List<String> exceptAttrs) {
		this.exceptAttrs = exceptAttrs;
	}


	public HttpFiw getHttp() {
		return http;
	}


	public void setHttp(HttpFiw http) {
		this.http = http;
	}


	public HttpCustomFiw getHttpCustom() {
		return httpCustom;
	}


	public void setHttpCustom(HttpCustomFiw httpCustom) {
		this.httpCustom = httpCustom;
	}


	public Format getAttrsFormat() {
		return attrsFormat;
	}


	public void setAttrsFormat(Format attrsFormat) {
		this.attrsFormat = attrsFormat;
	}


	public List<String> getMetadata() {
		return metadata;
	}


	public void setMetadata(List<String> metadata) {
		this.metadata = metadata;
	}


	public Long getTimesSent() {
		return timesSent;
	}


	public void setTimesSent(Long timesSent) {
		this.timesSent = timesSent;
	}


	public Instant getLastNotification() {
		return lastNotification;
	}


	public void setLastNotification(Instant lastNotification) {
		this.lastNotification = lastNotification;
	}


	public Instant getLastFailure() {
		return lastFailure;
	}


	public void setLastFailure(Instant lastFailure) {
		this.lastFailure = lastFailure;
	}


	public Instant getLastSuccess() {
		return lastSuccess;
	}


	public void setLastSuccess(Instant lastSuccess) {
		this.lastSuccess = lastSuccess;
	}
    
    
    





    
    

   
    
}
