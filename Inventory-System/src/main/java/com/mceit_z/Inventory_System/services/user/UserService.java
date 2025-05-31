package com.mceit_z.Inventory_System.services.user;


import com.mceit_z.Inventory_System.models.Rol;
import com.mceit_z.Inventory_System.models.UserProfile;
import com.mceit_z.Inventory_System.repo.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("UserDetailsService")
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private IUser userRepository;


    @Transactional
    public UserProfile createUser(UserProfile user) {
        user.setPassword((user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public UserProfile updateUser(UserProfile user) {
        UserProfile existingUser = userRepository.findById(user.getIdUser())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + user.getIdUser()));
        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }

        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            existingUser.setRoles(user.getRoles());
        }

        return userRepository.save(existingUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found: {}", username);
            throw new UsernameNotFoundException("User not found: " + username);
        }
        var rols = new ArrayList<GrantedAuthority>();

        for (Rol rol : user.getRoles()) {
            rols.add(new SimpleGrantedAuthority(rol.getName()));
        }
        return new User(user.getUsername(), user.getPassword(), rols);
    }
}
