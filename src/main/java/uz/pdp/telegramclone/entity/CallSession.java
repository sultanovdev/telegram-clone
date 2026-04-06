package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.enums.CallStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CallSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false)
    private ChatRoom chatRoom;
    private CallStatus callStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
