package restful_mongo_sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restful_mongo_sts.domain.User;
import restful_mongo_sts.dto.UserDTO;
import restful_mongo_sts.repositories.UserRepository;
import restful_mongo_sts.services.exceptions.ObjNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id){
		Optional<User> user = repository.findById(id);
		
			return user.orElseThrow(() -> new ObjNotFoundException("There's no user with this ID."));
	}
	public User insert(User obj) {
		return repository.insert(obj);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
