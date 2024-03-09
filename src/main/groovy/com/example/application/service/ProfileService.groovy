package com.example.application.service

import com.example.adapter.out.persistence.ProfileRepository
import com.example.adapter.out.persistence.model.Profile
import com.example.domain.ProfileDto
import com.example.domain.port.in.ProfileDataCommand
import groovyjarjarantlr4.v4.runtime.misc.Tuple2
import io.micronaut.core.annotation.Nullable
import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotNull

@Singleton
class ProfileService {

    final ProfileRepository profileRepository

    ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository
    }

    Tuple<Boolean> saveOrUpdateData(ProfileDataCommand command){
        Profile initProfile =  createOrUpdateProfile(command.fullName,command.email,
                command.picture,command.description,command.mbti,command.enneagram,
                command.variant,command.tritype,command.socionics,command.sloan,command.psyche)
        return [initProfile != null]
    }

    @Transactional
    Profile createOrUpdateProfile(String fullName,
                                  String email,
                                  @Nullable String picture,
                                  @Nullable String description,
                                  @Nullable String mbti,
                                  @Nullable String eneagram,
                                  @Nullable String variant,
                                  @Nullable Integer tritype,
                                  @Nullable String socionics,
                                  @Nullable String sloan,
                                  @Nullable String psyche){
        Profile init = profileRepository.findByFullNameAndEmail(fullName,email).orElse(
                new Profile(
                        email : email,
                        fullName: fullName
                )
        )
        init.picture = picture
        init.description = description
        init.mbti = mbti
        init.enneagram = eneagram
        init.variant = variant
        init.tritype = tritype
        init.socionics = socionics
        init.sloan = sloan
        init.psyche = psyche
        profileRepository.save(init)
        return init
    }

    @Transactional
    Tuple2<Boolean, ProfileDto> getProfile(@NotNull Integer profileId) {
        def getProfile = profileRepository.findById(profileId)
        if (getProfile.isPresent()) {
            def it = getProfile.get()
            return [true, new ProfileDto(id: it.id,fullName: it.fullName,
                    picture: it.picture, description: it.description,
                    email:it.email,mbti: it.mbti,enneagram: it.enneagram,
                    variant: it.variant,tritype: it.tritype,socionics: it.socionics,
                    sloan: it.sloan,psyche: it.psyche)]
        } else {
            return [false, null]
        }
    }

}
