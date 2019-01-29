public class Word {
    private char[] letters;

    public Word() {

    }

    public Word(String word) {
        this.letters = word.toCharArray();
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }
}
