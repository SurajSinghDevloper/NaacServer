package com.nac.model.SSR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Univ_ExtendedProfile")
public class UnivExtendedProfileSSR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UnivExtendedProfileId;
	private long ssrID;
	private long collegeId;
//	--------------------------------	
	private int  stuOutgoingYear1;
	private int stuOutgoingYear2;
	private int stuOutgoingYear3;
	private int stuOutgoingYear4;
	private int stuOutgoingYear5;
	private String stuOutgoingInstDataDoc;
//	--------------------------------	

//	--------------------------------	
	private int acadFullTimeTeachYear1;
	private int acadFullTimeTeachYear2;
	private int acadFullTimeTeachYear3;
	private int acadFullTimeTeachYear4;
	private int acadFullTimeTeachYear5;
	private String acadFullTimeTeachInstDataDoc;
//	--------------------------------	

//	--------------------------------	
	private int expenditureWithoutSalaryYear1;
	private int expenditureWithoutSalaryYear2;
	private int expenditureWithoutSalaryYear3;
	private int expenditureWithoutSalaryYear4;
	private int expenditureWithoutSalaryYear5;
	private String expenditureWithoutSalaryInstDataDoc;
//	--------------------------------
}
