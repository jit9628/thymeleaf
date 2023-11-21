package com.example.springbootcrud.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.example.springbootcrud.entity.RoomBook;

public interface RoomBookService {
	
	public RoomBook bookRoom(RoomBook roomBook);
	
	public List<RoomBook> getAllBookRoomDetails();
	
	public Optional<RoomBook> getRoomBookDetailsByUserId(String email);
	public void excelReport(HttpServletResponse httpServletResponse) throws IOException;

}
