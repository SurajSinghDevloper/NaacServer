package com.nac.model.IIQA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SRA")
public class SraList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sraId;
	private String sraType;
	private String sraDocumentName;
	private long prepareIIQA;
	
	public long getSraId() {
		return sraId;
	}
	public void setSraId(long sraId) {
		this.sraId = sraId;
	}
	public String getSraType() {
		return sraType;
	}
	public void setSraType(String sraType) {
		this.sraType = sraType;
	}
	public String getSraDocumentName() {
		return sraDocumentName;
	}
	public void setSraDocumentName(String sraDocumentName) {
		this.sraDocumentName = sraDocumentName;
	}
	public long getPrepareIIQA() {
		return prepareIIQA;
	}
	public void setPrepareIIQA(long prepareIIQA) {
		this.prepareIIQA = prepareIIQA;
	}
	
	
}
