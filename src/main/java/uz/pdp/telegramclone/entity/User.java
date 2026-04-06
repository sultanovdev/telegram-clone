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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;
    private String profilePhotoUrl;
    private String bio;
    private UserStatus status;
    private LocalDateTime createdAt;

    private LocalDateTime lastActivityTime;


}
