package com.riddhi.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.riddhi.spring.pojo.SupplierAddress;

public class SupplierRegValidator implements Validator {

	
	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(SupplierAddress.class);
	}

	
	@Override
	public void validate(Object obj, Errors errors) {
		SupplierAddress sa = (SupplierAddress) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier.firstName", "error.invalid.supplier", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier.lastName", "error.invalid.supplier", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier.username", "error.invalid.supplier", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplier.password", "error.invalid.password", "Password Required");
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.addressLine1", "error.invalid.address", "AddressLine1  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.addressLine2", "error.invalid.address", "AddressLine2  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.address", "City Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.address", "State Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.country", "error.invalid.address", "Country  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.postalCode", "error.invalid.address", "PostalCode  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.addressType", "error.invalid.address", "Address Type Required");
		
		 if (errors.hasErrors()) {
	            return;//Skip the rest of the validation rules
	        }	
		

		
		
	}
}
