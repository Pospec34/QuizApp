package org.example.validators;

public class InputValidator {
    public boolean isInputValid(String input){

        return input.matches("^[0-9]*$");
    }
}
