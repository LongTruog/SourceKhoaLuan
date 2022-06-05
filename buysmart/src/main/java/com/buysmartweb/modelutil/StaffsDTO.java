package com.buysmartweb.modelutil;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StaffsDTO {

    @JsonProperty("Staff")
    private List<StaffDTO> staff;

}
