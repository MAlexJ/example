package com.malex.lecture_14_optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class OptionalSample {

    @Test
    public void test() {
        // ID:1
        assertEquals(new User("ID:1"), getUser(true, "ID:1"));

        // ID:2
        assertEquals(new User("ID:2"), getUser(false, "ID:1"));
        assertEquals(new User("ID:2"), getUser(true, "XXXX"));
    }

    private User getUser(boolean lazy, String id) {
        return Optional.ofNullable(createUser(lazy))
                .filter(u -> u.getId().contains(id))
                .orElse(new User("ID:2"));
    }

    private User createUser(boolean lazy) {
        return lazy
                ? new User("ID:1")
                : null;
    }


    @Getter
    @EqualsAndHashCode
    @RequiredArgsConstructor
    static class User {
        @NonNull
        private String id;
    }
}
