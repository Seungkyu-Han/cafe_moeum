package com.cafeMoeum.controller

import com.cafeMoeum.dto.UpdateMenuReq
import com.cafeMoeum.service.UpdateMenuAndCategoryService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sync")
@Tag(name = "카페 메뉴 업데이트 API", description = "해당 카페의 메뉴를 업데이트 해줍니다.")
class SyncController(
    private val updateMenuAndCategoryService: UpdateMenuAndCategoryService
) {

    @PatchMapping
    @Operation(summary = "카페의 메뉴를 업데이트 해줍니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "해당 카페의 메뉴를 성공적으로 업데이트")
    )
    fun updateMenus(@RequestBody updateMenuReq: UpdateMenuReq){
        updateMenuAndCategoryService.update(updateMenuReq.cafeType.value)
    }
}