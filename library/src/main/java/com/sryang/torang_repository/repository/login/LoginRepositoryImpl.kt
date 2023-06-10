package com.sryang.torang_repository.repository.login

import android.content.Context
import com.sryang.torang_repository.data.User
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.preference.TorangPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
//    private val restaurantService: RestaurantService,
    private val loggedInUserDao: LoggedInUserDao
) : LoginRepository {

//    @Inject
//    lateinit var facebookLoginProvider: FaceBookLoginProviderForRepository

    override suspend fun isLogin(): Boolean {
        return TorangPreference().getUserId(context) != -1
    }

    override suspend fun facebookLogin(token: String): User? {

//        restaurantService.facebook_login(token).data?.let {

//            LoggedInUserEntity.parse(it)?.let {
//                loggedInUserDao.insert(it)
//            }

//            return it
//        }
        return null
    }

    override fun isLoginFlow(): Flow<Int> {
        //return loggedInUserDao.isLpogin()
        return MutableStateFlow(0)
    }

    override fun getLoginUser(): Flow<LoggedInUserEntity?> {
//        return loggedInUserDao.getLoggedInUserEntity()
        return MutableStateFlow(
            LoggedInUserEntity(
                constId = 0,
                userId = 1
            )
        )
    }

    override suspend fun setLoggedInUser(LoggedInUserEntity: LoggedInUserEntity) {
        LoggedInUserEntity.access_token?.let {
            TorangPreference().saveAccessToken(context, it)
        }
        TorangPreference().saveUserId(context, LoggedInUserEntity.userId)
//        loggedInUserDao.insert(LoggedInUserEntity)
    }
}