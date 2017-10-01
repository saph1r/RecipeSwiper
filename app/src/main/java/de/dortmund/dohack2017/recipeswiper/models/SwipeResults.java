package de.dortmund.dohack2017.recipeswiper.models;

import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jakob on 30.09.2017.
 */

public class SwipeResults implements Serializable {
    private String id = UUID.randomUUID().toString();

    List<Rezept> rezepteJa = new ArrayList<Rezept>();
    List<Rezept> rezepteNein = new ArrayList<Rezept>();

    public SwipeResults() {
    }
    public SwipeResults(List<Rezept> rlJa, List<Rezept> rlNein)
    {
        rezepteJa = new ArrayList<Rezept>(rlJa);
        rezepteNein = new ArrayList<Rezept>(rlNein);
    }

    public List<Rezept> getJaList()
    {
        return rezepteJa;
    }
    public List<Rezept> getNeinList()
    {
        return rezepteNein;
    }

    public void add(Rezept r, boolean j)
    {
        if(j)
        {
            rezepteJa.add(r);
        }else
        {
            rezepteNein.add(r);
        }
    }

    public void emptyLists()
    {
        rezepteJa.clear();
        rezepteNein.clear();
    }
    public String getId()
    {
        return id;
    }

    public void printLists()
    {
        for(Rezept r : rezepteJa)
        {
            r.print();
        }
    }
}
