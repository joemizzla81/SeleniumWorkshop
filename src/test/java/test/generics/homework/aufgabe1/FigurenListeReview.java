package test.generics.homework.aufgabe1;

public class FigurenListeReview<A> {

    private A[] speicher;
    private int nextIndex;

    public FigurenListeReview(){

        this.speicher = (A[]) new Object[10];
        this.nextIndex = 0;

    }

    public void figurAnfuegen(A newFigur){

        if(this.nextIndex >= this.speicher.length){
            A[] newSpeicher = (A[]) new Object[this.speicher.length + 100];
            for (int i = 0; i < this.speicher.length; i++) {
                newSpeicher[i] = this.speicher[i];

            }
            this.speicher = newSpeicher;
        }
        this.speicher[nextIndex] = newFigur;
        this.nextIndex += 1;

    }

    public A letzteFigurAuslesen(){
        if (this.nextIndex > 0) {
            return this.speicher[this.nextIndex - 1];
        }
        return null;
    }

    public void alleAnzeigen(){
        for (A a: this.speicher){
            System.out.println(a);
        }
    }

    public boolean isEmpty(){
        return (this.nextIndex == 0);
    }

    public static void main(String[] args) {
        FigurenListeReview<Integer> ll = new FigurenListeReview<>();
        ll.figurAnfuegen(1);
        ll.figurAnfuegen(11);
        ll.figurAnfuegen(111);
        ll.figurAnfuegen(1111);
        ll.alleAnzeigen();
        System.out.println(ll.isEmpty());
    }
}
