package com.example

import com.example.application.service.CommentService
import com.example.domain.port.in.CommentCommand
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class CommentServiceSpec extends Specification {

    @Inject
    @Shared
    CommentService service

    def 'test can add comment to profile works'() {
        when:
        def cmd = new CommentCommand(
                    email: "test@gmail.com",
                    fullName : "test aaaa",
                    message: "hauwoo")


        def result = service.createProfileCommend(1,cmd)

        then:
        result.first
    }

    def 'test can add like to profile works'() {
        when:
        def cmd = new CommentCommand(
                email: "test@gmail.com",
                fullName : "test aaaa")


        def result = service.addEngagement(1,"like",cmd)

        then:
        result.first
    }

    def 'test get profile works'() {
        when:
        def result = service.getProfileEngagement(1,"comment")

        then:
        result.second.size() > 0
    }
}
