package org.example.dummysearch.service;

import lombok.RequiredArgsConstructor;
import org.example.dummysearch.domain.MemberRepository;
import org.example.dummysearch.dto.MemberResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll(){
        return memberRepository.findAll().stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findByIdContains(String keyword){
        return memberRepository.findByUserIdContains(keyword).stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findByNameContains(String keyword){
        return memberRepository.findByUserNameContains(keyword).stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }

}
