package lt.codeacademy.blog.validator;

import lt.codeacademy.blog.validator.annotation.CompareFields;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class CompareFieldsValidator implements ConstraintValidator<CompareFields, Object> {
    private String firstFieldName;
    private String secondFieldName;
    @Override
    public void initialize(CompareFields constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object first = getFieldValue(o, firstFieldName);
        Object second = getFieldValue(o, secondFieldName);
        return first != null && first.equals(second);
    }

    private Object getFieldValue(Object o, String fieldName){
        try{
            Class<?> objectClass = o.getClass();
            Field field = objectClass.getDeclaredField(fieldName);
            field.setAccessible(true);

            return field.get(o);
        } catch (Exception e){
            //TODO log info
        }
        return null;
    }
}
