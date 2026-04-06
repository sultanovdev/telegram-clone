package uz.pdp.telegramclone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.telegramclone.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
