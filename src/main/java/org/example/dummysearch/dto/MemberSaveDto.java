package org.example.dummysearch.dto;

import lombok.Getter;
import org.example.dummysearch.domain.Member;

@Getter
public class MemberSaveDto {

    private String userId;
    private String userName;

    public Member toEntity(){
        return Member.builder()
                .userId(userId)
                .userName(userName)
                .build();
    }
}
