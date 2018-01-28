package languageHelper.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name="messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idmessage;

	private Timestamp datemessage;

	private int idrequest;

	@Lob
	private String message;

	public Message() {
	}

	public int getIdmessage() {
		return this.idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

	public Timestamp getDatemessage() {
		return this.datemessage;
	}

	public void setDatemessage(Timestamp datemessage) {
		this.datemessage = datemessage;
	}

	public int getIdrequest() {
		return this.idrequest;
	}

	public void setIdrequest(int idrequest) {
		this.idrequest = idrequest;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}