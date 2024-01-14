package managedBean;

import java.io.Serializable;

import com.example.dao.UserDAORemote;
import com.example.dao.WorkIncidentDAORemote;
import com.example.dto.UserDTO;
import com.example.dto.WorkIncidentDTO;

import jakarta.ejb.EJB;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@jakarta.enterprise.context.SessionScoped
public class WorkIncidentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	WorkIncidentDTO newIncident = new WorkIncidentDTO();
	
	UserDTO userDTO = new UserDTO();
	
	private List<WorkIncidentDTO> incidentList;
    
	private int param1;
    
	private String param2;
    


	@EJB
	UserDAORemote userDAORemote;

	@EJB
	WorkIncidentDAORemote workIncidentDAORemote;
	
    @Inject
    private LoginBean loginBean;

	public WorkIncidentBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.userDTO = (UserDTO) facesContext.getExternalContext().getSessionMap().get("userDTO");
		incidentList = new ArrayList<>();
	}

	public void loadData() {
		incidentList.clear();
		incidentList = this.workIncidentDAORemote.findAllForUser(this.loginBean.getUserId());
	}

	public String LogWorkingIncidents() {
		newIncident.setCreatedBy(this.userDTO.getId());
		newIncident.setDateReported(new Date());
		newIncident = workIncidentDAORemote.create(newIncident);
		return "/userFilter/dashboard.xhtml?faces-redirect=true";
	}
	
    public List<WorkIncidentDTO> getIncidentList() {
		incidentList = this.workIncidentDAORemote.findAllForUser(this.loginBean.getUserId());
        return incidentList;
    }
    
    // Getters and setters for param1 and param2
    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
    
    public WorkIncidentDTO getNewIncident() {
        return newIncident;
    }

    public void setNewIncident(WorkIncidentDTO newIncident) {
        this.newIncident = newIncident;
    }

}
