package org.example.dummysearch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dummysearch.domain.MemberRepository;
import org.example.dummysearch.dto.MemberResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll(){

        long startTime = System.currentTimeMillis();

        List<MemberResponseDto> responseDtos = memberRepository.findAll().stream()
                        .map(MemberResponseDto::new)
                        .toList();

        long duration = System.currentTimeMillis() - startTime;
        log.info("API 호출 시간 " + duration + " ms");

        return responseDtos;
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findByIdContains(String keyword){
        long startTime = System.currentTimeMillis();

        List<MemberResponseDto> responseDtos = memberRepository.findByUserIdContains(keyword).stream()
                .map(MemberResponseDto::new)
                .toList();

        long duration = System.currentTimeMillis() - startTime;
        log.info("API 호출 시간 " + duration + " ms");

        return responseDtos;
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findByNameContains(String keyword){
        long startTime = System.currentTimeMillis();

        List<MemberResponseDto> responseDtos = memberRepository.findByUserNameContains(keyword).stream()
                .map(MemberResponseDto::new)
                .toList();

        long duration = System.currentTimeMillis() - startTime;
        log.info("API 호출 시간 " + duration + " ms");

        return responseDtos;
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findByFulltext(String keyword, Pageable pageable){
        long startTime = System.currentTimeMillis();

        List<MemberResponseDto> responseDtos = memberRepository.findByFulltext(keyword, pageable).stream()
                .map(MemberResponseDto::new)
                .toList();

        long duration = System.currentTimeMillis() - startTime;
        log.info("API 호출 시간 " + duration + " ms");

        return responseDtos;
    }
}
