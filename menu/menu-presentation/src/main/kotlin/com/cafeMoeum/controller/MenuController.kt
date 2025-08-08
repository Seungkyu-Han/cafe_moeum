package com.cafeMoeum.controller

import com.cafeMoeum.dto.CategoryMenuRes
import com.cafeMoeum.service.MenuService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menus")
@Tag(name = "메뉴 API", description = "해당 카페의 메뉴와 카테고리 정보를 가져옵니다.")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping("/{cafeType}")
    @Operation(summary = "카페의 메뉴와 카테고리를 가져옵니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "메뉴 및 카테고리 조회 성공")
    )
    fun getMenus(@PathVariable cafeType: String): ResponseEntity<List<CategoryMenuRes>> {
        return ResponseEntity.ok(menuService.getCafeInfo(cafeType))
    }

    @GetMapping("/search")
    @Operation(summary = "키워드로 메뉴들을 검색합니다")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "검색 성공")
    )
    fun getSearchMenu(@RequestParam keyword: String): ResponseEntity<List<CategoryMenuRes>> {
        return ResponseEntity.ok(menuService.getCafeInfo(keyword))
    }
}