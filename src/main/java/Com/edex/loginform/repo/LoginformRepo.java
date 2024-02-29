package Com.edex.loginform.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Com.edex.loginform.*;
import Com.edex.loginform.model.LoginForm;


@Repository
public interface LoginformRepo extends JpaRepository<LoginForm, Integer>{

//	
//	@Query(value = "SELECT * FROM LOGIN WHERE email == : email", nativeQuery = true)
//
//	List<Login>findByeEmail(String email);
//	
	
	
	@Query(value = "Select * from logindetail Where username = :username AND password = :password", nativeQuery = true)
	LoginForm findBy(String username, String password);
	
}
