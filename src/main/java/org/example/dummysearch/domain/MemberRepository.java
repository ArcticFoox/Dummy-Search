package org.example.dummysearch.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUserIdContains(String keyword);

    List<Member> findByUserNameContains(String keyword);

    @Query(value = "SELECT * FROM member WHERE MATCH(user_id, user_name) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    Slice<Member> findByFulltext(String keyword, Pageable pageable);
}
