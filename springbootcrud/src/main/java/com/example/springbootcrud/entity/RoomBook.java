package com.example.springbootcrud.entity;
import java.util.Date;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@Table(name = "Booking_Details")
public class RoomBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date checkin;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date checkout;
	private String adult;
	private String child;
	private String room;
}
