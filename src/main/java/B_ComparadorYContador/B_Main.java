package B_ComparadorYContador;

public class B_Main {

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new  AnalizadorTextoGUI();
        }
    });
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        new ComparadorDeArchivos();
    }
    });
}
}
