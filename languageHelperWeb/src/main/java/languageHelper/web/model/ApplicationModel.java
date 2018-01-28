package languageHelper.web.model;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import languageHelper.business.IBusiness;
import languageHelper.entities.Message;
import languageHelper.entities.MessageWithLastComment;
import languageHelper.entities.User;
import languageHelper.entities.UsersMessage;
@Component
public class ApplicationModel implements IBusiness {
	
	// la couche [métier]
	@Autowired
	private IBusiness iBusiness;
	private List<UsersMessage> userMessages;
	
	@PostConstruct
	public void init() {
		userMessages = iBusiness.getUsersMessageByUser(1);
	}
	@Override
	public List<UsersMessage> getUsersMessageByUser(Integer idUser) {
		return userMessages;
	}
	@Override
	/**
	 * add a message by an user.
	 * @param idUser id of User
	 * @param text text writed by User
	 * @param idLangFrom id of message's language
	 * @param idLangTo id of language to translate
	 */
	public void addMessage(int idUser, String text, int idLangFrom, int idLangTo,int isSender) {
		iBusiness.addMessage(idUser, text, idLangFrom, idLangTo, isSender);
		
	}
	@Override
	public User getUserByUsername(String username) {
		return iBusiness.getUserByUsername(username);
	}
	@Override
	public List<Message> getMessagesFromIdsLang(int idLangFrom, int idLangTo) {
		
		return iBusiness.getMessagesFromIdsLang(idLangFrom, idLangTo);
	}
	@Override
	public List<MessageWithLastComment> getMessagesWithLastCommentFromIdsLang(int idLangFrom, int idLangTo) {
		return iBusiness.getMessagesWithLastCommentFromIdsLang(idLangFrom, idLangTo);
	}
	@Override
	public Message getMessageFromId(int idMessage) {
		return iBusiness.getMessageFromId(idMessage);
	}

}
