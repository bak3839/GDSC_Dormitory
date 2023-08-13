package com.example.GDSC_Dormitory.Controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmailForm {
    private String Email;

    @JsonCreator
    public EmailForm(@JsonProperty("Email") String email) {
        this.Email = email;
    }
}
