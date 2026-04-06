package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.enums.UserStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ChatParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chat;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    private UserStatus userStatus;
    private LocalDateTime joinedAt;

}
