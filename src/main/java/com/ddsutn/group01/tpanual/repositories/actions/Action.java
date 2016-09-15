package com.ddsutn.group01.tpanual.repositories.actions;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.ddsutn.group01.tpanual.PersistentRecord;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Action extends PersistentRecord {
    public void precondition() {
	}
    public void postcondition(String criteria, int result, String nombre) {
	}
}
