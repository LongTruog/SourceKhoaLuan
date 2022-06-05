package com.buysmartweb.modelutil;

import com.buysmartweb.dto.ApiiDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class StaffDTO {
    private String image;
    private String url;
    private String content;
    private String content_url;
    private String price;
    private String price_url;
    private ApiiDTO[] apiiDTOS;

    @Override
    public String toString() {
        return "StaffDTO{" +
                "image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", content_url='" + content_url + '\'' +
                ", price=" + price +
                ", price_url='" + price_url + '\'' +
                ", apiiDTOS=" + Arrays.toString(apiiDTOS) +
                '}';
    }
}
