package org.com.core.basic;

import java.util.Objects;

public record People(String name, int age, String address, int department) {
    public People {
        Objects.requireNonNull(name);
    }
}