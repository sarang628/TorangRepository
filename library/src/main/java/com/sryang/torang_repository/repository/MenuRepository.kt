package com.sryang.torang_repository.repository

import android.view.Menu


/**
 * 메뉴 저장소 인터페이스
 */
interface MenuRepository {
    suspend fun getMenus(restaurantId : Int) : ArrayList<Menu>
}