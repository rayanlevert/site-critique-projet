package fr.dawan.sitecritiqueprojet.beans;

public class Password {
    private String rawPassword;
    private String encodedPassword;

    public Password(){}

    public Password(String rawPassword, String encodedPassword) {
        this.rawPassword = rawPassword;
        this.encodedPassword = encodedPassword;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }
    public String getRawPassword() {
        return rawPassword;
    }
    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }
}
