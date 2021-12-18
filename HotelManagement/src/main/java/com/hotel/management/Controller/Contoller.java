package com.hotel.management.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.DAO.HotelDAO;
import com.hotel.management.Entities.AllRooms;
import com.hotel.management.Entities.HotelLogBook;
import com.hotel.management.Entities.RoomDetails;
import com.hotel.management.Entities.UserData;
import com.hotel.management.Payment.PaymentReceipt;


@RestController
public class Contoller {
	
	@Autowired
	private HotelDAO sRoom;

	 @RequestMapping( produces = "application/json", 
             value = "/login")
	  public void login(@RequestBody UserData data) {
		 
	  }
	 
	 @PatchMapping( produces = "application/json",  value = "/checkin")
	  public String checkIn(@RequestBody HotelLogBook checkIn) {
		 String CheckInTime=checkIn.getCheckintime();
		 String RoomNo=checkIn.getRoomno();
		 return sRoom.updateCheckIn(CheckInTime,RoomNo);
	  }
	 
	 @PatchMapping(produces = "application/json",  value = "/checkout")
	  public String checkOut(@RequestBody HotelLogBook checkout) {
		 String checkoutTime=checkout.getCheckouttime();
		 String RoomNo=checkout.getRoomno();
		 return sRoom.updateCheckOut(checkoutTime,RoomNo);
	  }
	 
	 @PostMapping(produces = "application/json", value = "/hotelbooking")
		 public PaymentReceipt hotelBooking(@RequestBody HotelLogBook s) {
		 return  sRoom.hotelBooking(s);
	  }
	 
	 @GetMapping(produces = "application/json",  value = "/show_all_rooms")
	  public List<AllRooms> show_all_rooms() {
		return sRoom.getAll();
	  }
	 
	 @GetMapping(produces = "application/json", value = "/show_vacant_rooms")
	  public List<AllRooms> show_vacant_rooms() {
		 return sRoom.getVacant();
	  }
	 
	 @GetMapping(produces = "application/json", value = "/show_occupied_rooms")
	  public List<AllRooms> show_occupied_rooms() {
		 return sRoom.getBooked();
	  }
}
