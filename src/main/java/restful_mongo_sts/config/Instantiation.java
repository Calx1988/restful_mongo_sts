package restful_mongo_sts.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import restful_mongo_sts.domain.Post;
import restful_mongo_sts.domain.User;
import restful_mongo_sts.dto.AuthorDTO;
import restful_mongo_sts.repositories.PostRepository;
import restful_mongo_sts.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postReposiroty.deleteAll();
		
		User o1 = new User(null, "Maria Anastasia", "mariasilva@gmail.com");
		User o2 = new User(null, "Olga Nikolaevna", "olganiko@outlook.com");
		User o3 = new User(null, "Tatiana Romanov", "tatiromanov@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		Post post1 = new Post(null, sdf.parse("10/05/2022"), "Partiu!", "Viajando para Liechtenstein. Abraços!", new AuthorDTO(o1));
		Post post2 = new Post(null, sdf.parse("02/05/2022"), "Bom dia!", "Acordei feliz hoje! Visto aprovado!", new AuthorDTO(o1));
		Post post3 = new Post(null, sdf.parse("07/05/2022"), "Calorão!", "Que venha o inverno logo!", new AuthorDTO(o3));
		
		postReposiroty.saveAll(Arrays.asList(post1, post2, post3));
		
		o1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(o1);
		o3.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(o3);
				
	}

}
