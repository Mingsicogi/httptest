package mins.study;

import org.apache.commons.io.IOUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LevenshteinAlgorithm {
    public static void main(String[] args) throws IOException {
        int threshold = 100_000;
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

        String command = "curl -X GET ";
        String testUrl1 = "https://namu.wiki/w/%EC%84%9C%EC%A7%80%ED%98%9C(%EB%B0%B0%EC%9A%B0)";
        String testUrl2 = "https://ko.wikipedia.org/wiki/%EC%84%9C%EC%A7%80%ED%98%9C";

        ProcessBuilder processBuilder = new ProcessBuilder((command + testUrl1).split(" "));
        InputStream inputStream = processBuilder.start().getInputStream();
        String text1 = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        System.out.println(text1);

        processBuilder = new ProcessBuilder((command + testUrl2).split(" "));
        inputStream = processBuilder.start().getInputStream();
        String text2 = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        System.out.println(text2);

        long start = System.currentTimeMillis();
        Integer apply = levenshteinDistance.apply(text1, text2);
        long end = System.currentTimeMillis();


        System.out.println("text1 string size : " + text1.length() + ", text2 string size : " + text2.length());
        System.out.println("distance Calculation time : " + ((end - start)/1000.0));
        System.out.println("distance : " + apply);
    }
}
