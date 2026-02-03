package com.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.IssueRecord;
import com.dto.BookReturn;
import com.enums.IssueStatus;
import com.exception.BookNotFoundException;
import com.exception.IssueNotFoundException;
import com.exception.MemberNotFoundException;
import com.model.Book;
import com.model.Member;
import com.repository.BookRepository;
import com.repository.IssueRecordRepository;
import com.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class IssueRecordService {

  @Autowired
  private IssueRecordRepository repo;
  @Autowired
  private BookRepository bookrepo;
  @Autowired
  private MemberRepository memberrepo;
  private final double finePerDay = 20;

  public String saveIssueRecord(IssueRecord record) {
    Book book = bookrepo.findById(record.getBookId())
        .orElseThrow(() -> new BookNotFoundException("Book id is not exists !"));
    Member member = memberrepo.findById(record.getMemberId())
        .orElseThrow(() -> new MemberNotFoundException("Member id is not exists !"));

    if (book.getAvailableCopies() <= 0)
      return "No copies available !";

    if (!repo.existsByBookIdAndMemberId(book.getBookId(), member.getMemberId())) {
      record.setIssueDate(LocalDate.now());
      record.setDueDate(LocalDate.now().plusDays(7));
      record.setFineAmount(0);
      record.setStatus(IssueStatus.ISSUE);
      repo.save(record);
      book.setAvailableCopies(book.getAvailableCopies() - 1);
      bookrepo.save(book);
      return "Book successfully issue.";
    }
    return "Member allow Ready have this book.";
  }

  public IssueRecord getIssueRecordById(Long id) {
    return repo.findById(id).orElseThrow(() -> new IssueNotFoundException("Issue id is not exists !"));
  }

  public List<IssueRecord> getIssueRecordByMemberId(Long id) {
    memberrepo.findById(id).orElseThrow(() -> new MemberNotFoundException("Member id is not exists !"));
    return repo.findAllByMemberId(id);
  }

  public List<IssueRecord> getAllActiveIssueRecords() {
    return repo.getAllActiveIssueRecords(IssueStatus.ISSUE);
  }

  @Transactional
  public BookReturn updateIssueRecord(Long id) {
    IssueRecord issuerecord = repo.findById(id)
        .orElseThrow(() -> new IssueNotFoundException("Issue id is not exists !"));

    issuerecord.setStatus(IssueStatus.RETURNED); // (>_<) OVERDUE
    issuerecord.setReturnDate(LocalDate.now());
    long totalDays = ChronoUnit.DAYS.between(issuerecord.getIssueDate(), issuerecord.getReturnDate());
    long totalDueDays = ChronoUnit.DAYS.between(issuerecord.getIssueDate(), issuerecord.getDueDate());

    if (totalDays > totalDueDays)
      issuerecord.setFineAmount(issuerecord.getFineAmount() + ((totalDays - totalDueDays) * finePerDay)); // if previus
                                                                                                          // fine is
                                                                                                          // submited so
                                                                                                          // then set
                                                                                                          // the find
                                                                                                          // value
                                                                                                          // totalFine -
                                                                                                          // payedFine

    Book book = bookrepo.findById(issuerecord.getBookId())
        .orElseThrow(() -> new BookNotFoundException("Book id is not exists !"));
    book.setAvailableCopies(book.getAvailableCopies() + 1);
    bookrepo.save(book);
    repo.save(issuerecord);
    return new BookReturn("Book returned successfully", issuerecord.getFineAmount());
  }
}
