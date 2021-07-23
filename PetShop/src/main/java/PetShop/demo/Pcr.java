package PetShop.demo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table
public class Pcr {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date extractionDate;
	public boolean result;

//Relationship type:
@ManyToOne
@JoinColumn (name = "Guest_ID")
public Guest guest;	
	
	
//Constructor:			
	public Pcr(Date extractionDate, boolean result) {
		super();
		//Id = id; 	 not necessary JPA's annotation "@id" has already created it.
		this.extractionDate = extractionDate;
		this.result = result;
	}

	public Pcr() {
		super();
	}



	//Getters and Setters:		
	public int getId() {
		return Id;
	}


	public void  setId(int id) {
		Id = id;
	}


	public Date getExtractionDate() {
		return extractionDate;
	}


	public void setExtractionDate(Date extractionDate) {
		this.extractionDate = extractionDate;
	}


	public boolean isResult() {
		return result;
	}


	public void setResult(boolean result) {
		this.result = result;
	}
	

	
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	//adding method:
	
	/*public void addGuest(Guest guest) {
		this.guest.add(guest);
		guest.setPcr(this);
	}*/
	
	
	//ToString:	
	@Override
	public String toString() {
		return "Pcr [Id=" + Id + ", ExtractionDate=" + extractionDate + ", Result=" + result + ", Guest=" + guest + "]";
	}

}
