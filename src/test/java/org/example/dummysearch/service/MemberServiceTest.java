package org.example.dummysearch.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void IdSearchTest() throws Exception{
        //given
        String keyword = "s";

        //when
        long startTime = System.currentTimeMillis();

        memberService.findByIdContains(keyword);

        //then
        long duration = System.currentTimeMillis() - startTime;

        System.out.println(duration);
    }
}