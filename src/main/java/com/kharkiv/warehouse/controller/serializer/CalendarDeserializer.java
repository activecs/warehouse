package com.kharkiv.warehouse.controller.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CalendarDeserializer extends JsonDeserializer<Calendar> {
	
    @Override
    public Calendar deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = jsonparser.getText();
        try {
        	Date parsedDate = format.parse(date);
        	Calendar calendar = Calendar.getInstance();
        	calendar.setTime(parsedDate);
            return calendar;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
