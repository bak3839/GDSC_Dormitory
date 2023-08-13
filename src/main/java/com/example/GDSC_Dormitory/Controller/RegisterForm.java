package com.example.GDSC_Dormitory.Controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class RegisterForm {
    private String email;
    private String major;
    private String nickname;
    private int gender;

    @JsonCreator
    public RegisterForm(@JsonProperty("email") String email,
                        @JsonProperty("major") String major,
                        @JsonProperty("nickname") String nickname,
                        @JsonProperty("gander") int gender) {
        this.email = email;
        this.major = major;
        this.nickname = nickname;
        this.gender = gender;
    }
}
