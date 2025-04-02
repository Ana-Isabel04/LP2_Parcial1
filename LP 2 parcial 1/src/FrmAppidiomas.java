
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FrmAppidiomas extends JFrame {
    public FrmAppidiomas() {
        setSize(700, 300);
        setTitle("Aplicacion de idiomas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblFrase = new JLabel("Frase");
        lblFrase.setBounds(10, 10, 100, 25);
        getContentPane().add(lblFrase);

        String nombreArchivo = System.getProperty("user.dir")
                + "/src/datos/FrasesTraducidas.json";
        // Cargar JSON desde archivo
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            FrasesData data = objectMapper.readValue(new File(nombreArchivo), FrasesData.class);
            System.out.println(data);
            // Obtener lista única de idiomas
            List<String> idiomasUnicos = data.getFrases().stream()
                    .flatMap(frase -> frase.gettraducciones().stream()) // Descomponer las traducciones
                    .map(Traduccion::getidioma) // Obtener solo los idiomas
                    .distinct() // Eliminar duplicados
                    .sorted() // Ordenar alfabéticamente (opcional)
                    .collect(Collectors.toList());// Convertir a List
            System.out.println(idiomasUnicos);

            List<String> textosUnicos = data.getFrases().stream()
                    .map(Frase::getTexto) // Extraer los textos
                    .distinct() // Eliminar duplicados
                    .sorted() // Ordenar alfabéticamente (opcional)
                    .collect(Collectors.toList()); // Convertir a lista
            System.out.println(frasesUnicas);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los datos: " + ex);
        }
    }
}
