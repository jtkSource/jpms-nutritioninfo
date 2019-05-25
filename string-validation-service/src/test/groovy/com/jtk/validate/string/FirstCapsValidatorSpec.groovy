package com.jtk.validate.string

import spock.lang.Specification

class FirstCapsValidatorSpec extends Specification {
    def "Hello should return true when testing for string with first caps character"(){
        given:
        String word = "Hello"
        when:
        FirstCapsValidator validator = new FirstCapsValidator();
        boolean value = validator.validate(word)
        then:
        value == Boolean.TRUE;
    }

    def "hello should return true when testing for string with first caps character"(){
        given:
        String word = "hello"
        when:
        FirstCapsValidator validator = new FirstCapsValidator();
        boolean value = validator.validate(word)
        then:
        value == Boolean.FALSE;
    }

}
