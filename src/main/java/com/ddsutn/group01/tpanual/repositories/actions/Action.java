package com.ddsutn.group01.tpanual.repositories.actions;

import com.ddsutn.group01.tpanual.PersistentRecord;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Action extends PersistentRecord {
    public void precondition() {}

    public void postcondition(String searchText, int result, String nombre) {}
}
