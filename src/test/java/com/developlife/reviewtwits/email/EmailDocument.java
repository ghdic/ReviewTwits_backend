package com.developlife.reviewtwits.email;

import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import static com.developlife.reviewtwits.DocumentFormatGenerator.required;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

/**
 * @author ghdic
 * @since 2023/03/08
 */
public class EmailDocument {
    public static final Snippet FindIdsEmailRequestField = requestFields(
            fieldWithPath("phoneNumber").type(JsonFieldType.STRING).attributes(required()).description("아이디"),
            fieldWithPath("birthDate").type(JsonFieldType.STRING).attributes(required()).description("생일 yyyy-MM-dd")
    );
    public static final Snippet FindIdsEmailResponseField = responseFields(
            fieldWithPath("[].nickname").type(JsonFieldType.STRING).attributes(required()).description("닉네임"),
            fieldWithPath("[].accountId").type(JsonFieldType.STRING).attributes(required()).description("아이디"),
            fieldWithPath("[].createdDate").type(JsonFieldType.STRING).attributes(required()).description("계정생성일")
    );
}
