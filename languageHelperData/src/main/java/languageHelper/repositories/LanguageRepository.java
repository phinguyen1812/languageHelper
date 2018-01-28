package languageHelper.repositories;

import org.springframework.data.repository.CrudRepository;

import languageHelper.entities.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

}
