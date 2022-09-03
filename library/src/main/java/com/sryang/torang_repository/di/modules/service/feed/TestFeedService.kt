package com.sryang.torang_repository.di.modules.service.feed

import android.content.Context
import com.example.torangrepository.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sryang.torang_core.data.data.Favorite
import com.sryang.torang_core.data.data.FeedResponse
import com.sryang.torang_core.data.data.Like
import com.sryang.torang_core.data.data.Review
import com.sryang.torang_repository.data.remote.RemoteFeed
import com.sryang.torang_repository.services.FeedServices
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestFeedService @Inject constructor(
    @ApplicationContext val context: Context
) : FeedServices {
    override suspend fun getFeeds(params: Map<String, String>): ArrayList<FeedResponse> {
        val inputStrem: InputStream = context.resources.openRawResource(R.raw.feed)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStrem, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        } finally {
            inputStrem.close()
        }

        val jsonString = writer.toString()

        val gson = Gson()
        val list = gson.fromJson<List<RemoteFeed>>(
            jsonString,
            object : TypeToken<List<RemoteFeed>>() {}.type
        )

        return ArrayList()
    }

    override suspend fun deleteReview(review: Review): Review {
        TODO("Not yet implemented")
    }

    override suspend fun addLike(like: Like): Like {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLike(like: Like): Like {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(favorite: Favorite): Favorite {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(favorite: Favorite): Favorite {
        TODO("Not yet implemented")
    }
}