package com.example.GDSC_Dormitory.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Detail {
    @Id
    @Column(name = "member_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "member_id")
    private Member member;
    private String habits;
    private String outing;
    private String prefer;
    private int sleep;
    private int wakeup;
    private int cleaning;
    private boolean exp;
    private boolean smoking;
}
