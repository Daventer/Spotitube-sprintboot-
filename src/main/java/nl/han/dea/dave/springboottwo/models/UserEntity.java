package nl.han.dea.dave.springboottwo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue
    private int id;
    private String user;
    private String password;
    private String token;

    public UserEntity(int id, String user, String password, String token){
        this.id = id;
        this.user = user;
        this.password = password;
        this.token = token;
    }

    public UserEntity(){

    }

    public String getUser() {
        return user;
    }

    public String getPassword(){
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}