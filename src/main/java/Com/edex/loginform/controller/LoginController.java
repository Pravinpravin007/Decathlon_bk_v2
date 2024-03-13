package Com.edex.loginform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.edex.*;
import Com.edex.loginform.LoginformApplication;
import Com.edex.loginform.model.LoginForm;
import Com.edex.loginform.repo.LoginformRepo;
import Com.edex.*;

@RestController
@RequestMapping("/form")
public class LoginController {
	
	@Autowired
	private LoginformRepo loginformRepo;
	@PostMapping("/signup")
	
	public ResponseEntity<?> signMapping(@RequestBody LoginForm loginform){
		 try {
	            loginformRepo.saveAndFlush(loginform);
	            return ResponseEntity.status(HttpStatus.OK)
	                                 .body("Registration Successful");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Error occurred during registration");
	        }
	}

	@PostMapping("/login")	
	public ResponseEntity<?> loginMapping(@RequestBody LoginForm loginform){
		
		System.out.println(loginform.getUsername());
		
		String a =loginform.getUsername();
	    String b = loginform.getPassword();
				 
		LoginForm log = loginformRepo.findBy(a, b);
      
      return ResponseEntity.status(HttpStatus.OK)
      		.body(log);
		
	}
}


