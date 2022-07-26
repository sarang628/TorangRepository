package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.entity.Menu

/**
 * 메뉴 저장소 인터페이스
 */
interface MenuRepository {
    suspend fun getMenus(restaurantId : Int) : ArrayList<Menu>
}