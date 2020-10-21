package com.vbsoft.project002.services;

import com.vbsoft.project002.domain.User;
import com.vbsoft.project002.dto.UserDto;
import com.vbsoft.project002.repository.UserRepository;
import com.vbsoft.project002.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
    return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado"));
    }

    public User insert (User obj){
        return repo.insert(obj);
    }


    public void delete (String id) {
     repo.deleteById(id);
    }


    public User fromDTO (UserDto objDto) {
        return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
    }
}
