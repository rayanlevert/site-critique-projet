package fr.dawan.sitecritiqueprojet.exceptions;

public class UsernameExistsException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UsernameExistsException(String message) {
        super("Il y a déjà un utilisateur avec ce pseudonyme");
    }
}
