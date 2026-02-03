package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.MemberActiveStatusRequest;
import com.exception.MemberNotFoundException;
import com.model.Member;
import com.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repo;

    public String saveMember(Member member) {
        member.setJoinDate(LocalDate.now());
        member.setMaxBooksAllowed(1);
        member.setActive(true);
        repo.save(member);
        return "Member successfully created :)";
    }

    public String saveMemberStatusActive(Long id, MemberActiveStatusRequest request) {
        Member member = getMemberById(id);
        member.setActive(request.isActive());
        repo.save(member);
        return "Successfully set status active = " + request.isActive();
    }

    public Member checkMember(Long memberId) {
        return repo.findById(memberId).orElseThrow(()->new MemberNotFoundException("Member id is not exists !"));
    }

    public String updatedMemberDetails(Long memberId, Member newMemberDetails) {
        Member member = getMemberById(memberId);
        member.setName(newMemberDetails.getName());
        member.setPhone(newMemberDetails.getPhone());
        member.setAddress(newMemberDetails.getAddress());
        member.setMaxBooksAllowed(newMemberDetails.getMaxBooksAllowed());
        repo.save(member);
        return "Member details successfully updated :)";
    }

    public Member getMemberById(Long id) {
        return repo.findById(id).orElseThrow(() -> new MemberNotFoundException("Member id is not exists !"));
    }

    public Member getMemberByEmail(String email) {
        return repo.findByEmail(email).orElseThrow(() -> new MemberNotFoundException("Member id is not exists !"));
    }

    public List<Member> getAllMembers() {
        return repo.findAll();
    }
}
