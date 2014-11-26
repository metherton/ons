package com.martinetherton.ons.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="T_COUNTRY")
public class Country {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long entityId;

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
