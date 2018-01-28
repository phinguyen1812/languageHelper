package languageHelper.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the languages_messages database table.
 * 
 */
@Entity
@Table(name="languages_messages")
@NamedQuery(name="LanguagesMessage.findAll", query="SELECT l FROM LanguagesMessage l")
public class LanguagesMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtech;
	@Column
	private int idlangfrom;
	@Column
	private int idlangto;
	@Column
	private int idmessage;

	public LanguagesMessage() {
	}

	public int getIdtech() {
		return this.idtech;
	}

	public void setIdtech(int idtech) {
		this.idtech = idtech;
	}

	public int getIdlangfrom() {
		return this.idlangfrom;
	}

	public void setIdlangfrom(int idlangfrom) {
		this.idlangfrom = idlangfrom;
	}

	public int getIdlangto() {
		return this.idlangto;
	}

	public void setIdlangto(int idlangto) {
		this.idlangto = idlangto;
	}

	public int getIdmessage() {
		return this.idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

}