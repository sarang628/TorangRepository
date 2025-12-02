package com.sarang.torang.repository

import com.sarang.torang.data.ReportAfterSupport
import com.sarang.torang.data.ReportReason

/** 신고 저장소 */
interface ReportRepository
{
    /** 신고 이유 전송 */
    suspend fun sendReportReason(reportReason: ReportReason, reviewId: Int): Boolean

    /** 신고 후 지원 작업(차단, 제한 팔로우 취소) */
    suspend fun sendReportAfterSupport(reportAfterSupport: ReportAfterSupport, reviewId: Int): Boolean

    /** 신고 할 피드가 있는지 여부 */
    suspend fun hasFeed(reviewId: Int): Boolean
}