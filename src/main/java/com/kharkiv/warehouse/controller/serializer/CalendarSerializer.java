package com.kharkiv.warehouse.controller.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CalendarSerializer extends JsonSerializer<Calendar> {    
    
	@Override
    public void serialize(Calendar value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {      
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(value.getTime());
        gen.writeString(formattedDate);

    }
}
