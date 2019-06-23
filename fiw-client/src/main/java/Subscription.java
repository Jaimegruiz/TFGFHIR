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



import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Subscription model
 */
public class Subscription {

    /**
     * Status model
     */
    public enum Status {
        active, expired;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String id;
    
    //Optional
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String description;
    //Optional , in seconds
    int throttling;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    SubjectSubscription subject;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Notification notification;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String expires;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Status status;

    public Subscription() {
    }

    public Subscription(String id, SubjectSubscription subject, Notification notification, String expires, Status status) {
        this.id = id;
        this.subject = subject;
        this.notification = notification;
        this.expires = expires;
        this.status = status;
    }
    public int getThrottling() {
    	return throttling;
    }
    public void setThrottling(int throttling) {
    	this.throttling = throttling;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description=description;
    }

    public SubjectSubscription getSubject() {
        return subject;
    }

    public void setSubject(SubjectSubscription subject) {
        this.subject = subject;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
    
}
