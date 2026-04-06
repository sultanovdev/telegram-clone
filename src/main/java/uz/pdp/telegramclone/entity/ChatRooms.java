package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.enums.ChatType;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class ChatRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    private String name;
    private ChatType chatType;
    private String profilePhotoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    private LocalDateTime createdAt;

}
