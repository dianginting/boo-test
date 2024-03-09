package com.example.adapter.in.web

import com.example.application.service.CommentService
import com.example.domain.port.in.CommentCommand
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.QueryValue
import jakarta.validation.Valid

@Controller("/content")
class ContentController {

    final CommentService service

    ContentController(CommentService service){
        this.service = service
    }

    @Put('/{profileId}')
    HttpStatus putComment(Integer profileId,@Valid @Body CommentCommand cmd) {
        def data = service.createProfileCommend(profileId,cmd)
        if(data.first){
            return HttpStatus.CREATED
        }else{
            return HttpStatus.NOT_ACCEPTABLE
        }
    }

    @Put('/{postId}/{type}')
    HttpStatus putComment(Integer postId,String type,@Valid @Body CommentCommand cmd) {
        def data = service.addEngagement(postId,type,cmd)
        if(data.first){
            return HttpStatus.CREATED
        }else{
            return HttpStatus.NOT_ACCEPTABLE
        }
    }

    @Get('profile/')
    def getProfileEngagement(@QueryValue Integer id, @QueryValue Optional<String> type) {
        def data = service.getProfileEngagement(id,type.orElse("comment"))
        if(data.v1){
            return HttpResponse.ok(data.v2)
        }else{
            return HttpStatus.NO_CONTENT
        }
    }

}
