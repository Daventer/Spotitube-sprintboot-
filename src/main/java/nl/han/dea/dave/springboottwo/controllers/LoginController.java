package nl.han.dea.dave.springboottwo.controllers;

import net.moznion.random.string.RandomStringGenerator;
import nl.han.dea.dave.springboottwo.models.UserEntity;
import nl.han.dea.dave.springboottwo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    private RandomStringGenerator generator = new RandomStringGenerator();

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity userEntity) {
        String userName = userEntity.getUser();
        String password = userEntity.getPassword();
        if (loginService.authentication(userName, password)) {
            String token = generator.generateFromPattern("nnnn.nnnn.nnnn");
            userEntity.setToken(token);
            loginService.setNewTokenForUser(userName, token);
            return ResponseEntity.ok(userEntity);
        }
        return null;
    }
}
