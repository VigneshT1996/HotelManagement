package com.hotel.management.DAO;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.management.Entities.AllRooms;
import com.hotel.management.Entities.HotelLogBook;
import com.hotel.management.Entities.RoomDetails;
import com.hotel.management.Payment.PaymentReceipt;
import com.hotel.management.Repository.RepositoryRoomsStatus;
import com.hotel.management.Repository.ServiceImplHotelLog;
import com.hotel.management.Repository.ServiceImplRoom;

@Repository
@Transactional
public class HotelDAO {
	@Autowired
	ServiceImplRoom db;
	@Autowired
	ServiceImplHotelLog hLog;
	@Autowired
	RepositoryRoomsStatus rStatus;
   
	public List<AllRooms> getAll() {
    	  return (List<AllRooms>) db.findAll();
    	  //return "success";
    }
	public List<AllRooms> getVacant() {
		List<RoomDetails> rDetails= rStatus.findByRoomstatus("Not Booked");
 	   List<AllRooms> rList=new ArrayList<AllRooms>();
 	   for(int i=0;i<rDetails.size();i++) {
 		   rList.add(new AllRooms(rDetails.get(i).getRooms()));
 	   }
 	   return rList;
    }
	
	public List<AllRooms> getBooked() {
    	   List<RoomDetails> rDetails= rStatus.findByRoomstatus("Booked");
    	   //AllRooms rAll=new AllRooms();
    	   List<AllRooms> rList=new ArrayList<AllRooms>();
    	   //rDetails.stream().forEach(x->x.getRooms());
    	   //List<String> room = rDetails.stream().map(RoomDetails::getRooms).collect(Collectors.toList());
    	   for(int i=0;i<rDetails.size();i++) {
    		   rList.add(new AllRooms(rDetails.get(i).getRooms()));
    	   }
    	   return rList;
    }
	
	public String updateCheckIn(String cTime, String sRoom) {
		HotelLogBook temp=hLog.findById(sRoom).orElse(null);
		if(temp!=null) {//Data Available
			temp.setCheckintime(cTime);
			hLog.save(temp);
			return "CheckIn Time Updated Successfully";
		}else {
			return "Invalid RoomNumber/Room not available in Booked Status(Failed)";
		}
		
	}
	
	public String updateCheckOut(String cTime, String sRoom) {
		HotelLogBook temp=hLog.findById(sRoom).orElse(null);
		if(temp!=null) {//Data Available
			temp.setCheckouttime(cTime);
			hLog.save(temp);
			RoomDetails sRD=rStatus.findById(sRoom).orElse(null);
			sRD.setRoomStatus("Not Booked");
			rStatus.save(sRD);
			return "CheckOut Time Updated Successfully";
		}else {
			return "Invalid RoomNumber/Room not available in Booked Status(Failed)";
		}
	}
	
	public PaymentReceipt hotelBooking(HotelLogBook data) {
		String RoomNumber = data.getRoomno();
		RoomDetails temp=rStatus.findById(RoomNumber).orElse(null);
		PaymentReceipt pay=new PaymentReceipt();
		Random rand = new Random();
		Date d=new Date();
		if(temp!=null) {//Data Available
			hLog.save(data);
			temp.setRoomStatus("Booked");
			rStatus.save(temp);
			pay.setDate(""+d);
			pay.setName(data.getName());
			pay.setPaymentamount(data.getAmount());
			pay.setReciptNumber(""+rand.nextInt(1000));
			pay.setRoomNo(RoomNumber);
			pay.setStatus("Room Booked Successfully");
		}else {
			pay.setDate(""+d);
			pay.setName(data.getName());
			pay.setPaymentamount(data.getAmount());
			pay.setReciptNumber(""+rand.nextInt(1000));
			pay.setRoomNo(RoomNumber);
			pay.setStatus("Invalid RoomNumber/Room not available to Book(Failed)");
		}
		return pay;
    	
    }
	
}
