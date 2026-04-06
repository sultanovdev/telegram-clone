package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CallParticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private CallSessions callSessions;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    private boolean audioEnabled;
    private boolean videoEnabled;
    private boolean screenSharing;

    private LocalDateTime joinedAt;
    private LocalDateTime leftAt;
}
