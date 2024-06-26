package com.example.coffeeshop.base;

import lombok.Builder;

@Builder
public record BaseError<T>(
        String message,
        Integer code,
        Boolean status,
        T errors
) {
}
