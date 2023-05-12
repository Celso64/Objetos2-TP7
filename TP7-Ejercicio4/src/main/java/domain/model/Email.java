package domain.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private String email;

    public Email(String email) {

	Matcher matcher = pattern.matcher(email);

	if (!matcher.matches())
	    throw new RuntimeException("Email Invalido");

	this.email = email;
    }

    @Override
    public String toString() {
	return email;
    }

}
