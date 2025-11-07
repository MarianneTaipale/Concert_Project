package syksy25.backend.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import syksy25.backend.domain.User;
import syksy25.backend.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository uRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.uRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User current = uRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, current.getPasswordHash(),
                AuthorityUtils.createAuthorityList(current.getRole()));
        return user;
    }
}
