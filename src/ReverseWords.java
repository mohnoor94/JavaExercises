public class ReverseWords {

    public static void main(String[] args) {
        String sentence = "Hello my                 world!";

        System.out.println(reverseWords(sentence));
    }

    private static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder reversedWords = new StringBuilder();
        for (String word : words) {
            int wordSize = word.length();
            for (int i = 0; i < wordSize; i++)
                reversedWords.append(word.charAt(wordSize - 1 - i));
            reversedWords.append(" ");
        }
        return reversedWords.toString();
    }
}