package com.developlife.reviewtwits.message.validator.common;

import com.developlife.reviewtwits.message.annotation.common.HttpURL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author WhalesBob
 * @since 2023-04-23
 */
public class HttpURLValidator implements ConstraintValidator<HttpURL, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            return false;
        }
        return Pattern.matches("(http:|https:)+[^\\s]+[\\w]", value);
    }
}