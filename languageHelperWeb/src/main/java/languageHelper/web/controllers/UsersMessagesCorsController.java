package languageHelper.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersMessagesCorsController {

	
	// envoi des options au client
	private void sendOptions(HttpServletResponse response) {
		// on fixe le header CORS
		response.addHeader("Access-Control-Allow-Origin", "*");
		// on autorise certains headers
		response.addHeader("Access-Control-Allow-Headers", "*");
		// on autorise les méthodes
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
	}
	
	@RequestMapping(value = "/addMessage", method = RequestMethod.OPTIONS)
	public void addMessageCORS(HttpServletResponse response) {
		//sendOptions(response);

	}
	
	@RequestMapping(value = "/getAllMessagesOfUser/{idUser}", method = RequestMethod.OPTIONS)
	public void getAllMessagesOfUserCORS(HttpServletResponse response) {
		sendOptions(response);

	}
	
	@RequestMapping(value = "/getUserByUsername/{username}", method = RequestMethod.OPTIONS)
	public void getUserByUsernameCORS(HttpServletResponse response) {
		//sendOptions(response);
		
	}
	@RequestMapping(value = "/getMessagesFromIdsLang/{idLangFrom}/{idLangTo}", method = RequestMethod.OPTIONS)
	public void getMessagesFromIdsLang(HttpServletResponse response) {
		
	}
	@RequestMapping(value = "/getMessageFromId/{idMessage}", method = RequestMethod.OPTIONS)
	public void getMessageFromIdCORS(HttpServletResponse response) {
		
	}
}
