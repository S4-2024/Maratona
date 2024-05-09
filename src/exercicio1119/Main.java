package exercicio1119;

import java.util.Scanner;

class Node {
    int id;
    Node prev;
    Node next;

    public Node(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, k, m;
        Node lista, K, M, auxK, auxM;

        while ((n = sc.nextInt()) != 0) {
            k = sc.nextInt();
            m = sc.nextInt();

            lista = preencher(n);
            K = lista;
            M = lista.prev;

            while (contar(lista) > 2) {
                K = percorrer(K, k, 0);
                M = percorrer(M, m, 1);

                if (K.next == M)
                    auxK = M.next;
                else
                    auxK = K.next;

                if (M.prev == K)
                    auxM = K.prev;
                else
                    auxM = M.prev;

                if (K == M) {
                    System.out.printf("%3d,", M.id);
                    lista = deletar(lista, K);
                } else {
                    System.out.printf("%3d%3d,", K.id, M.id);
                    lista = deletar(lista, M);
                    lista = deletar(lista, K);
                }

                K = auxK;
                M = auxM;
            }

            if (contar(lista) == 2) {
                K = percorrer(K, k, 0);
                M = percorrer(M, m, 1);

                if (K == M)
                    System.out.printf("%3d,%3d\n", K.id, K.next.id);
                else
                    System.out.printf("%3d%3d\n", K.id, K.next.id);
            } else
                System.out.printf("%3d\n", lista.id);
        }
        sc.close();
    }

    static Node preencher(int tamanho) {
        Node node = null;
        Node inicio = null;
        Node nodeAnterior = null;

        for (int i = 1; i <= tamanho; ++i) {
            node = new Node(i);

            if (inicio == null)
                inicio = node;
            else {
                nodeAnterior.next = node;
                node.prev = nodeAnterior;
            }

            nodeAnterior = node;
        }

        inicio.prev = nodeAnterior;
        nodeAnterior.next = inicio;

        return inicio;
    }

    static Node deletar(Node lista, Node reg) {
        Node nodeAnterior = reg.prev;
        Node nodeProximo = reg.next;

        if (reg == lista) {
            lista = lista.next;
            nodeAnterior.next = lista;
            lista.prev = reg.prev;
        } else {
            nodeAnterior.next = nodeProximo;
            nodeProximo.prev = nodeAnterior;
        }

        return lista;
    }

    static int contar(Node lista) {
        int i = 1;
        Node node = lista;
        while (lista != node.next) {
            node = node.next;
            i++;
        }
        return i;
    }

    static Node percorrer(Node lista, int n, int direcao) {
        Node node = lista;
        if (direcao == 0)
            while (--n > 0)
                node = node.next;
        else
            while (--n > 0)
                node = node.prev;

        return node;
    }
}