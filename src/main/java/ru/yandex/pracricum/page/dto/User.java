package ru.yandex.pracricum.page.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@Getter
@Builder
@With
@ToString
public class User {
    private String name;
    private String email;
    private String password;
}
