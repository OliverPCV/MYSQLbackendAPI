package cz.educanet;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class AnimalsManager {

    ArrayList<Animals> animals = new ArrayList<>();

    public ArrayList<Animals> getAnimals(){
        return animals;
    }
}
