package com.calibroz.api.hph.resources.services.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.leave.Leave;
import com.calibroz.api.repository.leave.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public LeaveResponse addLeave(Leave leave) {
		// TODO Auto-generated method stub
		
		String status = "leave added";
		LeaveResponse response = new LeaveResponse();
		
		Leave l = leaveRepository.save(leave);
		status = l!=null ? status:"leave not added";
		response.setStatus(status);
		response.setLeave(l);
		
		return response;
	}

	@Override
	public LeaveResponse updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		String status = "leave added";
		LeaveResponse response = new LeaveResponse();
		
		Leave l = leaveRepository.save(leave);
		status = l!=null ? status:"leave not added";
		response.setStatus(status);
		response.setLeave(l);
		
		return response;
	}
	
}
