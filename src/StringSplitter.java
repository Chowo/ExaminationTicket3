import java.util.LinkedList;
import java.util.List;

public class StringSplitter {


    public static List<String> stringSplitter(String string) {
        int lengthOfString = 5;
        List<String> stringList = new LinkedList<>();
        if (string == null) {
            throw new IllegalArgumentException("String is null");
        }
        if (string.length() < lengthOfString) {
            stringList.add(string);
            return stringList;
        }
        int numberOfIterations;
        int restOfDivide = string.length() % lengthOfString;
        if (restOfDivide == 0) {
            numberOfIterations = string.length() / lengthOfString;
            restOfDivide = lengthOfString;
        } else {
            numberOfIterations = string.length() / lengthOfString + 1;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < numberOfIterations; i++) {
            if (i == numberOfIterations - 1) {
                stringList.add(stringBuilder.substring(i * (lengthOfString), i * (lengthOfString) + restOfDivide));
            } else {
                stringList.add(stringBuilder.substring(i * (lengthOfString), (i + 1) * lengthOfString));
            }
        }
        return stringList;

    }

    public static void main(String[] args) {
        String testString1 = "12345678901265498796546";
        List<String> test = StringSplitter.stringSplitter(testString1);
        for (String string : test) {
            System.out.println(string);
        }
    }
}
