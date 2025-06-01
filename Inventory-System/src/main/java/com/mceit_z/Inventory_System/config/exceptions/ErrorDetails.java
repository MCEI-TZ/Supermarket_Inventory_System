package com.mceit_z.Inventory_System.config.exceptions;

import java.time.Instant;

public record ErrorDetails(
        Instant timestamp,
        String message,
        String details,
        String errorCode,
        int statusCode
) { }
