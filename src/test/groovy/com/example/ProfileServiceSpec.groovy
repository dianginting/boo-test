package com.example

import com.example.application.service.ProfileService
import com.example.domain.port.in.ProfileDataCommand
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ProfileServiceSpec extends Specification {

    @Inject
    @Shared
    ProfileService service

    def 'test create profile works'() {
        when:
        def cmd = new ProfileDataCommand(
                    email: "test@gmail.com",
                    fullName : "test aaaa",
                    description: "Adolph Larrue Martinez III.",
                    mbti: "ISFJ",
                    enneagram: "9w3",
                    variant: "sp/so",
                    tritype: 725,
                    socionics: "SEE",
                    sloan: "RCOEN",
                    psyche: "FEVL",
                    picture: "https://soulverse.boo.world/images/1.png")


        def result = service.saveOrUpdateData(cmd)

        then:
        result.first
    }

    def 'test get profile works'() {
        when:
        def result = service.getProfile(1)

        then:
        result.item2 != null
    }
}
