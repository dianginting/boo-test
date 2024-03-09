package com.example.domain.port.in

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotNull

@Introspected
@Serdeable
class ProfileDataCommand {
    @NotNull(message = "email must be not null")
    String email
    @NotNull(message = "full Name must be not null")
    String fullName
    String picture
    String description
    String mbti
    String enneagram
    String variant
    Integer tritype
    String socionics
    String sloan
    String psyche


}
