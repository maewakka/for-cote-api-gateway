package com.woo.apigateway.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    private String id;

    @Column(unique = true)
    private String login;
    private String name;
    private String profileImgUrl;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public User(String id, String login, String name, String profileImgUrl) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.profileImgUrl = profileImgUrl;
    }

}
