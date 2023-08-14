package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.*;
import com.example.GDSC_Dormitory.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/detail")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class DetailController {

    private final DetailService detailService;

    @PostMapping("/details")
    public ResponseEntity<String> addDetail(@RequestBody DetailForm form) {
        Detail detail = new Detail();
        Member member = detailService.findMemberId(form.getNickname());
        System.out.println(member.getId());

        detail.setMember(member);
        detail.setHabits(form.getHabits());
        detail.setOuting(form.getOuting());
        detail.setPrefer(form.getPrefer());
        detail.setSleep(form.getSleep());
        detail.setWakeup(form.getWakeup());
        detail.setCleaning(form.getCleaning());
        detail.setExp(form.getExp());
        detail.setSmoking(form.isSmoking());

        detailService.join(detail);

        return ResponseEntity.ok().body("성공");
    }
}
