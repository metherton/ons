package com.martinetherton.ons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="T_SURNAME")
public class Surname {

    public Surname(String surname) {
		this.surname = surname;
	}

	public Surname() {
		// TODO Auto-generated constructor stub
	}

	public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

	@Id
    @Column(name="ID")
    @GeneratedValue    
    private Long entityId;
    
    @Column(name="SURNAME")
    @NotNull
    @Size(min=1)	
    private String surname;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((entityId == null) ? 0 : entityId.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Surname other = (Surname) obj;
        if (entityId == null) {
            if (other.entityId != null)
                return false;
        } else if (!entityId.equals(other.entityId))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }    
}
