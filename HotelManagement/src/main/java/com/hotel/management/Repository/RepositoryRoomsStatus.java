package com.hotel.management.Repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.Entities.RoomDetails;



@Repository
	public interface RepositoryRoomsStatus extends CrudRepository<RoomDetails, String>{
		    List<RoomDetails> findByRoomstatus(String Status);
		}

