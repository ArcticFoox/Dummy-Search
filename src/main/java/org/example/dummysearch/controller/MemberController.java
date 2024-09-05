package org.example.dummysearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.dummysearch.service.MemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/search-fulltext/{keyword}")
    public ResponseEntity<?> findByFulltext(@RequestParam(name = "page", required = false, defaultValue = "0")int page,
                                            @RequestParam(name = "size", required = false, defaultValue = "2")int size,
                                            @RequestParam(name = "keyword") String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(memberService.findByFulltext(keyword, pageable));
    }
}
