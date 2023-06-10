package com.sryang.torang_repository.repository.report

/** 신고 저장소 */
interface ReportRepository {
    /** 신고 이유 전송 */
    suspend fun sendReportReason(reportReason: ReportReason, reviewId: Int) : Boolean

    /** 신고 후 지원 작업(차단, 제한 팔로우 취소) */
    suspend fun sendReportAfterSupport(reportAfterSupport: ReportAfterSupport, reviewId: Int) : Boolean
    /** 신고 할 피드가 있는지 여부 */
    suspend fun hasFeed(reviewId: Int) : Boolean
}

/** 신고 이유 */
enum class ReportReason {
    SPAM, // 스팸
    ABUSE, // 나체 이미지 또는 성적 행위
    UNLIKE, // 마음에 들지 않습니다.
    HATEFUL, // 혐오 발언 또는 상징
    FRAUD, // 사기 또는 거짓
    LIE, // 거짓 정보
    OSTRACIZED, // 따돌림 또는 괴롭힘
    VIOLENCE, // 폭력 또는 위험한 단체
    INTELLECTUAL_PROPERTY, // 지적 재산권 침해
    SUICIDE, // 자살 또는 자해
    UNLAWFULNESS, // 불법 또는 규제 상품 판매
    EATING_DISORDER // 섭식 장애
}

/** 신고 후 지원 */
enum class ReportAfterSupport {
    BLOCK, //차단
    LIMIT, // 제한
    UNFOLLOW // 팔로우 취소
}