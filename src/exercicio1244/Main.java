import java.util.Scanner;

class Word implements Comparable<Word> {
    String text;

    public Word(String text) {
        this.text = text;
    }

    public int compareTo(Word other) {
        return Integer.compare(this.text.length(), other.text.length());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        scanner.nextLine();

        while (cases-- > 0) {
            Word[] words = new Word[60];
            String input = scanner.nextLine();

            int i = 0;
            int j = 0;

            while (true) {
                StringBuilder wordBuilder = new StringBuilder();

                while (i < input.length() && input.charAt(i) != ' ') {
                    wordBuilder.append(input.charAt(i++));
                }

                words[j++] = new Word(wordBuilder.toString());

                if (i >= input.length()) break;

                i++;
            }

            sort(words, j);

            for (i = 0; i < j; i++) {
                if (i != j && i != 0) System.out.print(" ");
                System.out.print(words[i].text);
            }
            System.out.println();
        }
    }

    static void sort(Word[] words, int size) {
        int i = 1;

        while (i < size) {
            int j = i - 1;
            Word pivot = words[i];

            while (j >= 0 && words[j].text.length() < pivot.text.length()) {
                words[j + 1] = words[j];
                j--;
            }

            words[j + 1] = pivot;
            i++;
        }
    }
}
