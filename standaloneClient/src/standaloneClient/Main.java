package standaloneClient;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.FirstStatelessEjbRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
     InitialContext context =  new InitialContext();
     FirstStatelessEjbRemote firstejb = (FirstStatelessEjbRemote) context
    		 .lookup("java:global/myFirstEar/myFirstEjb/FirstStatelessEjb!com.example.FirstStatelessEjbRemote");
     firstejb.insert("Andrei");
	}
}
