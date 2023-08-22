package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.Detail;
import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.service.DetailService;
import com.example.GDSC_Dormitory.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class HomeController {
    private final MemberService memberService;

    @PostMapping("/info")
    public ResponseEntity<List<Member>> info() {
        return ResponseEntity.ok().body(memberService.findAll());
    }
}
