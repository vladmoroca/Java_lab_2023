package Java_lab_2023.lab_5;
import java.util.ArrayList;

public class Sentence {
    private final ArrayList<Object> elements = new ArrayList<>();

    public Sentence(String sentence){
        String[] elements = sentence.split(" ");
        for (int i = 0; i < elements.length; i++) {
            this.elements.add(new Word(elements[i].replaceAll("[\\p{P}]+", "")));
            this.elements.add(new Mark(elements[i].replaceAll("[\\p{L}]+", "")));
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
