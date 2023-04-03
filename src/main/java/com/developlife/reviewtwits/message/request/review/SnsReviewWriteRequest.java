package com.developlife.reviewtwits.message.request.review;

import com.developlife.reviewtwits.message.annotation.file.ImageFiles;
import com.developlife.reviewtwits.message.annotation.review.MultipartInteger;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author WhalesBob
 * @since 2023-03-31
 */
public record SnsReviewWriteRequest(
        @NotBlank(message = "리뷰내용이 입력되지 않았습니다")
        @Size(message = "리뷰내용은 10자 이상이어야 합니다.",min = 10)
        String content,
        @NotBlank(message = "별점이 입력되지 않았습니다.")
        @MultipartInteger
        String score,
        @NotBlank(message = "product URL 은 필수 값입니다.")
        @Pattern(message = "http 혹은 https 로 시작하는 인터넷 페이지 URL 형식이 아닙니다.",
            regexp = "^(https?://)[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+/[a-zA-Z0-9-_/.?=]*")
        String productURL,
        @NotBlank(message = "제품 이름이 입력되지 않았습니다.")
        String productName,
        @NotNull(message = "SNS 리뷰에서 이미지 파일은 필수입니다.")
        @ImageFiles
        List<MultipartFile> multipartImageFiles
) {

    @Builder
    public SnsReviewWriteRequest{

    }
}