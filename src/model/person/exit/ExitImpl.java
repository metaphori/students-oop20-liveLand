package model.person.exit;

import java.util.List;

import model.person.ticket.PersonTicket;

public class ExitImpl implements Exit{

/*Class for delete all the person that sill in the park*/
	public void deletePerson(List<PersonTicket> list) {
		list.remove(0);
	}
	//uscita delle persone dal parco



	


	
	
}
