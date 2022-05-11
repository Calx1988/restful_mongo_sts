package restful_mongo_sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restful_mongo_sts.domain.Post;
import restful_mongo_sts.repositories.PostRepository;
import restful_mongo_sts.services.exceptions.ObjNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;

	public Post findById(String id){
		Optional<Post> post = repository.findById(id);
		
			return post.orElseThrow(() -> new ObjNotFoundException("There's no user with this ID."));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);	}
}
