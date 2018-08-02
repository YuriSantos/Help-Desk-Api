package br.com.helpdesk.repository;

import br.com.helpdesk.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    User findByEmail(String email);
}
