package com.backend.springbootdeveloper.member;

public interface MemberRepository {
    void save(Member member); // save 하기만 하면 되는 메서드
    Member findByID(Long memberId); // member 객체를 돌려주는 메서드

}
