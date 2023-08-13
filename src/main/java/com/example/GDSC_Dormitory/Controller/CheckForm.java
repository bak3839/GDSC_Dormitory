package com.example.GDSC_Dormitory.Controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CheckForm {
    private String Email;
    private int num;

    @JsonCreator
    public CheckForm(@JsonProperty("Email") String email,
                     @JsonProperty("num") int num) {
        this.Email = email;
        this.num = num;
    }
}
