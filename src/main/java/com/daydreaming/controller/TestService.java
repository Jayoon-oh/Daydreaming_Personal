package com.daydreaming.controller;

import com.daydreaming.dto.Member;
import com.daydreaming.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll(); // 멤버 목록 얻기
    }
}
