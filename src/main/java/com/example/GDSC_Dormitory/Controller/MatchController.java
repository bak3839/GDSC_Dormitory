package com.example.GDSC_Dormitory.Controller;

import com.example.GDSC_Dormitory.domain.Match;
import com.example.GDSC_Dormitory.service.MatchService;
import com.example.GDSC_Dormitory.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MatchController {
    private final MatchService matchService;

    @PostMapping("/search")
    public ResponseEntity<String> search(@RequestBody MatchForm form) {
        matchService.score(form.getId());
        return ResponseEntity.ok().body("성공");
    }

    @PostMapping("/showScore")
    public List<Match> score(@RequestBody MatchForm form) {
        List<Match> matchList = matchService.findAll(form.getId());

        return matchList;
    }
}
