package com.nac.model.IIQA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetailsOfStaffOfCollege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffDetailID")
	private Long Id;
	
	private String category;
	private int male;
	private int female;
	private int transgender;
	private long prepareIIQA_ID;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMale() {
		return male;
	}
	public void setMale(int male) {
		this.male = male;
	}
	public int getFemale() {
		return female;
	}
	public void setFemale(int female) {
		this.female = female;
	}
	public int getTransgender() {
		return transgender;
	}
	public void setTransgender(int transgender) {
		this.transgender = transgender;
	}
	public long getPrepareIIQA_ID() {
		return prepareIIQA_ID;
	}
	public void setPrepareIIQA_ID(long prepareIIQA_ID) {
		this.prepareIIQA_ID = prepareIIQA_ID;
	}
	
	
}
