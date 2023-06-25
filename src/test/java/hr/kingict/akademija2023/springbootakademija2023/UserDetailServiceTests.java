package hr.kingict.akademija2023.springbootakademija2023;

import hr.kingict.akademija2023.springbootakademija2023.mapper.UserEntityUserDetailMapper;
import hr.kingict.akademija2023.springbootakademija2023.model.UserDetailImpl;
import hr.kingict.akademija2023.springbootakademija2023.model.UserEntity;
import hr.kingict.akademija2023.springbootakademija2023.repository.UserRepository;
import hr.kingict.akademija2023.springbootakademija2023.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserDetailServiceTests {

    @BeforeEach
    private void init(){

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("marko");
        userEntity.setRole("ADMIN");

        UserDetailImpl userDetail = new UserDetailImpl();
        userDetail.setUsername(userEntity.getUsername());
        userDetail.setRole(userEntity.getRole());

        Mockito.when(userRepository.findByUsername("marko")).thenReturn(userEntity);
        Mockito.when(userEntityUserDetailMapper.map(userEntity)).thenReturn(userDetail);
    }

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityUserDetailMapper userEntityUserDetailMapper;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    public void testFindByLoadUserByUsernameAndAccountNonLocked(){

        UserDetails userDetails = userDetailsService.loadUserByUsername("marko");
        assertEquals(true, userDetails.isAccountNonLocked());
    }

    @Test
    public void testFindByLoadUserByUsernameAndAccountNonExpired(){

        UserDetails userDetails = userDetailsService.loadUserByUsername("marko");
        assertEquals(true, userDetails.isAccountNonExpired());
    }


    @Test
    public void testFindByLoadUserByUsernameAndCredentialsNonLocked(){

        UserDetails userDetails = userDetailsService.loadUserByUsername("marko");
        assertEquals(true, userDetails.isCredentialsNonExpired());
    }
}
