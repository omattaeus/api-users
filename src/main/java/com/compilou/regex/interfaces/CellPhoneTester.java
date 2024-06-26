package com.compilou.regex.interfaces;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CellPhoneTester implements ConstraintValidator<CellPhoneValidator, String> {

    private static final String verifyCellphone = "(\\(([0-9]{2})\\)\\s([0-9]{5})\\-[0-9]{4}+)";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Pattern cellphoneRegex = Pattern.compile(verifyCellphone);
        Matcher compare = cellphoneRegex.matcher(s);

        return compare.find();
    }
}