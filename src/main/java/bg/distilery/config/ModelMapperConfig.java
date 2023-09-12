package bg.distilery.config;

import bg.distilery.models.user.User;
import bg.distilery.models.user.dto.RegisterDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ModelMapperConfig {
    private final PasswordEncoder passwordEncoder;

    public ModelMapperConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Primary
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean("userMapper")
    public ModelMapper userMapper() {
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<RegisterDto, User> typeMap = modelMapper.createTypeMap(RegisterDto.class, User.class);
        typeMap.addMappings(mapping -> mapping.using(passwordEncoderConverter()).map(RegisterDto::getPassword, User::setPassword));

        return modelMapper;
    }

    @Bean
    public Converter<String, String> passwordEncoderConverter() {
        return context -> passwordEncoder.encode(context.getSource());
    }
}
