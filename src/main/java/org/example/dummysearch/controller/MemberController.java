package org.example.dummysearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.dummysearch.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/search-id/{keyword}")
    public ResponseEntity<?> findById(@RequestParam(name = "keyword") String keyword) {
        return ResponseEntity.ok(memberService.findByIdContains(keyword));
    }

    @GetMapping("/search-name/{keyword}")
    public ResponseEntity<?> findByName(@RequestParam(name = "keyword") String keyword) {
        return ResponseEntity.ok(memberService.findByNameContains(keyword));
    }
}
