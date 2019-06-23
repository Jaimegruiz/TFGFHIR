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



import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

/**
 * SubjectRegistration Entity model
 */
public class SubjectEntity {
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String idPattern;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String typePattern;
	
	public SubjectEntity() {
		
	}
	
	public SubjectEntity(String idPattern,String type) {
		this.idPattern = idPattern;
		this.type = type;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getIdPattern() {
		return idPattern;
	}

	public void setIdPattern(String idPattern) {
		this.idPattern = idPattern;
	}

	public String getTypePattern() {
		return typePattern;
	}

	public void setTypePattern(String typePattern) {
		this.typePattern = typePattern;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<String> id;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<String> idPattern;

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<String> type;
    
    //añado typePattern
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<String> typePattern;
    
    

    public SubjectEntity() {
    }

    public SubjectEntity(Optional<String> id) {
        this.id = id;
    }
    public void setTypePattern(Optional<String> typePattern) {
        this.typePattern = typePattern;
    }
    public Optional<String> getTypePattern(){
    	return typePattern;
    }

    public Optional<String> getId() {
        return id;
    }

    public void setId(Optional<String> id) {
        this.id = id;
    }

    public Optional<String> getIdPattern() {
        return idPattern;
    }

    public void setIdPattern(Optional<String> idPattern) {
        this.idPattern = idPattern;
    }

    public Optional<String> getType() {
        return type;
    }

    public void setType(Optional<String> type) {
        this.type = type;
    }*/
}
