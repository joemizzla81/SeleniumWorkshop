package iterables;

import java.util.Iterator;

public class IterableString implements Iterable<Character> {

    private final String text;

    public IterableString(String text){
        this.text = text;
    }

    @Override
    public Iterator<Character> iterator() {
        return new StringIterator(text);
    }

    private static class StringIterator implements Iterator<Character>{

        private final String str;
        private int index;

        public StringIterator(String str) {
            this.str = str;
            this.index = 0;
        }


        @Override
        public boolean hasNext() {
            return this.index < this.str.length();
        }

        @Override
        public Character next() {
            return this.str.charAt(this.index++);
        }
    }

    public static void main(String[] args) {
        IterableString is = new IterableString("ich heiße Tom Jones");
        for(char c: is){
            System.out.println("Char: " + c);
        }

        Iterator<Character> iterator = is.iterator();
        for (; iterator.hasNext();){
            System.out.println("Char1: " + iterator.next());
        }
    }
}
