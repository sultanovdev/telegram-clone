package uz.pdp.telegramclone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.telegramclone.entity.ChatRoom;

import java.util.UUID;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {
}
