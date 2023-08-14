package com.example.GDSC_Dormitory.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String nickname;
    private String email;
    private String major;
    private int gender;
}
