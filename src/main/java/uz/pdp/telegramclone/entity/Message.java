package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.enums.MessageType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chatId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User senderId;

    private MessageType messageType;
    private String content;
    private LocalDateTime createdAt;

}
