package com.github.isaacscardoso.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

    @Override
    public void initialize(ContactNumberConstraint contactNumber) { }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("\\(?0?([1-9]{2})[ \\-\\.\\)]{0,2}(9[ \\-\\.]?\\d{4})[ \\-\\.]?(\\d{4})");
    }

}