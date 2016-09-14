package com.ddsutn.group01.tpanual;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersistentRecord {
    @SuppressWarnings("unused")
    @Id
    @GeneratedValue
    private long id;

    @SuppressWarnings("unused")
    public long getId() {
        return id;
    }
}
