package com.martinetherton.ons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_MOTHER")
public class Mother {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private Long entityId;
	
    @OneToOne(optional=false)
    @JoinColumn(name="PERSON_ID")	
   // @Column(name="PERSON_ID")
	private Person person;

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getEntityId() {
		return entityId;
	}

	public Person getPerson() {
		return person;
	}

}
