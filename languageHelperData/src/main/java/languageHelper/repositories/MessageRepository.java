package languageHelper.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import languageHelper.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
	@Query("SELECT m FROM Message m where m.idmessage in :ids and (m.idmessage,m.datemessage) in (select m1.idrequest,max(m1.datemessage) from Message m1 group by m1.idrequest)")
	Iterable<Message> getMessagesFromIds(@Param("ids") List<Integer> ids);
	@Query("SELECT m FROM Message m where m.idmessage = ?1")
	Message getMessageFromId(int idMess);

}
