package languageHelper.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import languageHelper.entities.UsersMessage;

public interface UsersMsgRepository extends CrudRepository<UsersMessage, Integer> {
	@Query("select um from UsersMessage um where um.iduser=?1")
	Iterable<UsersMessage> getUserMessage(Integer iduser);
	@Query("select um from UsersMessage um where um.idmessage=?1")
	UsersMessage getUserMessageFromIdMessage(Integer idmessage);
}
