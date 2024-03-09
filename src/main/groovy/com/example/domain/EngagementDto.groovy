package com.example.domain

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import io.micronaut.serde.annotation.Serdeable

@Builder
@CompileStatic
@Serdeable
class EngagementDto {
    ProfileDto profile
    String commenterName
    String commenterId
    String commenterPicture
    String type
    String message
    Integer totalLike
}
