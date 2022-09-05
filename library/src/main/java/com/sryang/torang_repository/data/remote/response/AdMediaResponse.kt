package com.sryang.torang_repository.data.remote.response

import com.sryang.torang_core.data.entity.CONTENTS_TYPE

data class AdMediaResponse(
    val adMediaId: Int?,
    val url: String?,
    val content_type: CONTENTS_TYPE?,
    val create_date: String?
)
