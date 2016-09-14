package com.ddsutn.group01.tpanual.repositories.actions;

import javax.persistence.MappedSuperclass;

import com.ddsutn.group01.tpanual.PersistentRecord;

@MappedSuperclass
public abstract class Action extends PersistentRecord {
    void precondition() {
	}
    void postcondition(String criteria, int result, String nombre) {
	}
}
