package com.patiently.postgresql.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {

	@Id
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "slots")
	private int slots;

	@Column(name = "start_time")
	private Timestamp startTime;

	@ManyToMany(targetEntity = Facilities.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "fac_id")
	private Set<Facilities> facility;

	@ManyToMany
	@JoinColumn(name = "mem_id")
	private Set<Members> member;

	public Bookings(int bookId, int slots, Timestamp startTime, Set<Facilities> facility, Set<Members> member) {
		super();
		this.bookId = bookId;
		this.slots = slots;
		this.startTime = startTime;
		this.facility = facility;
		this.member = member;
	}

	public Bookings() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Set<Facilities> getFacility() {
		return facility;
	}

	public void setFacility(Set<Facilities> facility) {
		this.facility = facility;
	}

	public Set<Members> getMember() {
		return member;
	}

	public void setMember(Set<Members> member) {
		this.member = member;
	}

}
