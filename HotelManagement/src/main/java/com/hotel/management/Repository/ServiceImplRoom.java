package com.hotel.management.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.Entities.AllRooms;

@Repository
public interface ServiceImplRoom extends CrudRepository<AllRooms, String>{
   // List<RoomDetails> findAll();
}
