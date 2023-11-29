package Java_lab_2023.lab_5;
import java.util.Iterator;
import java.util.ArrayList;

public class lab5 {
    /* 
    В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.
    */

    public static void main(String[] args) throws Exception {
        Text new_text = new Text("Some text with, Letters hhhhhhhth.!");
        last_letter_delete(new_text);
        System.out.println(new_text.getText());
    }

    public static void last_letter_delete(Text text) {
        ArrayList<Sentence> sentences = text.getSentences();
        for( Sentence sentence : sentences){
            ArrayList<Object> elements = sentence.getElements();
            for( Object element : elements){
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
