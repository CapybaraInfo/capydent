package info.capybaratech.capydent.services.impls;

import info.capybaratech.capydent.entities.LoginUser;
import info.capybaratech.capydent.repositories.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements UserDetailsService {
    private LoginRepository loginRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional = loginRepository.loadUserByUsername(username);
        if(userOptional.isEmpty()) throw  new UsernameNotFoundException("Bad credentials");
        var user = userOptional.get();
        return new LoginUser(user.getId(),user.getFullName(), user.getEmail(), user.getUserName(), user.getEncodedPass(), user.getAuthority(),user.isEnabled());
    }
}
