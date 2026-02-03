package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BookReturn;
import com.model.IssueRecord;
import com.service.IssueRecordService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/lms/issue")
public class IssueController {

  @Autowired
  private IssueRecordService service;

  // @PostMapping
  @PostMapping("")
  public ResponseEntity<Map<String, String>> createIssueRecord(@RequestBody IssueRecord record) {
    return ResponseEntity.ok(Map.of("message", service.saveIssueRecord(record)));
  }

  @GetMapping("/{issueId}")
  public ResponseEntity<IssueRecord> getIssueRecordByIssueId(@PathVariable("issueId") Long id) {
    return ResponseEntity.ok(service.getIssueRecordById(id));
  }

  @GetMapping("/member/{memberId}")
  public ResponseEntity<List<IssueRecord>> getIssueRecordByMemberId(@PathVariable("memberId") Long id) {
    List<IssueRecord> issueList = service.getIssueRecordByMemberId(id);
    return issueList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(issueList);
  }

  @GetMapping("/active")
  public ResponseEntity<List<IssueRecord>> getAllActiveIssueRecord() {
    List<IssueRecord> issueList = service.getAllActiveIssueRecords();
    return issueList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(issueList);
  }

  @PutMapping("/{issueId}/return")
  public ResponseEntity<BookReturn> updateIssueRecord(@PathVariable("issueId") Long id) {
    return ResponseEntity.ok(service.updateIssueRecord(id)); 
  }
}
