package com.name.airportt.enums;

public enum Purpose {
    BUSINESS,
    VACATION,
    SUSPICIOUS;

    public static Purpose fromString(String value) {
        for (Purpose p : Purpose.values()) {
            if (p.name().equalsIgnoreCase(value)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid purpose. Allowed values: BUSINESS, VACATION, SUSPICIOUS");
    }
}
