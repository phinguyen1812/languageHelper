package languageHelper.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_messages database table.
 * 
 */
@Entity
@Table(name="users_messages")
@NamedQuery(name="UsersMessage.findAll", query="SELECT u FROM UsersMessage u")

public class UsersMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtech;
	@Column
	private int idmessage;
	@Column
	private int iduser;
	@Column
	private int issender;

	public UsersMessage() {
	}

	public int getIdtech() {
		return this.idtech;
	}

	public void setIdtech(int idtech) {
		this.idtech = idtech;
	}

	public int getIdmessage() {
		return this.idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIssender() {
		return this.issender;
	}

	public void setIssender(int issender) {
		this.issender = issender;
	}

}