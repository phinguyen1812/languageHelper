package languageHelper.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_languages database table.
 * 
 */
@Entity
@Table(name="users_languages")
@NamedQuery(name="UsersLanguage.findAll", query="SELECT u FROM UsersLanguage u")

public class UsersLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtech;
	@Column
	private int idlanguage;
	@Column
	private int iduser;

	public UsersLanguage() {
	}

	public int getIdtech() {
		return this.idtech;
	}

	public void setIdtech(int idtech) {
		this.idtech = idtech;
	}

	public int getIdlanguage() {
		return this.idlanguage;
	}

	public void setIdlanguage(int idlanguage) {
		this.idlanguage = idlanguage;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

}