package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.Member;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
public class MatchForm {

    private Long id;

    @JsonCreator
    public MatchForm (@JsonProperty("id") Long id){
        this.id = id;
    }
}
