package com.example.adapter.in.web

import com.example.application.service.ProfileService
import com.example.domain.port.in.ProfileDataCommand
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.validation.Valid


@Controller("/profile")
class ProfileController {

    final ProfileService service

    ProfileController(ProfileService service){
        this.service = service
    }

    @Post('/')
    HttpStatus initInitialData(@Valid @Body ProfileDataCommand cmd) {
        def data = service.saveOrUpdateData(cmd)
        if(data.first){
            return HttpStatus.CREATED
        }else{
            return HttpStatus.NOT_ACCEPTABLE
        }
    }

    @Get('/{id}')
    def getMedia(Integer id) {
        def detail = service.getProfile(id)
        if(detail.item1){
            return detail.item2
        }else{
            return HttpStatus.NO_CONTENT
        }
    }
}
