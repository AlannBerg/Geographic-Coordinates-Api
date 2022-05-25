package com.example.demo.Repository;

import com.example.demo.Model.CoordinatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity,Integer> {


    @Query("select cordinates from CoordinatesEntity cordinates where cordinates.deviceId = :providedId")
    List<CoordinatesEntity> findAllByDeviceID(@Param("providedId") Integer deviceId );


}
