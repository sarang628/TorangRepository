package com.sarang.torang.data

/** 신고 이유 */
enum class ReportReason
{
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
