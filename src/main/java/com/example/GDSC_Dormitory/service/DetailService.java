package com.example.GDSC_Dormitory.service;

import com.example.GDSC_Dormitory.domain.Detail;
import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.repository.DetailRepository;
import com.example.GDSC_Dormitory.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DetailService {

    private final DetailRepository detailRepository;

    @Transactional
    public void join(Detail detail) {
        detailRepository.save(detail);
    }

    public List<Detail> findAll() {
        return detailRepository.findAll();
    }
}
