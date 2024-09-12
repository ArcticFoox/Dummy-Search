package org.example.dummysearch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dummysearch.domain.Member;
import org.example.dummysearch.domain.MemberRepository;
import org.example.dummysearch.dto.MemberResponseDto;
import org.example.dummysearch.dto.MemberSaveDto;
import org.example.dummysearch.dto.MemberUpdateDto;
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

    @Transactional
    public Long save(MemberSaveDto saveDto){
        return memberRepository.save(saveDto.toEntity()).getId();
    }

    @Transactional
    public MemberResponseDto findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return new MemberResponseDto(member);
    }

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

    @Transactional
    public Long update(Long id, MemberUpdateDto updateDto){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        member.update(updateDto.getUserId(), updateDto.getUserName());

        return id;
    }

    @Transactional
    public Long delete(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        memberRepository.delete(member);

        return id;
    }
}
