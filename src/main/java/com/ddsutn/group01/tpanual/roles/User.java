package com.ddsutn.group01.tpanual.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.ddsutn.group01.tpanual.db.PersistentRecord;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User extends PersistentRecord{
	@Column(length = 50)
	private String username;
	@Column(length = 50)
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public abstract String queSos();

}	
