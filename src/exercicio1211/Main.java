package exercicio1211;
import java.util.Arrays;
import java.util.Scanner;

class CadeiaString implements Comparable<CadeiaString> {
    String cadeia;

    public CadeiaString(String cadeia) {
        this.cadeia = cadeia;
    }

    public int compareTo(CadeiaString outra) {
        return this.cadeia.compareTo(outra.cadeia);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int tamanho = scanner.nextInt();
            scanner.nextLine(); // consome o caractere de nova linha após o número inteiro

            CadeiaString[] cadeias = new CadeiaString[tamanho];
            for (int i = 0; i < tamanho; i++) {
                String cadeia = scanner.nextLine();
                cadeias[i] = new CadeiaString(cadeia);
            }

            Arrays.sort(cadeias);

            int resultado = 0;
            for (int i = 1; i < tamanho; i++) {
                String cadeia = cadeias[i].cadeia;
                String cadeiaAnterior = cadeias[i - 1].cadeia;
                int tamanhoMinimo = Math.min(cadeia.length(), cadeiaAnterior.length());
                for (int j = 0; j < tamanhoMinimo; j++) {
                    if (cadeia.charAt(j) == cadeiaAnterior.charAt(j)) {
                        resultado++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(resultado);
        }
    }
}
