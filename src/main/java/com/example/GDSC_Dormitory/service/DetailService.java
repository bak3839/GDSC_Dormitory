package com.example.GDSC_Dormitory.service;

import com.example.GDSC_Dormitory.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DetailService {

    private final DetailRepository detailRepository;
}
