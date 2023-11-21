package com.example.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootcrud.entity.RoomBook;

@Repository
public interface RoomBookRepository extends JpaRepository<RoomBook, Integer> {

}
