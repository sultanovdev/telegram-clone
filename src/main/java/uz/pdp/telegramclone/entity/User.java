package uz.pdp.telegramclone.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.entity.enums.UserStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

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


}
