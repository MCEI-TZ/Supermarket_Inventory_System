package com.mceit_z.Inventory_System.services.user;


import lombok.extern.slf4j.Slf4j;
import com.mceit_z.Inventory_System.models.Rol;
import com.mceit_z.Inventory_System.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mceit_z.Inventory_System.repo.IUser;

import java.util.ArrayList;

@Service("UserDetailsService")
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private IUser userRepository;


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
