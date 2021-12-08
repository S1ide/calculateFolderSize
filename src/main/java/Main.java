import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for(;;){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь до папки:");
            String path = scanner.nextLine();
            double size = (double) FileUtils.calculateFolderSize(path);
            int count = 0;
            while (size > 1024){
                size /= 1024.0;
                count++;
            }
            System.out.printf("Размер папки %s составляет %.2f ", path, size);
            if (count == 0) System.out.print("Б\n");
            if (count == 1) System.out.print("КБ\n");
            if (count == 2) System.out.print("МБ\n");
            if (count == 3) System.out.print("ГБ\n");
        }
    }
}
