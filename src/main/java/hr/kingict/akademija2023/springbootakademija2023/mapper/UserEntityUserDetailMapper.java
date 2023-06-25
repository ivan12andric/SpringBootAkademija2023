package hr.kingict.akademija2023.springbootakademija2023.mapper;

import hr.kingict.akademija2023.springbootakademija2023.model.UserDetailImpl;
import hr.kingict.akademija2023.springbootakademija2023.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserEntityUserDetailMapper {

    public UserDetails map(UserEntity userEntity){

        if(userEntity == null)
        {
            return null;
        }

        UserDetailImpl userDetail = new UserDetailImpl();
        userDetail.setUsername(userEntity.getUsername());
        userDetail.setPassword(userEntity.getPassword());
        userDetail.setRole(userEntity.getRole());
        userDetail.setActive(userEntity.getActive());

        return userDetail;
    }
}
