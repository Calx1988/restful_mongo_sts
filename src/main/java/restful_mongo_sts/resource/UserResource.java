package restful_mongo_sts.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restful_mongo_sts.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User u1 = new User("1", "Maria Silva", "mariasilva@gmail.com");
		User u2 = new User("2", "José dos Santos", "josedsantos@gmail.com");
		List<User> listUsers = new ArrayList<>();
		listUsers.add(u1);
		listUsers.add(u2);
		return ResponseEntity.ok().body(listUsers);
	}
	
}
