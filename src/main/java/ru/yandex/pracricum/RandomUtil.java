package ru.yandex.pracricum;

import com.github.javafaker.Faker;
import ru.yandex.pracricum.page.dto.User;

public class RandomUtil {
    private static final Faker faker = new Faker();

    public static User getRandomUser() {
        return User.builder()
                .name(faker.name().firstName())
                .email(faker.bothify("????##@example.test"))
                .password(faker.bothify("??##??##?#"))
                .build();
    }
}
