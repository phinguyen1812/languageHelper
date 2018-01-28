package languageHelper.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the languages database table.
 * 
 */
@Entity
@Table(name="languages")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")

public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idlanguage;
	@Column
	private String language;

	public Language() {
	}

	public int getIdlanguage() {
		return this.idlanguage;
	}

	public void setIdlanguage(int idlanguage) {
		this.idlanguage = idlanguage;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}