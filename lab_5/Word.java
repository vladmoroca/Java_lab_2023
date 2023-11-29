package Java_lab_2023.lab_5;

import java.util.ArrayList;

public class Word {
    private final ArrayList<Letter> letters = new ArrayList<>();;

    public Word(String word){
        for (String symbol : word.split("")) {
            this.letters.add(new Letter(symbol));
        }
    }

    public String toString(){
        String result = "";
        for (Letter letter : this.letters) {
            result = result.concat(letter.getLetter());
        }
        return result;
    }

    public ArrayList<Letter> getLetters(){
        return this.letters;
    }
}
