import Controlador.Singleton;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int arr[] = new int[10];
        Singleton.llenar(arr);
    }
}
