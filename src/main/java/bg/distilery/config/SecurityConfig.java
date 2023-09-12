package bg.distilery.config;

import bg.distilery.repositories.UserRepository;
import bg.distilery.services.user.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher("/**").authorizeHttpRequests(rmr -> rmr
//                .requestMatchers("/login", "/register").permitAll()
//                .requestMatchers("/**").permitAll());

        http.authorizeHttpRequests(r -> r.requestMatchers("/**").permitAll()).csrf().disable();

        return http.build();
    }


}
