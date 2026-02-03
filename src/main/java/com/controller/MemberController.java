package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.MemberActiveStatusRequest;
import com.model.Member;
import com.service.MemberService;

@RestController
@RequestMapping("/lms/admin/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> memberList = service.getAllMembers();
        return memberList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(memberList);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable("memberId") Long id) {
        return ResponseEntity.ok(service.getMemberById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Member> getMemberByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(service.getMemberByEmail(email));

    }

    @PostMapping("")
    public ResponseEntity<Map<String, String>> makeMember(@RequestBody Member member) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", service.saveMember(member)));
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Map<String, String>> updateMember(@PathVariable Long memberId,
            @RequestBody Member newMemberDetails) {
        return ResponseEntity.ok(Map.of("message", service.updatedMemberDetails(memberId, newMemberDetails)));
    }

    @PatchMapping("/{memberId}/status")
    public ResponseEntity<Map<String, String>> setMemberStatus(@PathVariable("memberId") Long id,
            @RequestBody MemberActiveStatusRequest request) {
        return ResponseEntity.ok(Map.of("message", service.saveMemberStatusActive(id, request)));
    }
}
