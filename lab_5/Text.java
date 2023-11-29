package Java_lab_2023.lab_5;

import java.util.ArrayList;

public class Text {
    private ArrayList<Sentence> sentences = new ArrayList<>();

    public Text(String text){
        for (String sentence : text.split("(?=[.!;?\n])")) {
            this.sentences.add(new Sentence(sentence));
        }
    }

    public String getText(){
        String result = "";
        for (Sentence sentence : sentences) {
            result = result.concat(sentence.getSentence());
        }
        return result;
    }

    public ArrayList<Sentence> getSentences(){
        return this.sentences;
    }
}
