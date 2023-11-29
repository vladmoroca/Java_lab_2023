package Java_lab_2023.lab_5;
import java.util.ArrayList;

public class Sentence {
    private ArrayList<Object> elements = new ArrayList<>();

    public Sentence(String sentence){
        String[] elements = sentence.split(" ");
        for (String element : elements) {
            this.elements.add(new Word(element.replaceAll("[\\p{P}\n]+", "")));
            this.elements.add(new Mark(element.replaceAll("[\\p{L}]+", "")));
        }
    }

    public String getSentence(){
        String result = "";
        for (Object element : elements) {
            if(element instanceof Word) result = result.concat(" ");
            result = result.concat(element.toString());
        }
        return result;
    }

    public ArrayList<Object> getElements(){
        return this.elements;
    }
}
