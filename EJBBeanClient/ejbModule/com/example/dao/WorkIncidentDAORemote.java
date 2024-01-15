package com.example.dao;

import java.util.List;

import com.example.dto.WorkIncidentDTO;

import jakarta.ejb.Remote;

@Remote
public interface WorkIncidentDAORemote  extends GenericDAO<WorkIncidentDTO>{
	
	List<WorkIncidentDTO> findAllForUser(int userId);
	
	WorkIncidentDTO findIncidentById(int incidentId);
}
