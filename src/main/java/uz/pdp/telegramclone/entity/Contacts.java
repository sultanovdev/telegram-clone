package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.entity.enums.ContactStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private User contact;
    private ContactStatus status;
    private LocalDateTime createdAt;

}
