package com.hotel.management.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HOTELLOGBOOK")
public class HotelLogBook {
	
	
	private String BookingID;
	@Id
	private String roomno;
	@Column(name = "NAME")
	private String name;
	@Column(name = "AGE")
	private int age;
	@Column
	private int aadharnumber;
	@Column
	private String address;
	@Column
	private float amount;
	@Column
	private String checkintime;
	@Column
	private String checkouttime;

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getBookingID() {
		return BookingID;
	}

	public void setBookingID(String bookingID) {
		BookingID = bookingID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(int aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCheckintime() {
		return checkintime;
	}

	public void setCheckintime(String checkintime) {
		this.checkintime = checkintime;
	}

	public String getCheckouttime() {
		return checkouttime;
	}

	public void setCheckouttime(String checkouttime) {
		this.checkouttime = checkouttime;
	}

}
