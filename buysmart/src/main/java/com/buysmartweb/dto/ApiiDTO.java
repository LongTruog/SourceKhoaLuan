package com.buysmartweb.dto;

import com.buysmartweb.modelutil.StaffDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ApiiDTO {

    @Autowired
    private Gson gson;

    StaffDTO staffDTO = gson.fromJson(new FileReader("D:\\buysmart\\src\\main\\resources\\static\\thoitrang.json"), StaffDTO.class);


    public ApiiDTO() throws FileNotFoundException {
    }
}
