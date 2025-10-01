package duonghao.vn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import duonghao.vn.dao.UserRepository;
import duonghao.vn.entity.User;
import duonghao.vn.security.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUsername(username);
        User user = userOpt.orElseThrow(() -> 
            new UsernameNotFoundException("User not found: " + username));
        return new CustomUserDetails(user);
    }
}