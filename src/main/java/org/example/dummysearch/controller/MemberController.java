package org.example.dummysearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.dummysearch.dto.MemberUpdateDto;
import org.example.dummysearch.service.MemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody MemberUpdateDto dto){
        return ResponseEntity.ok(memberService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(memberService.delete(id));
    }
}
