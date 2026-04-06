package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CallParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private CallSession callSessions;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    private boolean audioEnabled;
    private boolean videoEnabled;
    private boolean screenSharing;

    private LocalDateTime joinedAt;
    private LocalDateTime leftAt;
}
