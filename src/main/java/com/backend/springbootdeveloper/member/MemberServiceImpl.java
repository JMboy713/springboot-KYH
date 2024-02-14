package com.backend.springbootdeveloper.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 생성자를 통해서 이 멤버레포지토리에 뭐가 들어갈지를 결정해준다.
    }

    @Override
    public void join(Member member) { // 회원 가입 메서드.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
