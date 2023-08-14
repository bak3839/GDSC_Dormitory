package com.example.GDSC_Dormitory.repository;

import com.example.GDSC_Dormitory.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    @Autowired DetailRepository detailRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        Member member = new Member();

        member.setNickname("admin");
        member.setMajor("소프트웨어");
        member.setEmail("2019@sangmyung.kr");
        member.setGender(1);

        memberRepository.save(member);

        Member findMember = memberRepository.findOne(member.getId());

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}