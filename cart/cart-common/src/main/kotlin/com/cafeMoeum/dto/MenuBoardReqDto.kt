package com.cafeMoeum.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니의 메뉴 변경")
data class MenuBoardReqDto(

    @Schema(description = "장바구니의 메뉴들")
    val menus: List<MenuReqDto>
)
