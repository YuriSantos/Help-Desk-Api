package br.com.helpdesk.service.impl;

import br.com.helpdesk.entity.User;
import br.com.helpdesk.repository.UserRepository;
import br.com.helpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User createOrUpdate(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        this.userRepository.delete(findById(id));
    }

    @Override
    public Page<User> findAll(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return this.userRepository.findAll(pages);
    }
}
