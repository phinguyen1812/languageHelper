package languageHelper.web.model;

public class PostAddMessage {
	private int idUser;
	private String text;
	private int idLangFrom;
	private int idLangTo;
	private int isSender;
	
	public int getIsSender() {
		return isSender;
	}
	public void setIsSender(int isSender) {
		this.isSender = isSender;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIdLangFrom() {
		return idLangFrom;
	}
	public void setIdLangFrom(int idLangFrom) {
		this.idLangFrom = idLangFrom;
	}
	public int getIdLangTo() {
		return idLangTo;
	}
	public void setIdLangTo(int idLangTo) {
		this.idLangTo = idLangTo;
	}
	
}
