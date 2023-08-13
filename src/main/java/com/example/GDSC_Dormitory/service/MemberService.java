package com.example.GDSC_Dormitory.service;

import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void join(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findByNickname(String nickname){
        return memberRepository.findByNickname(nickname);
    }

    /*public ResponseEntity<String> validateDuplicateNickname(String nickname) {
        List<Member> findMembers = memberRepository.findByNickname(nickname);

        if(!findMembers.isEmpty()) {
            return ResponseEntity.status(412).body("duplicate");
        }

        return ResponseEntity.ok().body("possible");
    }*/

    /*private void validateDuplicateNickname(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByNickname(member.getNickname());

        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임 입니다.");
        }

        findMembers = memberRepository.findByEmail(member.getEmail());

        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 가입한 이메일 입니다.");
        }
    }*/
}
