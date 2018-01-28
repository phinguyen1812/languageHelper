package languageHelper.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import languageHelper.entities.LanguagesMessage;
import languageHelper.entities.Message;
import languageHelper.entities.MessageWithLastComment;
import languageHelper.entities.User;
import languageHelper.entities.UsersMessage;
import languageHelper.repositories.LangMsgRepository;
import languageHelper.repositories.MessageRepository;
import languageHelper.repositories.UserRepository;
import languageHelper.repositories.UsersMsgRepository;

@Service("business")
public class Business implements IBusiness {

	@Autowired
	private UsersMsgRepository userMessageRepo;
	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private LangMsgRepository langMessRepo;
	@Autowired
	private UserRepository userRepo;
	@Override
	public List<UsersMessage> getUsersMessageByUser(Integer idUser) {
		
		return Lists.newArrayList(userMessageRepo.getUserMessage(idUser));
	}
	/**
	 * add a message by an user.
	 * @param idUser id of User
	 * @param text text writed by User
	 * @param idLangFrom id of message's language
	 * @param idLangTo id of language to translate
	 */
	@Override
	public void addMessage(int idUser, String text, int idLangFrom, int idLangTo, int isSender) {
		Message message = new Message();
		UsersMessage usersMessage = new UsersMessage();
		LanguagesMessage langMess = new LanguagesMessage();
		
		message.setMessage(text);
		message.setDatemessage(new Timestamp(System.currentTimeMillis()));
		messageRepo.save(message);
		message.setIdrequest(message.getIdmessage());
		//save usersMessages
		usersMessage.setIdmessage(message.getIdmessage());
		usersMessage.setIduser(idUser);
		usersMessage.setIssender(isSender);
		userMessageRepo.save(usersMessage);
		
		//save lang Mess
		langMess.setIdmessage(message.getIdmessage());
		langMess.setIdlangfrom(idLangFrom);
		langMess.setIdlangto(idLangTo);
		langMessRepo.save(langMess);
		
		
	}
	@Override
	public User getUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
		
	}
	@Override
	public List<Message> getMessagesFromIdsLang(int idLangFrom, int idLangTo) {
		List<LanguagesMessage> listLangMess= Lists.newArrayList(langMessRepo.getLangMsgFromIdsLang(idLangFrom, idLangTo));
		List<Message> listMessages = new ArrayList<Message>();
		List<Integer> listIdMessages = new ArrayList<Integer>();
		
		if(null != listLangMess) {
			for (LanguagesMessage lanMess : listLangMess) {
				listIdMessages.add(lanMess.getIdmessage());
			}
			listMessages = Lists.newArrayList(messageRepo.getMessagesFromIds(listIdMessages));
		}
		return listMessages;
	}
	@Override
	public List<MessageWithLastComment> getMessagesWithLastCommentFromIdsLang(int idLangFrom, int idLangTo) {
		List<Message> listMessages = new ArrayList<Message>();
		List<MessageWithLastComment> listMessagesWithlastComment = new ArrayList<MessageWithLastComment>(); 
		listMessages = getMessagesFromIdsLang(idLangFrom,idLangTo);
		for (Message message : listMessages) {
			MessageWithLastComment messWlc = new MessageWithLastComment();
			Message request=messageRepo.getMessageFromId(message.getIdrequest());
			UsersMessage userMessage = userMessageRepo.getUserMessageFromIdMessage(request.getIdmessage());
			User user = userRepo.getUserByID(userMessage.getIduser());
			messWlc.setMessage(request.getMessage());
			messWlc.setIdmessage(request.getIdmessage());
			messWlc.setDatemessage(request.getDatemessage());
			messWlc.setDateLastComment(message.getDatemessage());
			messWlc.setIdrequest(message.getIdrequest());
			messWlc.setUserName(user.getUsername());
			listMessagesWithlastComment.add(messWlc);
		}
		return listMessagesWithlastComment;
	}
	@Override
	public Message getMessageFromId(int idMessage) {
		
		return messageRepo.getMessageFromId(idMessage);
	}

}
