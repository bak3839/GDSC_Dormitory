package com.example.GDSC_Dormitory.service;

import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.domain.Savelist;
import com.example.GDSC_Dormitory.repository.SavelistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SavelistService {

    private final SavelistRepository savelistRepository;

    @Transactional
    public void join(Savelist savelist) {
        savelistRepository.save(savelist);
    }

    public List<Long> findIdList(Long id) {
        return savelistRepository.findIdList(id);
    }

    public List<Member> findMyList(Long id){
        return savelistRepository.findMyList(id);
    }

    public List<Member> findOtherList(Long id){
        return savelistRepository.findOtherList(id);
    }
}
