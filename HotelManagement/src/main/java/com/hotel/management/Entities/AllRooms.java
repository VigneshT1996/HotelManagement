package com.hotel.management.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOMDETAILS")
public class AllRooms {
	public AllRooms() {
	}
	public AllRooms(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Id
@Column(name ="ROOMNUMBER")
private String roomNumber;

public String getRooms() {
	return this.roomNumber;
}

public void setRoom(String room) {
    this.roomNumber = room;
}

}

