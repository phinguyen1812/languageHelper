package languageHelper.entities;

import java.sql.Timestamp;

public class MessageWithLastComment {
	private int idmessage;
	private Timestamp datemessage;
	private int idrequest;
	private String message;
	private Timestamp dateLastComment;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getDateLastComment() {
		return dateLastComment;
	}
	public void setDateLastComment(Timestamp dateLastComment) {
		this.dateLastComment = dateLastComment;
	}
	public int getIdmessage() {
		return idmessage;
	}
	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}
	public Timestamp getDatemessage() {
		return datemessage;
	}
	public void setDatemessage(Timestamp datemessage) {
		this.datemessage = datemessage;
	}
	public int getIdrequest() {
		return idrequest;
	}
	public void setIdrequest(int idrequest) {
		this.idrequest = idrequest;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
