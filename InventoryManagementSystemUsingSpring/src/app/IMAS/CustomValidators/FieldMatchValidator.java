package app.IMAS.CustomValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements
		ConstraintValidator<FieldMatch, Object> {

	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean toReturn = false;

		try {
			final Object firstObj = BeanUtils
					.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value,
					secondFieldName);

			toReturn = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
		// If the validation failed
		if (!toReturn) {
			context.disableDefaultConstraintViolation();
			// In the initialiaze method you get the errorMessage:
			// constraintAnnotation.message();
			context.buildConstraintViolationWithTemplate("New Password and Confirm Password must match").addNode(firstFieldName).addConstraintViolation();
		}
		return toReturn;
	}
}
