package com.ddsutn.group01.tpanual.roles;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
	
    public String queSos() {
    	return "admin";
    }
	
}
