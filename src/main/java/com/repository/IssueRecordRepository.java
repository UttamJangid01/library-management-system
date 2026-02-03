package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enums.IssueStatus;
import com.model.IssueRecord;

@Repository
public interface IssueRecordRepository extends JpaRepository<IssueRecord, Long> {

    List<IssueRecord> findAllByMemberId(Long id);

    boolean existsByBookIdAndMemberId(Long bookId, Long memberId);

    @Query("select i from IssueRecord i where i.status = :status")
    List<IssueRecord> getAllActiveIssueRecords(@Param("status") IssueStatus status);

}
