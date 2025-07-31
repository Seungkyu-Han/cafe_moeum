package com.cafeMoeum.controller

import com.cafeMoeum.dto.CafeInfoRes
import com.cafeMoeum.enums.CafeTypeEnum
import com.cafeMoeum.service.MenuService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menus")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping
    fun getMenus(@RequestParam cafeTypeEnum: CafeTypeEnum): ResponseEntity<CafeInfoRes> {
        return ResponseEntity.ok(menuService.getCafeInfo(cafeTypeEnum.value))
    }
}