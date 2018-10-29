package nl.han.dea.dave.springboottwo.datasource;

import nl.han.dea.dave.springboottwo.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from users where user = ?1", nativeQuery=true)
    UserEntity findUserByUserName(String userName);

    @Query(value = "select count(*) as total from users where user = ?1", nativeQuery = true)
    int getTotalOfUserName(String userName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET token= ?1 where user = ?2", nativeQuery = true)
    int setNewTokenForUser(String token, String userName);
}