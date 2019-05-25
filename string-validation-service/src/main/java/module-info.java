module com.jtk.validate.string {
    requires com.jtk.service;
    provides com.jtk.service.api.ValidationService with com.jtk.validate.string.FirstCapsValidator;
}