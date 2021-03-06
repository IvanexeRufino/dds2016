package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.db.PersistentRecord;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Action extends PersistentRecord {
    public void precondition() {}

    public void postcondition(String searchText, int result, String nombreDeTerminal) {}
}
