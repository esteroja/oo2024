public class Calculation {

    String word;
    int number;
    String operator;

    public Calculation(String word, int number, String operator) {
        this.word = word;
        this.number = number;
        this.operator = operator;
    }

    public String newWord(char addedLetter) {
        return word + addedLetter;
    }

    public int calc(int operatorNumber) {
        int result = 0;
        if (operator.equals("+")) {
            result = number + operatorNumber;
        } else if (operator.equals("-")) {
            result = number - operatorNumber;
        }
        return result;
    }
}
