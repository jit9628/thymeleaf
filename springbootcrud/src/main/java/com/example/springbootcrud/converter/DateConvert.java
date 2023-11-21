package com.example.springbootcrud.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateConvert {
	
	public String toDate(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date theDate = null;
        //theDate = dateFormat.parse(date.toString());
		System.out.println("Date parsed = " + dateFormat.format(theDate));
        return dateFormat.format(theDate);
        
    }

}
