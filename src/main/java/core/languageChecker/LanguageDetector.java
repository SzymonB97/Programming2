package core.languageChecker;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;

public class LanguageDetector {
    public static void main(String[] args) throws APIError {
        String languageEn = detect("Hello World");
        String languagePl = detect("Witaj świecie");

        System.out.println("Rozpoznany język: " + languageEn);
        System.out.println("Rozpoznany język: " + languagePl);
    }

    private static String detect(String word) throws APIError {
        DetectLanguage.apiKey = "4f8cc8f4e86081b0636fcd5336f8ed1c";
        DetectLanguage.ssl = true;
        List<Result> results = DetectLanguage.detect(word);

        return results.get(0).language;
    }
}
