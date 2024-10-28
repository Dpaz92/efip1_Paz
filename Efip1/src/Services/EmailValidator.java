package Services;

import Models.Exceptions.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void validate(String emailStr) throws InvalidEmailException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.matches()) {
            throw new InvalidEmailException();
        };
    }
}
