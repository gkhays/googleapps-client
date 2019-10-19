package org.gkh.google.client.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBean {

	@XmlAttribute
	private boolean isDelegatedAdmin;
	
	@XmlAttribute
	private boolean suspended;
	
	// relations
	@XmlAttribute
	private boolean isAdmin;
	
	//lastLoginTime
	//orgUnitPath
	
	@XmlAttribute
	private String primaryEmail;
	
	@XmlAttribute
	private NameBean name;
	
	public boolean isDelegatedAdmin() {
		return isDelegatedAdmin;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public NameBean getName() {
		return name;
	}
	
	
}
