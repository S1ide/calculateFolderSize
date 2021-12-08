import java.io.File;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    private static List<File> files;

    public static long calculateFolderSize(String path) {
        if(!path.matches("([a-zA-Z]:)?((\\\\(\\w ?)+)+)?")) throw new IllegalArgumentException("Неверный формат пути");
        File folder = new File(path);
        files = new ArrayList<>();
        getFiles(folder);
        return files.stream().mapToLong(File::length).sum();
    }

    public static void getFiles (File folder){
        if (!folder.isDirectory()) files.add(folder);
        else {
            try {
                Arrays.stream(folder.listFiles()).forEach(FileUtils::getFiles);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
