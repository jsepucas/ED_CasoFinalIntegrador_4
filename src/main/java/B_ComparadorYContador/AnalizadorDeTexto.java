package B_ComparadorYContador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class AnalizadorDeTexto {

    public long contarPalabras(File file) throws IOException {
        String content = new String(Files.readAllBytes(file.toPath()));
        return Arrays.stream(content.split("\\s+")).count();
    }
}