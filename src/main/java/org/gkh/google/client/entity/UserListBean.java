package org.gkh.google.client.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserListBean {

	@XmlAttribute
    private String kind;
	
    @XmlAttribute
    private String etag;
    
    @XmlAttribute(name = "users")
    private List<UserBean> userBeans;


    public String getETag() {
        return etag;
    }

    public void setId(String etag) {
        this.etag = etag;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<UserBean> getUsers() {
        return userBeans;
    }

    public void setUsers(List<UserBean> userBeans) {
        this.userBeans = userBeans;
    }
}
