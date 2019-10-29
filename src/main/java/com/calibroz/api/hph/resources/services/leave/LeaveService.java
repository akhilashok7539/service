package com.calibroz.api.hph.resources.services.leave;

import com.calibroz.api.jpa.entities.leave.Leave;

public interface LeaveService {

	LeaveResponse addLeave(Leave leave);

	LeaveResponse updateLeave(Leave leave);

}
