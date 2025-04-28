package dao;


public class LoginResponse {
    private String nom;
    private String prenom;
    private String email;
    private String role;

    public LoginResponse() {}

    public LoginResponse(String nom, String prenom, String email, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
    }

    // getters and setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

