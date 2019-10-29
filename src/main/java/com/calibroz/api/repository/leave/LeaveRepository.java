package com.calibroz.api.repository.leave;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.leave.Leave;

@Repository
public interface LeaveRepository extends PagingAndSortingRepository<Leave, Long> {

}
