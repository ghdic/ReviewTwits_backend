package com.developlife.reviewtwits.message.annotation.review;

import com.developlife.reviewtwits.message.validator.review.ShoppingMallReviewSortValidator;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ShoppingMallReviewSortValidator.class)
public @interface ShoppingMallReviewSort {
    String message() default "리뷰 오름/내림차순 기준 요청은 NEWEST, BEST 중 하나로 입력해야 합니다";
    Class[] groups() default {};
    Class[] payload() default {};
}
