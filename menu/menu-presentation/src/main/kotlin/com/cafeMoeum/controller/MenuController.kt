package com.cafeMoeum.controller

import com.cafeMoeum.dto.CategoryRes
import com.cafeMoeum.enums.CafeTypeEnum
import com.cafeMoeum.service.MenuService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menus")
@Tag(name = "메뉴 API", description = "해당 카페의 메뉴와 카테고리 정보를 가져옵니다.")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping
    @Operation(summary = "카페의 메뉴와 카테고리를 가져옵니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "메뉴 및 카테고리 조회 성공")
    )
    fun getMenus(@RequestParam cafeTypeEnum: CafeTypeEnum): ResponseEntity<List<CategoryRes>> {
        return ResponseEntity.ok(menuService.getCafeInfo(cafeTypeEnum.value))
    }
}