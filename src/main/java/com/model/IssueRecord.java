package com.model;

import java.time.LocalDate;

import com.enums.IssueStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IssueRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;
    private Long bookId;
    private Long memberId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fineAmount;
    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    public Long getIssueId() {
        return issueId;
    }
    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public double getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
    public IssueStatus getStatus() {
        return status;
    }
    public void setStatus(IssueStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "IssueRecord [issueId=" + issueId + ", bookId=" + bookId + ", memberId=" + memberId + ", issueDate="
                + issueDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fineAmount=" + fineAmount
                + ", status=" + status + "]";
    }

}