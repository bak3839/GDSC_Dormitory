package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.Detail;
import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterForm form) {
        Member member = new Member();

        member.setNickname(form.getNickname());
        member.setGender(form.getGender());
        member.setEmail(form.getEmail());
        member.setMajor(form.getMajor());

        memberService.join(member);
        return ResponseEntity.ok().body("성공");
    }

    @GetMapping("/nicknameCheck")
    public ResponseEntity<String> validateDuplicateNickname(@RequestParam String nickname) {
        List<Member> findMembers = memberService.findByNickname(nickname);

        if(!findMembers.isEmpty()) {
            return ResponseEntity.status(412).body("duplicate");
        }
        return ResponseEntity.ok().body("possible");
    }
}
