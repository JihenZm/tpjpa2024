package domain;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Concert extends Evenement {

    @ManyToMany
    @JoinTable(
            name = "concert_artiste",
            joinColumns = @JoinColumn(name = "concert_id"),
            inverseJoinColumns = @JoinColumn(name = "artiste_id")
    )
    private List<Artiste> artistes;

    // Getters et Setters
    public List<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes = artistes;
    }
}
