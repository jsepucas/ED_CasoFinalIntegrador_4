package C_BusquedaYGestion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class BuscadorDePalabras {

    public long buscarPalabra(File file, String palabra) throws IOException {
        String content = new String(Files.readAllBytes(file.toPath()));
        return Arrays.stream(content.split("\\s+"))
                .filter(palabra::equalsIgnoreCase)
                .count();
    }
}