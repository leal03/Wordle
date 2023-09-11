import java.io.*;
import java.util.*;

public class Wordle {
    public static void main(String[] args) throws IOException {
        // ----DECLARAÇÃO DE VARIAVEIS----
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        char[] PalavraRandon = new char[5];
        char[] Tent = new char[5];
        String tentativa, palavra;
        boolean checar;
        int cont = 0;
        int palavraPos = rd.nextInt(2325);
        Dicionario dic = new Dicionario(2326, "palavrasJogo.txt");
        palavra = dic.sortearPalavra(palavraPos);
        PalavraRandon = palavra.toCharArray();
        // ----PROCESSAMENTO---
        do {
            System.out.println("\033[0;39m" + "\nDigite sua tentativa: ");
            tentativa = sc.nextLine();
            checar = dic.checarPalavra(tentativa);
            if (checar == true) {
                Tent = tentativa.toCharArray();
                if (Tent[0] == PalavraRandon[0] && Tent[1] == PalavraRandon[1] && Tent[2] == PalavraRandon[2]
                        && Tent[3] == PalavraRandon[3] && Tent[4] == PalavraRandon[4]) {
                    cont += 6;
                    System.out.println("Parabéns você acertou!");
                }
    
                else if (true) {
                    for (int j = 0; j < 5; j++) {
                        if (Tent[j] == PalavraRandon[j]) {
                            System.out.print("\033[1;92m " + Tent[j] + "\033[0;39m");
                        } else if (Tent[j] == PalavraRandon[0] || Tent[j] == PalavraRandon[1]
                                || Tent[j] == PalavraRandon[2] || Tent[j] == PalavraRandon[3]
                                || Tent[j] == PalavraRandon[4]) {
                            System.out.print("\033[1;93m "+ Tent[j] + "\033[0;39m");
                        } else {
                            System.out.print("\033[1;90m " + Tent[j] + "\033[0;39m");
                        }
                    }
                }
                cont++;
            } else
                System.out.println("Palavra inválida.");
        } while (cont < 6);
        if (cont >= 6) {
            System.out.println(" ");
            System.out.println("Você perdeu o jogo. A palavra correta era: " + palavra);
        }
    }
}
