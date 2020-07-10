package com.example.da;

import java.util.List;

import com.example.domain.ListEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ListEntity, Long> {
    ListEntity findById(long id);
}
