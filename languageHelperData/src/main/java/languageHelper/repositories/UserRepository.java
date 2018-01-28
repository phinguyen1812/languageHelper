package languageHelper.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import languageHelper.entities.User;


public interface UserRepository extends CrudRepository<User, Integer> {
		@Query("select u from User u where u.iduser=?1")
		User getUserByID(int iduser);
		@Query("select u from User u where u.username=?1")
		User findUserByUsername(String userName);
		@Query("select u from User u where u.username=?1 and u.password =?2")
		User findUserByUsernameAndPassword(String userName,String password);
}
