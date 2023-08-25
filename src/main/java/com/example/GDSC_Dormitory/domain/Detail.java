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
    @MapsId
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private String habits;
    private String outing;
    private String prefer;
    private String home;
    private String ear;
    @Enumerated(EnumType.STRING)
    private Sleep sleep;
    @Enumerated(EnumType.STRING)
    private WakeUp wakeup;
    @Enumerated(EnumType.STRING)
    private Cleaning cleaning;
}
