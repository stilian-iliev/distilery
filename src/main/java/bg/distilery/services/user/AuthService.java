package bg.distilery.services.user;

import bg.distilery.models.user.User;
import bg.distilery.models.user.dto.RegisterDto;
import bg.distilery.models.user.enums.UserRoleEnum;
import bg.distilery.repositories.UserRepository;
import bg.distilery.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserRoleRepository roleRepository;
    private final ModelMapper userMapper;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, UserRoleRepository roleRepository, @Qualifier("userMapper") ModelMapper userMapper, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }

    public void register(RegisterDto registerDto) {
        User user = userMapper.map(registerDto, User.class);
        user.addRole(roleRepository.findByName(UserRoleEnum.USER));
        userRepository.save(user);
    }
}
