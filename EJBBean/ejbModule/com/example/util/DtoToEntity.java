package com.example.util;

import com.example.dto.UserDTO;
import com.example.dto.WorkIncidentDTO;
import com.example.models.Userprofile;
import com.example.models.WorkIncident;

public class DtoToEntity {
	
	public Userprofile convertUser(UserDTO userDTO) {
		Userprofile user = new Userprofile(userDTO.getUsername(), userDTO.getPassword(), userDTO.getName());

		return user;
	}
	
	public WorkIncident convertWorkIncident(WorkIncidentDTO workIncidentDTO) {
		WorkIncident workIncident = new WorkIncident();
		    workIncident.setId(workIncidentDTO.getId());
	        workIncident.setCreatedBy(workIncidentDTO.getCreatedBy());
	        workIncident.setDateReported(workIncidentDTO.getDateReported());
	        workIncident.setDateResolved(workIncidentDTO.getDateResolved());
	        workIncident.setDepartment(workIncidentDTO.getDepartment());
	        workIncident.setDescription(workIncidentDTO.getDescription());
	        workIncident.setReportedBy(workIncidentDTO.getReportedBy());
	        workIncident.setResolution(workIncidentDTO.getResolution());
	        workIncident.setStatus(workIncidentDTO.getStatus());
	        workIncident.setTitle(workIncidentDTO.getTitle());
		return workIncident;
	}
	
}
