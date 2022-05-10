package restful_mongo_sts.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import restful_mongo_sts.domain.User;
import restful_mongo_sts.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User o1 = new User(null, "Maria Anastasia", "mariasilva@gmail.com");
		User o2 = new User(null, "Olga Nikolaevna", "olganiko@outlook.com");
		User o3 = new User(null, "Tatiana Romanov", "tatiromanov@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
		
	}

}
