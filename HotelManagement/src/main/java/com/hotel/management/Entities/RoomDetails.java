package com.hotel.management.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;

@Entity
@Table(name="ROOMDETAILS")
public class RoomDetails {
	@Id
	@Column(name = "ROOMNUMBER")
private String roomNumber;
	@Column(name = "ROOMSTATUS")
private String roomstatus;
public String getRooms() {
	return this.roomNumber;
}

public String getRoomStatus() {
	return roomstatus;
}

public void setRoomStatus(String roomStatus) {
	roomstatus = roomStatus;
}

public void setRoom(String room) {
    this.roomNumber = room;
}

}
