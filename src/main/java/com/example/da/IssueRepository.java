package com.example.da;

import com.example.domain.IssueEntity;
import com.example.domain.ListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssueRepository extends CrudRepository<IssueEntity, Long> {
    IssueEntity findById(long id);
}