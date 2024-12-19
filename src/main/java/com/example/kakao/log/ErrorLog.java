package com.example.kakao.log;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="error_log_tb")
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private Integer userId;
    @Column(nullable = false)
    private String userIp;
    @Column(nullable = false)
    private String userAgent;
    @Column(nullable = false, length = 1000)
    private String message;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }
    // v0.2.2 CouponIssue Validation - CouponIssue 트랜잭션 기능
    // - @PrePersist 메서드를 추가하여 dateIssued가 null일 경우 자동으로 현재 시간을 설정

    @Builder
    public ErrorLog(int id, Integer userId, String userIp, String userAgent, String message, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.userIp = userIp;
        this.userAgent = userAgent;
        this.message = message;
        this.createdAt = createdAt;
    }
}
