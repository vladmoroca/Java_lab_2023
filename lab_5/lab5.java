package Java_lab_2023.lab_5;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class lab5 {
    /* 
    В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.
    */

    public static void main(String[] args) throws Exception {
        /* 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        */
        String text = "Some text with, Letters hhhhhhth.! i ще кирилиця ";
        Text new_text = new Text(text);
        last_letter_delete(new_text);
        System.out.println(new_text.getText());
    }

    public static void last_letter_delete(Text text) {
        for( Sentence sentence : text.getSentences()){
            for( Object element : sentence.getElements()){
                if(element instanceof Word){
                    Word word = (Word) element;
                    ArrayList<Letter> letters = word.getLetters();
                    Letter last_letter = letters.get(letters.size() - 1);
                    Iterator<Letter> iterator = letters.iterator();
                    while (iterator.hasNext()) {
                        Letter letter = iterator.next();
                        if (last_letter.getLetter().equals(letter.getLetter())) {
                            iterator.remove();
                        }
                    }
                    letters.add(last_letter);
                }
            }
        }
    }
}
