package languageHelper.business;

import java.util.List;

import languageHelper.entities.Message;
import languageHelper.entities.MessageWithLastComment;
import languageHelper.entities.User;
import languageHelper.entities.UsersMessage;


public interface IBusiness {
		// list of user's messages
		public List<UsersMessage> getUsersMessageByUser(Integer idUser);
		
		//add a message
		public void addMessage(int idUser,String text,int idLangFrom,int idLangTo, int isSender);
		//get a User
		public User getUserByUsername(String username);
		
		//get all Message by idLangFrom and IdLangTo
		public List<Message> getMessagesFromIdsLang(int idLangFrom,int idLangTo);
		//get all Message with last comment by idLangFrom and IdLangTo
		public List<MessageWithLastComment> getMessagesWithLastCommentFromIdsLang(int idLangFrom,int idLangTo);
		public Message getMessageFromId(int idMessage);
}
