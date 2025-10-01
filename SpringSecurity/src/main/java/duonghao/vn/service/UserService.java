package duonghao.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import duonghao.vn.dao.RoleRepository;
import duonghao.vn.dao.UserRepository;
import duonghao.vn.entity.Role;
import duonghao.vn.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Inject từ config

    public void saveUser(String username, String password, String roleName) {
        // Tạo role nếu chưa có
        Role role = roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(roleName);
                    return roleRepository.save(newRole);
                });

        // Tạo user
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // Hash password
        user.setEnabled(true);
        user.getRoles().add(role);

        userRepository.save(user);
    }
}