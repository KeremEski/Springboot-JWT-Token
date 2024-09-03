//Bunu oluştur !
package com.security.base.service;
/*
 * Bu sınıfı oluşturmak zorundayız. Burada user objemizin repositorysi 
 * kullanılır. UserDetails imiz UserPrincipaldı. Buradaki
 * loadByUsername kısmında useri bulup details classımıza çeviriyoruz.
 * Bunuda securityconfigte kullanıyoruz.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.base.entity.User;
import com.security.base.entity.UserPrincipal;
import com.security.base.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user ==null){
            throw new UsernameNotFoundException("Username Not Found");
        }
        return new UserPrincipal(user);
    }
    
}
