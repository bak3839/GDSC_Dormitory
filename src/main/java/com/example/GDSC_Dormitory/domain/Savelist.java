package com.example.GDSC_Dormitory.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Savelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "savelist_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "my_id", referencedColumnName = "member_id")
    private Member member1;

    @ManyToOne
    @JoinColumn(name = "your_id", referencedColumnName = "member_id")
    private Member member2;
}
