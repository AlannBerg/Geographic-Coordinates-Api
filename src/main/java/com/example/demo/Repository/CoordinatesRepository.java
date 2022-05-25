package com.example.demo.Repository;

import com.example.demo.Model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates,Integer> {


    @Query("select cordinates from Coordinates cordinates where cordinates.deviceId = :providedId")
    List<Coordinates> findAllByDeviceID(@Param("providedId") int deviceId );

}
