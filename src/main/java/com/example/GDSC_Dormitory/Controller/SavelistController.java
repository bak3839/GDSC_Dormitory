package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.Member;
import com.example.GDSC_Dormitory.domain.Savelist;
import com.example.GDSC_Dormitory.service.MemberService;
import com.example.GDSC_Dormitory.service.SavelistService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/savelist")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SavelistController {

    private final SavelistService savelistService;
    private final MemberService memberService;

    @GetMapping("/saved")
    public ResponseEntity<String> store(@RequestParam Long myId,
                                        @RequestParam Long otherId) {
        Savelist savelist = new Savelist();

        savelist.setMember1(memberService.findOne(myId));
        savelist.setMember2(memberService.findOne(otherId));

        savelistService.join(savelist);

        return ResponseEntity.ok().body("저장");
    }

    @GetMapping("/userIdList")
    public ResponseEntity<List<Long>> idList(Long id) {
        return ResponseEntity.ok().body(savelistService.findIdList(id));
    }

    @GetMapping("/myList")
    public ResponseEntity<List<Member>> showMy(Long id) {
        return ResponseEntity.ok().body(savelistService.findMyList(id));
    }

    @GetMapping("/otherList")
    public ResponseEntity<List<Member>> showOther(@RequestParam Long id) {
        return ResponseEntity.ok().body(savelistService.findOtherList(id));
    }
}
