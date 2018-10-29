package nl.han.dea.dave.springboottwo.services;

import nl.han.dea.dave.springboottwo.datasource.LoginRepository;
import nl.han.dea.dave.springboottwo.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean authentication(String userName, String password) {
        return userExists(userName) && passwordEqualsPasswordFromUser(userName, password);
    }

    public boolean userExists(String userName){
        return loginRepository.getTotalOfUserName(userName) != 0;
    }

    public boolean passwordEqualsPasswordFromUser(String userName, String password){
        UserEntity user = loginRepository.findUserByUserName(userName);

        return user.getPassword().equals(password);
    }

    public void setNewTokenForUser(String userName, String token){
        loginRepository.setNewTokenForUser(token, userName);
    }
}
