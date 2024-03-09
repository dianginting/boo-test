package com.example.application.service

import com.example.adapter.out.persistence.PostRepository
import com.example.adapter.out.persistence.model.Post
import com.example.adapter.out.persistence.model.Profile
import com.example.domain.EngagementDto
import com.example.domain.port.in.CommentCommand
import io.micronaut.core.annotation.Nullable
import jakarta.inject.Singleton
import jakarta.transaction.Transactional

@Singleton
class CommentService {

    final PostRepository postRepository
    final ProfileService profileService

    CommentService(PostRepository postRepository,ProfileService profileService){
        this.postRepository = postRepository
        this.profileService = profileService
    }

    Tuple<Boolean> createProfileCommend(Integer profileId, CommentCommand cmd){
        Profile commenter = profileService.createOrUpdateProfile(cmd.fullName,cmd.email,
                null,null,null,null,null,
                null,null,null,null)
        Post initPost = createOrUpdateComment(profileId,commenter,'comment',cmd.message )
        return [initPost != null]
    }

    @Transactional
    Post createOrUpdateComment(Integer profileId, Profile commenter,String type,@Nullable String message){
        Post init = postRepository.findByProfileAndTypeAndProfileId(commenter,type,profileId).orElse(
                new Post(
                        profile : commenter,
                        profileId: profileId,
                        type: type
                )
        )
        init.message = message
        postRepository.save(init)
        return init
    }

    Tuple<Boolean> addEngagement(Integer postId, String type,CommentCommand cmd ){
        Profile commenter = profileService.createOrUpdateProfile(cmd.fullName,cmd.email,
                null,null,null,null,null,
                null,null,null,null)
        Post addEngagement = createOrUpdateComment(postId,commenter,type,null )
        return [addEngagement != null]
    }

    Tuple2<Boolean, List<EngagementDto>> getProfileEngagement(Integer profileId, String type){
        def listPost = postRepository.findAllByProfileIdAndType(profileId,type)

        def getProfile = profileService.getProfile(profileId)

        def listEngagement = listPost.collect {
            new EngagementDto(
                    profile: getProfile.item2,
                    commenterName: it.profile.fullName,
                    commenterPicture: it.profile.picture,
                    commenterId: it.profile.id,
                    type: it.type,
                    message: it.message,
                    totalLike: postRepository.countByTypeAndProfileId('like',profileId)
            )
        }

        return [listEngagement.size() > 0, listEngagement]


    }
}
