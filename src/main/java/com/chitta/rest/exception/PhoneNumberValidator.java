package com.chitta.rest.exception;

import java.util.List;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<IValidPhoneNumbers, List<String>> {

    private static final String PHONE_NUMBER_REGEX = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

    @Override
    public boolean isValid(List<String> phoneNumbers, ConstraintValidatorContext context) {
        if (phoneNumbers == null || phoneNumbers.isEmpty()) {
            return true;
        }
        return phoneNumbers.stream()
                .allMatch(phoneNumber -> Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber));
    }
}
