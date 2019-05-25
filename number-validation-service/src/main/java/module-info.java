module com.jtk.validate.number {
    requires com.jtk.service;
    provides com.jtk.service.api.ValidationService with com.jtk.validate.number.DoubleValidation;
}