package com.patiently.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facilities")
public class Facilities {

	@Id
	private int facId;

	@Column(name = "name")
	private String name;

	@Column(name = "member_cost")
	private int memberCost;

	@Column(name = "guest_cost")
	private int guestCost;

	@Column(name = "initial_outlay")
	private int initialOutlay;

	@Column(name = "monthly_maintenance")
	private int monthlyMaintenance;

	public Facilities(int facId, String name, int memberCost, int guestCost, int initialOutlay,
			int monthlyMaintenance) {
		super();
		this.facId = facId;
		this.name = name;
		this.memberCost = memberCost;
		this.guestCost = guestCost;
		this.initialOutlay = initialOutlay;
		this.monthlyMaintenance = monthlyMaintenance;
	}

	public Facilities() {
		
	}

	public int getFacId() {
		return facId;
	}

	public void setFacId(int facId) {
		this.facId = facId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemberCost() {
		return memberCost;
	}

	public void setMemberCost(int memberCost) {
		this.memberCost = memberCost;
	}

	public int getGuestCost() {
		return guestCost;
	}

	public void setGuestCost(int guestCost) {
		this.guestCost = guestCost;
	}

	public int getInitialOutlay() {
		return initialOutlay;
	}

	public void setInitialOutlay(int initialOutlay) {
		this.initialOutlay = initialOutlay;
	}

	public int getMonthlyMaintenance() {
		return monthlyMaintenance;
	}

	public void setMonthlyMaintenance(int monthlyMaintenance) {
		this.monthlyMaintenance = monthlyMaintenance;
	}

}
