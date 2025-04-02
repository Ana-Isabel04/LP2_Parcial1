import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class FrmAppidiomas extends JFrame {
    public FrmAppidiomas() {
        setSize(700, 300);
        setTitle("Aplicacion de idiomas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblFrase= new JLabel("Frase");
        lblFrase.setBounds(10, 10, 100, 25);
        getContentPane().add(lblFrase);

        String nombreArchivo = System.getProperty("user.dir")
         + "/src/datos/FrasesTraducidas.json";
            // Cargar JSON desde archivo
            ObjectMapper objectMapper = new ObjectMapper();
            FrasesData data = objectMapper.readValue(new File(nombreArchivo), FrasesData.class);

            // Obtener lista única de idiomas
            List<String> idiomasUnicos = data.getFrases().stream()
            .flatMap(frase -> frase.getTraducciones().stream()) // Descomponer las traducciones
            .map(Traduccion::getIdioma) // Obtener solo los idiomas
            .distinct() // Eliminar duplicados
            .sorted() // Ordenar alfabéticamente (opcional)
            .collect(Collectors.toList()); // Convertir a List
        
    }
}