package demo.alliance.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.alliance.ne.binarysupermarket.models.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmailOrPhone(String email, String phoneNumber);

    Optional<User> findByEmail(String email);



}
