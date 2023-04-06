package com.developlife.reviewtwits.review;

import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import static com.developlife.reviewtwits.DocumentFormatProvider.*;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;

/**
 * @author WhalesBob
 * @since 2023-04-03
 */
public class SnsReviewDocument {
    public static final Snippet AccessTokenHeader = requestHeaders(
            headerWithName("X-AUTH-TOKEN").description("access token").optional()
    );

    public static final Snippet ReviewIdAndSizeField = requestParameters(
            parameterWithName("reviewId").description("리뷰의 아이디").optional(),
            parameterWithName("size").attributes(required()).description("요청하는 페이지 사이즈")
    );

    public static final Snippet SnsReviewWriteRequestField = requestParts(
            partWithName("productURL").attributes(required())
                    .description("product 등록을 위한 URL 값입니다. http 혹은 https 로 시작하는 인터넷 URL 형식이어야 합니다."),
            partWithName("content").attributes(required())
                    .description("리뷰 글입니다. 10자 이상 입력해야 합니다."),
            partWithName("score").attributes(required())
                    .description("별점입니다. 0점부터 5점 사이의 정수로 입력할 수 있습니다"),
            partWithName("multipartImageFiles").attributes(required())
                    .description("리뷰에 등록하는 이미지 파일들입니다. 여러 장 등록할 수 있습니다."),
            partWithName("productName").attributes(required())
                    .description("검색에 등록된 리뷰 이름입니다.")
    );

    public static final Snippet ReviewIdField = pathParameters(
            parameterWithName("reviewId").attributes(required()).description("작성할 댓글의 리뷰 아이디")
    );

    public static final Snippet SnsCommentWriteRequestField = requestFields(
            fieldWithPath("content").type(JsonFieldType.STRING).attributes(required()).description("댓글 내용"),
            fieldWithPath("parentId").type(JsonFieldType.NUMBER).attributes(required()).description("부모 댓글 아이디")
    );

    public static final Snippet CommentIdField = pathParameters(
            parameterWithName("commentId").attributes(required())
                    .description("수정 또는 삭제할 댓글의 아이디입니다.")
    );

    public static final Snippet SnsCommentChangeRequestField = requestParameters(
            parameterWithName("content").attributes(required())
                    .description("수정하고자 하는 댓글의 내용입니다.")
    );

    public static final Snippet SnsReactionAddRequestField = requestParameters(
            parameterWithName("reaction").attributes(required())
                    .description("추가하고자 하는 리액션 내용입니다.")
    );

    public static final Snippet SnsReviewFeedResponseField = responseFields(
            fieldWithPath("[].createdDate").type(JsonFieldType.ARRAY).description("생성시간"),
            fieldWithPath("[].lastModifiedDate").type(JsonFieldType.ARRAY).description("마지막수정시간"),
            fieldWithPath("[].reviewId").type(JsonFieldType.NUMBER).description("리뷰 아이디"),
            fieldWithPath("[].userInfo.nickname").type(JsonFieldType.STRING).description("유저닉네임"),
            fieldWithPath("[].userInfo.accountId").type(JsonFieldType.STRING).description("유저 계정"),
            fieldWithPath("[].userInfo.introduceText").type(JsonFieldType.STRING).description("유저 한줄소개").optional(),
            fieldWithPath("[].userInfo.profileImage").type(JsonFieldType.STRING).description("프로필이미지 파일이름").optional(),
            fieldWithPath("[].content").type(JsonFieldType.STRING).description("리뷰내용"),
            fieldWithPath("[].productUrl").type(JsonFieldType.STRING).description("제품 URL"),
            fieldWithPath("[].productName").type(JsonFieldType.STRING).description("제품이름"),
            fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("별점"),
            fieldWithPath("[].reviewImageNameList").type(JsonFieldType.ARRAY).description("리뷰이미지이름 리스트"),
            fieldWithPath("[].commentCount").type(JsonFieldType.NUMBER).description("댓글갯수"),
            fieldWithPath("[].reactionResponses").type(JsonFieldType.OBJECT).description("리액션"),
            fieldWithPath("[].exist").type(JsonFieldType.BOOLEAN).description("존재여부")
    );

    public static final Snippet SnsReviewCommentResponseField = responseFields(
        fieldWithPath("[].commentId").type(JsonFieldType.NUMBER).description("댓글아이디"),
        fieldWithPath("[].userInfo.nickname").type(JsonFieldType.STRING).description("유저닉네임"),
        fieldWithPath("[].userInfo.accountId").type(JsonFieldType.STRING).description("유저 계정"),
        fieldWithPath("[].userInfo.introduceText").type(JsonFieldType.STRING).description("유저 한줄소개").optional(),
        fieldWithPath("[].userInfo.profileImage").type(JsonFieldType.STRING).description("프로필이미지 파일이름").optional(),
        fieldWithPath("[].content").type(JsonFieldType.STRING).description("댓글내용"),
        fieldWithPath("[].parentCommentId").type(JsonFieldType.NUMBER).description("부모댓글아이디")
    );
}