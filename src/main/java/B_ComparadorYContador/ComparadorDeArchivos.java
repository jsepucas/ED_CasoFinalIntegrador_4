package B_ComparadorYContador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class ComparadorDeArchivos {

    public boolean comparar(File file1, File file2) throws IOException {
        byte[] file1Content = Files.readAllBytes(file1.toPath());
        byte[] file2Content = Files.readAllBytes(file2.toPath());

        return Arrays.equals(file1Content, file2Content);
    }
}