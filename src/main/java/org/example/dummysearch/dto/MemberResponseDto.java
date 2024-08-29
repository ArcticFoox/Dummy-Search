package org.example.dummysearch.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dummysearch.domain.Member;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String userId;
    private String userName;

    public MemberResponseDto(Member entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
    }
}
