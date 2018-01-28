package languageHelper.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import languageHelper.entities.LanguagesMessage;

public interface LangMsgRepository extends CrudRepository<LanguagesMessage, Integer> {
	@Query("select lm from LanguagesMessage lm where lm.idlangfrom=?1 and lm.idlangto =?2")
	Iterable<LanguagesMessage> getLangMsgFromIdsLang(int idLangFrom,int idLangTo);
}
