package com.calibroz.api.repository.access;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.access.Access;

@Repository
public interface AccessRepository extends PagingAndSortingRepository<Access, String> {

//	@Query("SELECT a FROM ")
//	Access getIfExisting(String mobNo, Long profileId);

}
