package com.hotel.management.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.Entities.HotelLogBook;

@Repository
public interface ServiceImplHotelLog extends CrudRepository<HotelLogBook, String>{
   // List<RoomDetails> findAll();
}
