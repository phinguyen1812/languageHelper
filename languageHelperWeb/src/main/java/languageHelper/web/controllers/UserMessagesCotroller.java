package languageHelper.web.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import languageHelper.entities.Message;
import languageHelper.entities.MessageWithLastComment;
import languageHelper.entities.User;
import languageHelper.entities.UsersMessage;
import languageHelper.web.model.ApplicationModel;
import languageHelper.web.model.PostAddMessage;
import languageHelper.web.model.Response;


@RestController
public class UserMessagesCotroller {
	
	@Autowired
	private ApplicationModel appModel;
	@Autowired
	private UsersMessagesCorsController userMessCORS;
	// liste de messages
	private String messages;
	
	@PostConstruct
	public void init() {
		// messages d'erreur de l'application
		messages = "ddddddddddddddd";
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/getAllMessagesOfUser/{idUser}", method = RequestMethod.GET)
	public Response getAllMessagesOfUser(@PathVariable("idUser") int idUser, HttpServletResponse response) {
//		userMessCORS.getAllMessagesOfUserCORS(response);
		List<UsersMessage> userMess = null;
		userMess = appModel.getUsersMessageByUser(idUser);
		
		if(null == userMess) {
			return new Response(2, null);
		}
		return  new Response(0, userMess);
		
	}
	@CrossOrigin
	@RequestMapping(value = "/addMessage", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
	public Response addMessage(@RequestBody PostAddMessage post, HttpServletResponse response) {
		userMessCORS.addMessageCORS(response);
		//addMessageCORS(response);
		int idUser = post.getIdUser();
		String text = post.getText();
		int idLangFrom = post.getIdLangFrom();
		int idLangTo = post.getIdLangTo();
		int isSender = post.getIsSender();
		try {
			appModel.addMessage(idUser, text, idLangFrom, idLangTo,isSender);
		}catch (Exception e) {
			return new Response(2, e);
		}
		return new Response(0, post);
		
	}

	@RequestMapping(value = "/getUserByUsername/{username}", method = RequestMethod.GET)
	public Response getUserByUsername(@PathVariable("username") String username, HttpServletResponse response) {
		userMessCORS.getUserByUsernameCORS(response);
		User user = null;
		user = appModel.getUserByUsername(username);
		
		if(null == user) {
			return new Response(2, null);
		}
		return  new Response(0, user);
		
	}
	@RequestMapping(value = "/getMessagesFromIdsLang/{idLangFrom}/{idLangTo}", method = RequestMethod.GET)
	public Response getMessagesFromIdsLang(@PathVariable("idLangFrom") int idLangFrom,@PathVariable("idLangTo") int idLangTo, HttpServletResponse response) {
		userMessCORS.getMessagesFromIdsLang(response);
		List<MessageWithLastComment> listMessages = null;
		listMessages = appModel.getMessagesWithLastCommentFromIdsLang(idLangFrom,idLangTo);
		
		if(null == listMessages) {
			return new Response(2, null);
		}
		return  new Response(0, listMessages);
		
	}
	@RequestMapping(value = "/getMessageFromId/{idMessage}", method = RequestMethod.GET)
	public Response getMessageFromId(@PathVariable("idMessage") int idMessage, HttpServletResponse response) {
		userMessCORS.getMessagesFromIdsLang(response);
		Message message = null;
		message = appModel.getMessageFromId(idMessage);
		
		if(null == message) {
			return new Response(2, null);
		}
		return  new Response(0, message);
		
	}

}
