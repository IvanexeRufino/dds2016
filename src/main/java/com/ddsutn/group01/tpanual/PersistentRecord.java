package com.ddsutn.group01.tpanual;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersistentRecord {
    @SuppressWarnings("unused")
    @Id
    @GeneratedValue
    private Integer id;

    @SuppressWarnings("unused")
    public Integer getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(Integer id) {
        this.id = id;
    }
}
