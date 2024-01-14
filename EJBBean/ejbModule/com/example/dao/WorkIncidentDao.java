package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.UserDTO;
import com.example.dto.WorkIncidentDTO;
import com.example.models.Userprofile;
import com.example.models.WorkIncident;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class WorkIncidentDao
 */
@Stateless(mappedName = "WorkIncidentDao")
@LocalBean
public class WorkIncidentDao implements WorkIncidentDAORemote {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();
	
    /**
     * Default constructor. 
     */
    public WorkIncidentDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public WorkIncidentDTO findById(int id) {
		 WorkIncident workincident = entityManager.find( WorkIncident.class, id);
		 WorkIncidentDTO workincidentDTO = entityToDTO.convertWorkIncident(workincident);
		return workincidentDTO;
	}

	@Override
	public List<WorkIncidentDTO> findAll() {
		Query query = entityManager.createQuery("SELECT w FROM WorkIncident w");
		@SuppressWarnings("unchecked")
		List<WorkIncident> workIncidents = query.getResultList();
		System.out.println(workIncidents.toString());
		List<WorkIncidentDTO> dtoWorkIncidents = new ArrayList<>();
		for (WorkIncident workIncident : workIncidents) {
			dtoWorkIncidents.add(entityToDTO.convertWorkIncident(workIncident));
		}
		return dtoWorkIncidents;
	}
	
	public List<WorkIncidentDTO> findAllForUser(int userId) {
		Query query = entityManager.createQuery("SELECT w FROM WorkIncident w WHERE w.createdBy = :userId");
		query.setParameter("userId", userId);
		@SuppressWarnings("unchecked")
		List<WorkIncident> workIncidents = query.getResultList();
		System.out.println(workIncidents.toString());
		List<WorkIncidentDTO> dtoWorkIncidents = new ArrayList<>();
		for (WorkIncident workIncident : workIncidents) {
			dtoWorkIncidents.add(entityToDTO.convertWorkIncident(workIncident));
		}
		return dtoWorkIncidents;
	}

	@Override
	public WorkIncidentDTO create(WorkIncidentDTO workIncidentDTO) {
		WorkIncident workIncident = dtoToEntity.convertWorkIncident(workIncidentDTO);
		entityManager.persist(workIncident);
		entityManager.flush();
		workIncidentDTO.setId(workIncident.getId());
		return workIncidentDTO;
	}

	@Override
	public WorkIncidentDTO update(WorkIncidentDTO workIncidentDTO) {
		WorkIncident workIncident = dtoToEntity.convertWorkIncident(workIncidentDTO);
		workIncident.setId(workIncidentDTO.getId());
		workIncident = entityManager.merge(workIncident);
		return workIncidentDTO;
	}

	@Override
	public void delete(int id) {
		WorkIncident workIncident = entityManager.find(WorkIncident.class, id);
		entityManager.remove(workIncident);
		
	}

}
