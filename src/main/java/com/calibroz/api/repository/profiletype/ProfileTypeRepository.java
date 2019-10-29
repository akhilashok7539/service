package com.calibroz.api.repository.profiletype;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.profiletype.ProfileType;

@Repository
public interface ProfileTypeRepository extends PagingAndSortingRepository<ProfileType, Long> {

}
