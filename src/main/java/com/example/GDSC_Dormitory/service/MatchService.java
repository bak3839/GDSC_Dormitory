package com.example.GDSC_Dormitory.service;

import com.example.GDSC_Dormitory.Controller.MatchForm;
import com.example.GDSC_Dormitory.domain.Detail;
import com.example.GDSC_Dormitory.domain.Match;
import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.repository.DetailRepository;
import com.example.GDSC_Dormitory.repository.MatchRepository;
import com.example.GDSC_Dormitory.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchService {

    private final DetailRepository detailRepository;
    private final MemberRepository memberRepository;
    private final MatchRepository matchRepository;

    @Transactional
    public void score(Long id) {
        Detail myDetail = detailRepository.findOne(id);

        List<Detail> findOtherDetail = detailRepository.findAll(id);

        System.out.println(findOtherDetail.size());

        for(Detail others : findOtherDetail) {
            if(others.getId() == id) continue;

            // 계산 로직

            // save 로직
            Match match = new Match();

            match.setMember1(memberRepository.findOne(id));
            match.setMember2(memberRepository.findOne(others.getId()));
            match.setScore(50);

            matchRepository.save(match);
        } 
        // 이미 계산된 유저도 계속 계산됨. 발표 후 수정 계획임.
        // 변동 사항 캐치는 어떻게? 변동 사항이 없으면 넘어가기? => 수정시간을 저장해서 알아내자!
        // @CreationTimestamp //값이 입력될때 혹은 업데이트될때 자동으로 시간이 들어간다.


        // @CreationTimestamp
        // private Timestamp createDate; updateTime < modifyTime  => 계산 다시하기
        // Detail이랑(modifyTime) Match(updateTime) domain에 둘다 집어넣기
    }

    public List<Match> findAll(Long id) {
        return matchRepository.findAll(id);
    }
}
