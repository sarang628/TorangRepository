package com.sarang.torang.repository.comment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import com.sarang.torang.data.ToComposable
import com.sarang.torang.data.entity.CommentEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

interface CommentRepository {
    suspend fun getComment(reviewId: Int): RemoteCommentList
    suspend fun getSubComment(parentCommentId: Int): List<RemoteComment>
    suspend fun deleteComment(commentId: Int)

    /**
     * @param onLocalUpdated 로컬 DB에 우선 insert하고 callback. 화면을 최상단으로 올리기전에 DB에 insert가 먼저 되어야 해서
     */
    suspend fun addComment(reviewId: Int, comment: String, onLocalUpdated: () -> Unit)
    suspend fun addReply(reviewId: Int, comment: String, parentCommentId: Int)
    suspend fun getCommentsWithOneReply(reviewId: Int): RemoteCommentList
    suspend fun getSubComments(commentId: Int): List<RemoteComment>
    fun getCommentsFlow(reviewId: Int): Flow<List<CommentEntity>>
    suspend fun clear()
    suspend fun loadMoreReply(commentId: Int)
}