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

    	private Long fatherId;
    	private Long motherId;
    	private final Long entityId;
    	private final String firstName;
    	private final Surname surname;
    	private final Date birthDate;
    	private int gender;
    	
		public Builder(Long entityId, String firstName, Surname surname, Date birthDate, int gender) {
			this.entityId = entityId;
			this.firstName = firstName;
			this.surname = surname;
			this.birthDate = birthDate;
			this.gender = gender;
		}

		public Builder withFather(Long val) {
			fatherId = val;
			return this;
		}

		public Builder withMother(Long val) {
			motherId = val;
			return this;
		}

		public Person build() {
			return new Person(this);
		}

	}

    @Column(name="GENDER")   
	private int gender;

    public Person() {
    	
    }
    
	private Person(Builder builder) {
		entityId = builder.entityId;
		firstName = builder.firstName;
		surname = builder.surname;
		birthDate = builder.birthDate;
		fatherId = builder.fatherId;
		motherId = builder.motherId;
		gender = builder.gender;
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

    @Column(name="MOTHER_ID")      
	private Long motherId;    
      
    @Column(name="FATHER_ID")      
    private Long fatherId;

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public Long getMotherId() {
		return motherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public void setMotherId(Long motherId) {
		this.motherId = motherId;
	}

	public int getGender() {
		return gender;
	}
    
}
