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
    private int exp;
    private boolean smoking;

    @JsonCreator
    public RegisterForm(@JsonProperty("email") String email,
                        @JsonProperty("major") String major,
                        @JsonProperty("nickname") String nickname,
                        @JsonProperty("gander") int gender,
                        @JsonProperty("exp") int exp,
                        @JsonProperty("smoking") boolean smoking) {
        this.email = email;
        this.major = major;
        this.nickname = nickname;
        this.gender = gender;
        this.exp = exp;
        this.smoking = smoking;
    }
}