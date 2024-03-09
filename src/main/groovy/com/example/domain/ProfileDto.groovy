package com.example.domain

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import io.micronaut.serde.annotation.Serdeable

@Builder
@CompileStatic
@Serdeable
class ProfileDto {
    Integer id
    String email
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
