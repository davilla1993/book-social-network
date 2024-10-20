package com.follygbossou.booksocial.token;

import com.follygbossou.booksocial.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String token;

    private LocalDateTime createdAt;
    private LocalDateTime expireAt;
    private LocalDateTime validateAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
