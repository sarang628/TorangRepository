package com.sryang.torang_repository.repository.impl

import android.content.Context
import com.sryang.torang_repository.api.ApiProfile
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.EditProfileRepository
import com.sryang.torang_repository.repository.EditProfileResponse
import com.sryang.torang_repository.session.SessionClientService
import com.sryang.torang_repository.util.CountingFileRequestBody
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
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
    private val apiProfile: ApiProfile,
    private val sessionClientService: SessionClientService
) : EditProfileRepository {
    override suspend fun editProfile(
        name: String?,
        uri: String?
    ): EditProfileResponse {
        var response = EditProfileResponse.NO_USER

        val userId = sessionClientService.getToken()!!

        val params: HashMap<String, RequestBody> = HashMap()
        params["user_name"] = ("" + name).toRequestBody("text/plain".toMediaTypeOrNull())
        params["user_id"] = ("" + userId).toRequestBody("text/plain".toMediaTypeOrNull())

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

        // 레트로핏으로 사용자 프로필 업데이트 Rest API 처리
        apiProfile.updateProfile(userId, params, pictureList).let {
            it.data?.let {
                response = EditProfileResponse.SUCCESS
            }
        }

        return response
    }
}