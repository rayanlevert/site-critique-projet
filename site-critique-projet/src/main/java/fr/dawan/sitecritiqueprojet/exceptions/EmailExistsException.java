package fr.dawan.sitecritiqueprojet.exceptions;

public class EmailExistsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public EmailExistsException(String message) {
        super("Il y a déjà un utilisateur avec cette adresse e-mail");
    }
}
