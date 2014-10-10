package com.martinetherton.ons.model;



import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="T_PERSON")
public class Person  {

    public static class Builder {

    	private Person father;
    	private Person mother;
    	private final Long entityId;
    	private final String firstName;
    	private final Surname surname;
    	private final Date birthDate;
    	
		public Builder(Long entityId, String firstName, Surname surname, Date birthDate) {
			this.entityId = entityId;
			this.firstName = firstName;
			this.surname = surname;
			this.birthDate = birthDate;
		}

		public Builder withFather(Person val) {
			father = val;
			return this;
		}

		public Builder withMother(Person val) {
			mother = val;
			return this;
		}

		public Person build() {
			return new Person(this);
		}

	}

    public Person() {
    	
    }
    
	private Person(Builder builder) {
		entityId = builder.entityId;
		firstName = builder.firstName;
		surname = builder.surname;
		birthDate = builder.birthDate;
		father = builder.father;
		mother = builder.mother;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
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
		Person other = (Person) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Surname getSurname() {
		return surname;
	}

	public void setSurname(Surname surname) {
		this.surname = surname;
	}

	@Id
    @Column(name="ID")
    @GeneratedValue
    private Long entityId;
    
    @Column(name="FIRST_NAME")
    @NotNull
    @Size(min=1)
    private String firstName;
    
    @OneToOne
    @JoinColumn(name="SURNAME_ID")
    private Surname surname;

    @Column(name="DATE_OF_BIRTH") 
    @NotNull
    private Date birthDate;

    @OneToOne
    @JoinColumn(name="FATHER_ID")    
	private Person father;

    @OneToOne
    @JoinColumn(name="MOTHER_ID")       
	private Person mother;

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Person getFather() {
		return father;
	}

	public Person getMother() {
		return mother;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}
    
}
