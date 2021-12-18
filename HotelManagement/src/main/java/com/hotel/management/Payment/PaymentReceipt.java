package com.hotel.management.Payment;

public class PaymentReceipt {
private String Name;
private String ReciptNumber;
private String RoomNo;
private String Status;
private String date;
private float paymentamount;

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getReciptNumber() {
	return ReciptNumber;
}
public void setReciptNumber(String reciptNumber) {
	ReciptNumber = reciptNumber;
}
public String getRoomNo() {
	return RoomNo;
}
public void setRoomNo(String roomNo) {
	RoomNo = roomNo;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public float getPaymentamount() {
	return paymentamount;
}
public void setPaymentamount(float paymentamount) {
	this.paymentamount = paymentamount;
}


}
