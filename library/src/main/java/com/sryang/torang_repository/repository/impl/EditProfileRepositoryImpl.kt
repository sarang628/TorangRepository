package com.sryang.torang_repository.repository.impl

import android.content.Context
import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.EditProfileRepository
import com.sryang.torang_repository.repository.EditProfileResponse
import com.sryang.torang_repository.repository.preference.TorangPreference
import com.sryang.torang_repository.services.RestaurantService
import com.sryang.torang_repository.util.CountingFileRequestBody
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.set

@Singleton
class EditProfileRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val restaurantService: RestaurantService,
    private val loggedInUserDao: LoggedInUserDao,
    private val userDao: UserDao
) : EditProfileRepository {
    override suspend fun editProfile(name: String?, uri: String?): EditProfileResponse {

        var response = EditProfileResponse.NO_USER

        val params: HashMap<String, RequestBody> = HashMap()
        params["user_name"] = ("" + name).toRequestBody("text/plain".toMediaTypeOrNull())
        params["user_id"] = ("" + loggedInUserDao.getLoggedInUserEntity1()?.userId).toRequestBody("text/plain".toMediaTypeOrNull())

        val pictureList = ArrayList<MultipartBody.Part>()
        if (uri != null) {
            val file = File(uri)
            val requestFile = CountingFileRequestBody(file, "image/*", object :
                CountingFileRequestBody.ProgressListener {
                override fun transferred(num: Long) {

                }
            })
            pictureList.add(MultipartBody.Part.createFormData("file", file.name, requestFile))
        }

        try {
            // 레트로핏으로 사용자 프로필 업데이트 Rest API 처리
            restaurantService.updateProfile(params, pictureList).let {
                it.data?.let {
                    // 통신 결과값을 Room을 이용하여 DB update : 로그인한 사용자 정보
//                    loggedInUserDao.update(user.userName, user.profilePicUrl)
                    // 통신 결과값을 Room을 이용하여 DB update : 일반 사용자 정보
//                    userDao.update(
//                        TorangPreference().getUserId(context),
//                        user.userName,
//                        user.profilePicUrl
//                    )
                    response = EditProfileResponse.SUCCESS
                }
            }
        } catch (e: Exception) {
        }

        return response
    }


    override fun getUser(): LiveData<LoggedInUserEntity?> {
        return loggedInUserDao.getLoggedInUserEntity()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class EditProfileRepositoryModule {
    @Binds
    abstract fun provideEditProfileRepository(editProfileRepositoryImpl: EditProfileRepositoryImpl): EditProfileRepository
}
