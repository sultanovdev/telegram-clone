package uz.pdp.telegramclone.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.telegramclone.entity.enums.CallStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CallSessions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false)
    private ChatRooms chatRoom;
    private CallStatus callStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
