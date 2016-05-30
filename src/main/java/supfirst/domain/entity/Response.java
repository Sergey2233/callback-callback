package supfirst.domain.entity;

import java.util.HashSet;
import java.util.Set;

public class Response {

	private boolean value = false;
	private Set<ResponseException> exceptions = new HashSet<>();

	public void addException(String name, String exception) {
		exceptions.add(new ResponseException(name, exception));
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public Set<ResponseException> getExceptions() {
		return exceptions;
	}

	public void setExceptions(Set<ResponseException> exceptions) {
		this.exceptions = exceptions;
	}

}

class ResponseException {
	private String name;
	private String value;

	public ResponseException() {
		super();
	
	}

	public ResponseException(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}