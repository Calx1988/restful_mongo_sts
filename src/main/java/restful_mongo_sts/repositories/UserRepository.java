package restful_mongo_sts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import restful_mongo_sts.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
