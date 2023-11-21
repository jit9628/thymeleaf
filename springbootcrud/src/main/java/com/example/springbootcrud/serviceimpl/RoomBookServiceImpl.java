package com.example.springbootcrud.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrud.entity.RoomBook;
import com.example.springbootcrud.repository.RoomBookRepository;
import com.example.springbootcrud.service.RoomBookService;

@Service
public class RoomBookServiceImpl implements RoomBookService {
	@Autowired
	RoomBookRepository bookRepository;

	@Override
	public RoomBook bookRoom(RoomBook roomBook) {

		return this.bookRepository.save(roomBook);
	}

	@Override
	public List<RoomBook> getAllBookRoomDetails() {

		return this.bookRepository.findAll();
	}

	@Override
	public Optional<RoomBook> getRoomBookDetailsByUserId(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void excelReport(HttpServletResponse httpServletResponse) throws IOException {

		List<RoomBook> findAll = this.bookRepository.findAll();// get the record from db table
		HSSFWorkbook workbook = new HSSFWorkbook(); // create workbook
		HSSFSheet createSheet = workbook.createSheet("Detail Report");// sheet created
		HSSFRow createRow = createSheet.createRow(0);// created row
		createRow.createCell(0).setCellValue("Name");// create header cell inside row
		createRow.createCell(1).setCellValue("Email");// create header cell inside row

		int dataRowIndex = 0;
		for (RoomBook roomBook : findAll) {

			HSSFRow dataRow = createSheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(roomBook.getName());
			dataRow.createCell(1).setCellValue(roomBook.getEmail());
			dataRowIndex++;

		}

		ServletOutputStream outputStream = httpServletResponse.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

}
