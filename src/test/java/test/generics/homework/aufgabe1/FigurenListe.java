package test.generics.homework.aufgabe1;

import java.util.LinkedList;
import java.util.ListIterator;

public class FigurenListe {

    private LinkedList figurenListe;

    public FigurenListe(){
        figurenListe = new LinkedList();
    }

    public void figurAnfuegen (Figur figur){
        figurenListe.addLast(figur);
    }

    public Figur letzteFigurAuslesen(){
        return (Figur)figurenListe.getLast();
    }

    public void alleAnzeigen(){

        ListIterator lit = figurenListe.listIterator(0);
        while (lit.hasNext()){
            Figur figur = (Figur)lit.next();
            figur.anzeigen();
        }

    }
}
