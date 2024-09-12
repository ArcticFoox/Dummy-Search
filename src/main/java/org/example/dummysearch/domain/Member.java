package org.example.dummysearch.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userName;

    @Builder
    public Member(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public void update(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }
}
