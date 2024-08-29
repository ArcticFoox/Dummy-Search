package org.example.dummysearch.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUserIdContains(String keyword);

    List<Member> findByUserNameContains(String keyword);
}
