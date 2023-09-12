package bg.distilery.validation.impl;

import bg.distilery.validation.MatchingFields;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Objects;

public class MatchingFieldsImpl implements ConstraintValidator<MatchingFields, Object> {
    private String first;
    private String second;
    private MatchingFields constraintAnnotation;

    @Override
    public void initialize(MatchingFields constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.constraintAnnotation = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        Object x = beanWrapper.getPropertyValue(first);
        Object y = beanWrapper.getPropertyValue(second);

        boolean valid = Objects.equals(x, y);

        if (!valid) {
            context.buildConstraintViolationWithTemplate(constraintAnnotation.message())
                    .addPropertyNode(second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
