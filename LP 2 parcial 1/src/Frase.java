import java.util.List;

public class Frase {
    private String texto;
    private List<Traduccion> traducciones;

    // Getters y Setters
    public String gettexto() {
        return texto;
    }

    public void settexto(String texto) {
        this.texto = texto;
    }

    public List<Traduccion> gettraducciones() {
        return traducciones;
    }

    public void settraducciones(List<Traduccion> traducciones) {
        this.traducciones = traducciones;
    }
}


