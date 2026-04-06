package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.entity.enums.UserStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ChatParticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRooms chat;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    private UserStatus userStatus;
    private LocalDateTime joinedAt;

}
