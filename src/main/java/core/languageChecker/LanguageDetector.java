package core.languageChecker;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LanguageDetector {

    private static final String PATH_FOLDER = "D:\\Projekty Java\\Programming2\\src\\main\\java\\core\\languageChecker\\input";

    public static void main(String[] args) throws APIError, IOException {
        List<String> filePaths = readAllStringFiles(PATH_FOLDER);

        for (String filePath : filePaths) {
            String fileLines = readTextFromFile(filePath);
            String language = detect(fileLines);
            System.out.println("Rozpoznany język: " + language);
        }
    }

    //przekazujemy listą ścieżki do pliku
    private static List<String> readAllStringFiles(String path) {
        File folder = new File(path);
        File[] filesList = folder.listFiles();
        List<String> textList = new ArrayList<>();

        for (File file : filesList) {
            if (file.isFile()) {
                textList.add(file.getAbsolutePath());
            }
        }

        return textList;
    }

    //odczytujemy przekazany plik
    private static String readTextFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    //sprawdzamy język
    private static String detect(String words) throws APIError {
        DetectLanguage.apiKey = "4f8cc8f4e86081b0636fcd5336f8ed1c";
        DetectLanguage.ssl = true;
        List<Result> results = DetectLanguage.detect(words);

        return results.get(0).language;
    }
}
