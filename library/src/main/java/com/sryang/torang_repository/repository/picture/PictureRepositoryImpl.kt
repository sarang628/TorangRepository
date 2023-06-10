package com.sryang.torang_repository.repository.picture

import android.graphics.Picture
import com.sryang.torang_repository.data.dao.PictureDao
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.services.RestaurantService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PicturesRepositoryImpl @Inject constructor(
    private val restaurantService: RestaurantService,
    private val pictureDao: PictureDao
) :
    PicturesRepository {
    override suspend fun getPictures(restaurantId: Int): ArrayList<Picture> {
        return restaurantService.getPictures(HashMap<String, String>().apply {
            put("restaurant_id", restaurantId.toString())
        })
    }

    override fun getFeedPicture(reviewId: Int): Flow<List<ReviewImageEntity>> {
//        Logger.d(reviewId)
        return pictureDao.getFeedImage(reviewId)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class PictureRepositoryModule {
    @Binds
    abstract fun bindPictureRepositoryModule(pictureRepositoryImpl: PicturesRepositoryImpl)
            : PicturesRepository
}