package com.vbsoft.project002.resources;
import java.util.List;
import java.util.stream.Collectors;

import com.vbsoft.project002.dto.UserDto;
import com.vbsoft.project002.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vbsoft.project002.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findAll() {
		List<User> list = service.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id){
	    User obj = service.findById(id);
	    return ResponseEntity.ok().body(new UserDto(obj));

   }

}
