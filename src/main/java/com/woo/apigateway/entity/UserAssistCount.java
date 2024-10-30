package com.woo.apigateway.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class UserAssistCount {

    private static final Long INITIAL_COUNT = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private Long count;

    @Builder
    public UserAssistCount(User user) {
        this.user = user;
        this.count = INITIAL_COUNT;
    }

    public void useCount() {
        this.count -= 1;
    }

    public void initialCount() {
        this.count = INITIAL_COUNT;
    }
}
