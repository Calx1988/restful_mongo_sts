package restful_mongo_sts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import restful_mongo_sts.domain.Post;
	
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}