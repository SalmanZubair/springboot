package com.patiently.postgresql.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Members {

	@Id
	private int memId;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "address")
	private String address;

	@Column(name = "zipcode")
	private int zipcode;

	@Column(name = "recommended_by")
	private Integer recommendedBy;

	@Column(name = "joindate")
	private Timestamp joindate;

	public Members() {
	}

	public Members(int memId, String lastName, String firstName, String address, int zipcode, Integer recommendedBy,
			Timestamp joindate) {
		super();
		this.memId = memId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.zipcode = zipcode;
		this.recommendedBy = recommendedBy;
		this.joindate = joindate;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(Integer recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

}
