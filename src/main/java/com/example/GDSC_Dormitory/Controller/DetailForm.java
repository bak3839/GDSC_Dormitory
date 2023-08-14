package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.Cleaning;
import com.example.GDSC_Dormitory.domain.Sleep;
import com.example.GDSC_Dormitory.domain.WakeUp;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
public class DetailForm {
    private String nickname;
    private String habits;
    private String outing;
    private String prefer;
    private Sleep sleep;
    private WakeUp wakeup;
    private Cleaning cleaning;
    private int exp;
    private boolean smoking;

    @JsonCreator
    public DetailForm(@JsonProperty("nickname") String nickname,
                      @JsonProperty("habits") String habits,
                      @JsonProperty("outing") String outing,
                      @JsonProperty("prefer") String prefer,
                      @JsonProperty("sleep") Sleep sleep,
                      @JsonProperty("wakeup") WakeUp wakeup,
                      @JsonProperty("cleaning") Cleaning cleaning,
                      @JsonProperty("exp") int exp,
                      @JsonProperty("smoking") boolean smoking){
        this.nickname =  nickname;
        this.habits = habits;
        this.outing = outing;
        this.prefer = prefer;
        this.sleep = sleep;
        this.wakeup = wakeup;
        this.cleaning = cleaning;
        this.exp = exp;
        this.smoking = smoking;
    }
}
