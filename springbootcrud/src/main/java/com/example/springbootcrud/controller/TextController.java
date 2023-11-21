package com.example.springbootcrud.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootcrud.converter.DateConvert;
import com.example.springbootcrud.entity.RoomBook;
import com.example.springbootcrud.service.RoomBookService;

@Controller
public class TextController {

	@Autowired
	DateConvert convert;
	@Autowired
	RoomBookService bookService;

	@GetMapping("/")
	public String data() {
		return "index";
	}

	@GetMapping("/booking")
	public String bookingForm(@ModelAttribute("roomBook") RoomBook roomBook, Model model) {
		// RoomBook roomBook = new RoomBook();
		model.addAttribute("oomBook", roomBook);
		// create list of adult data
		List<String> adultPerson = List.of("1", "2", "3");
		List<String> childPerson = List.of("1", "2", "3", "4");
		model.addAttribute("adultPerson", adultPerson);
		model.addAttribute("childPerson", childPerson);
		return "booking";
	}

	@PostMapping("/bookingroom")
	public String bookedRoom(RoomBook roomBook) {

		System.out.println(roomBook);
		this.bookService.bookRoom(roomBook);
		System.out.println("success");

		return "redirect:/";
	}
	
	
	@GetMapping("/details")
	public String bookingDetails(@ModelAttribute("roomBook") RoomBook roomBook, Model model) {
		List<RoomBook> allBookRoomDetails = this.bookService.getAllBookRoomDetails();
		System.out.println("{List Available is :: }"+allBookRoomDetails);
		model.addAttribute("listsAll",allBookRoomDetails);
		
		return "details";
	}
	
	@GetMapping("/details/excel")
	public String excelReportGenerator(HttpServletResponse httpServletResponse) {
	try {
		
		httpServletResponse.setContentType("application/octet-stream"); // responsible for download file 
		String headerHey="Content-Disposition";
		 String headerValue = "attachment; filename=details.xls";
		httpServletResponse.setHeader(headerHey, headerValue);
		this.bookService.excelReport(httpServletResponse);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	 return "details";
	}

}
