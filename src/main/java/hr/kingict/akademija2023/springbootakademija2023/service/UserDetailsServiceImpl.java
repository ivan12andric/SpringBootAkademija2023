package hr.kingict.akademija2023.springbootakademija2023.service;

import hr.kingict.akademija2023.springbootakademija2023.mapper.UserEntityUserDetailMapper;
import hr.kingict.akademija2023.springbootakademija2023.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserEntityUserDetailMapper userEntityUserDetailMapper;

    public UserDetailsServiceImpl(UserRepository userRepository, UserEntityUserDetailMapper userEntityUserDetailMapper) {
        this.userRepository = userRepository;
        this.userEntityUserDetailMapper = userEntityUserDetailMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userEntityUserDetailMapper.map(userRepository.findByUsername(username));
    }
}
