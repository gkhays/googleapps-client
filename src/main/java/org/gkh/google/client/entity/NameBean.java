package org.gkh.google.client.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NameBean {

	@XmlAttribute
	private String fullName;
	@XmlAttribute
	private String givenName;
	@XmlAttribute
	private String familyName;
	
	public String getFullName() {
		return fullName;
	}
	public String getGivenName() {
		return givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
}
