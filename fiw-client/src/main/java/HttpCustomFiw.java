import java.net.URL;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;

public class HttpCustomFiw {
	
	URL url;
	/*
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
    Optional<Map<String, String>> headers;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	Optional<Map<String, String>> qs;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	Optional<String> method;
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	Optional<String> payload;*/
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Map<String, String> headers;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Map<String, String> qs;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String method;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String payload;
	
	public HttpCustomFiw() {
		
	}
	public URL getUrl() {
		return this.url;
	}
	public void setUrl(URL url) {
		this.url=url;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public Map<String, String> getQs() {
		return qs;
	}
	public void setQs(Map<String, String> qs) {
		this.qs = qs;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	
	
}
