package com.calibroz.api.hph.resources.services.access;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.calibroz.api.config.security.SecurityConfig;
import com.calibroz.api.jpa.entities.access.Access;
import com.calibroz.api.repository.access.AccessRepository;

@Service
public class AccessServiceImpl implements AccessService {

	@Autowired
	private AccessRepository accessRepository;

	Logger logger = LoggerFactory.getLogger(AccessServiceImpl.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AccessResponse addNewAccess(String password, Long profileId) {

		String status = null;
		Access access = new Access();

		try {
			access.setAppId(UUID.randomUUID().toString());

			// access.setPassword(password);
			access.setPassword(passwordEncoder.encode(password));

			access.setProfileId(profileId);
			access.setStatus(true);
		} catch (Exception e) {
			logger.error("error in creating new access: " + e);
		}

		AccessResponse accessResponse = new AccessResponse();

		Access a = accessRepository.save(access);

		status = null != a ? "Access Granted" : "Access Denied";

		accessResponse.setStatus(status);
		accessResponse.setAccess(a);

		return accessResponse;
	}

}
