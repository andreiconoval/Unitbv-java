package com.example.util;

import com.example.dto.UserDTO;
import com.example.dto.WorkIncidentDTO;
import com.example.models.Userprofile;
import com.example.models.WorkIncident;

public class EntityToDTO {

	public UserDTO convertUser(Userprofile user) {
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword());

		globalUserDTO.setId(user.getIduser());
		return globalUserDTO;

	}
	
	public WorkIncidentDTO convertWorkIncident(WorkIncident workIncident) {
		WorkIncidentDTO workIncidentDTO = new WorkIncidentDTO();
		workIncidentDTO.setId(workIncident.getId());
		workIncidentDTO.setCreatedBy(workIncident.getCreatedBy());
		workIncidentDTO.setDateReported(workIncident.getDateReported());
		workIncidentDTO.setDateResolved(workIncident.getDateResolved());
		workIncidentDTO.setDepartment(workIncident.getDepartment());
		workIncidentDTO.setDescription(workIncident.getDescription());
		workIncidentDTO.setReportedBy(workIncident.getReportedBy());
		workIncidentDTO.setResolution(workIncident.getResolution());
		workIncidentDTO.setStatus(workIncident.getStatus());
		workIncidentDTO.setTitle(workIncident.getTitle());
		return workIncidentDTO;
	}

}