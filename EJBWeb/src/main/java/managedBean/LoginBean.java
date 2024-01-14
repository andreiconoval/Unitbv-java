package managedBean;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.StatelessEjbRemote;
import com.example.dao.UserDAORemote;
import com.example.dto.LoginDTO;
import com.example.dto.UserDTO;
import com.example.exception.LoginException;

@Named
@jakarta.enterprise.context.SessionScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LoginDTO loginDTO = new LoginDTO();

	@EJB
	UserDAORemote userDAORemote;
	
	@EJB
	StatelessEjbRemote EjbRemote;

	UserDTO userDTO;
	
	public LoginBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.userDTO = (UserDTO) facesContext.getExternalContext().getSessionMap().get("userDTO");
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String loginUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		try {
			userDTO = userDAORemote.loginUser(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
			// if userDTO is admin
			System.out.println("user logged");
			return "/userFilter/dashboard.xhtml?faces-redirect=true";

		} catch (LoginException e) {
			System.out.println("Invalid username or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}

	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		userDTO = null;

		return "/index?faces-redirect=true";
	}
	
	public int getUserId() {

		if(this.userDTO == null)
		{
            redirectToIndexPage();
            return -1;
		}

		return this.userDTO.getId();
	}
	
	public String getUsername() {

		if(userDTO == null)
		{
            redirectToIndexPage();
		}

		return userDTO.getUsername();
	}
	
    private void redirectToIndexPage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
            facesContext.responseComplete();
        } catch (Exception e) {
            // Handle the exception (log it, show an error message, etc.)
        }
    }

}