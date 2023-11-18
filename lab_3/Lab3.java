package Java_lab_2023.lab_3;

public class Lab3 {
    /* 
    variant 1121
    C3 = 2
    String
    С17  = 16
    В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.
    */

    public static void main(String[] args) throws Exception {
        String new_text = parse("Some text with Letters hhhhhhhth");
        System.out.println(new_text);

    }

    public static String parse(String Text) {
        String[] words = Text.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = last_letter_delete(words[i]);
        }
        String text = String.join(" ", words);
        return text;
    }

    public static String last_letter_delete(String word) {
        String lastLetter = word.substring(word.length() - 1);
        word = word.replaceAll(lastLetter, "");
        word += lastLetter;
        return word;
    }
}
