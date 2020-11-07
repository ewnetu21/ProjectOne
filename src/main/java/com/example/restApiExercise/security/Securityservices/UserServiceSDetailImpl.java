package com.example.restApiExercise.security.Securityservices;

import com.example.restApiExercise.security.jwt.model.User;
import com.example.restApiExercise.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceSDetailImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User	Not	Found	with	->	username	or	email	:	" +
                        username));
        return (UserDetails) UserPrinciple.build(user);
    }
}