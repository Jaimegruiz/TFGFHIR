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
import com.orange.ngsi2.model.AttributeType;

import java.util.HashMap;
import java.util.Map;

/**
 * Entity Type model
 */
public class EntityType {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    private Map<String, AttributeType> attrs;

    private int count;

    public EntityType() {
    }

    public EntityType(String type, Map<String, AttributeType> attrs, int count) {
        this.type = type;
        this.attrs = attrs;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, AttributeType> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, AttributeType> attrs) {
        this.attrs = attrs;
    }

    @JsonIgnore
    public void setAttrs(String key, AttributeType attributeType) {
        if (attrs == null) {
            attrs = new HashMap<String, AttributeType>();
        }
        attrs.put(key, attributeType);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
