package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.*;
import com.example.GDSC_Dormitory.service.DetailService;
import com.example.GDSC_Dormitory.service.MemberService;
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
    private final MemberService memberService;

    @PostMapping("/details")
    public ResponseEntity<String> addDetail(@RequestBody DetailForm form) {
        Detail detail = new Detail();
        Member member = (memberService.findByNickname(form.getNickname())).get(0);

        detail.setMember(member);
        detail.setHabits(form.getHabits());
        detail.setOuting(form.getOuting());
        detail.setPrefer(form.getPrefer());
        detail.setSleep(form.getSleep());
        detail.setWakeup(form.getWakeup());
        detail.setCleaning(form.getCleaning());
        detail.setHome(form.getHome());
        detail.setEar(form.getEar());

        detailService.join(detail);

        return ResponseEntity.ok().body("성공");
    }
}
