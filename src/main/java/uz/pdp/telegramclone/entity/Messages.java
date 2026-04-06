package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.entity.enums.MessageType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRooms chatId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User senderId;

    private MessageType messageType;
    private String content;
    private LocalDateTime createdAt;

}
