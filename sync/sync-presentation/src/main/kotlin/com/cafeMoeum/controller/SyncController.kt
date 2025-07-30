package com.cafeMoeum.controller

import com.cafeMoeum.dto.UpdateMenuReq
import com.cafeMoeum.service.UpdateMenuAndCategoryService
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sync")
class SyncController(
    private val updateMenuAndCategoryService: UpdateMenuAndCategoryService
) {

    @PatchMapping
    fun updateMenus(@RequestBody updateMenuReq: UpdateMenuReq){
        updateMenuAndCategoryService.update(updateMenuReq.cafe.value)
    }
}