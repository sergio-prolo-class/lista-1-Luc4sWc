import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite 1 para iniciar o jogo: ");
        int play = teclado.nextInt();

        if (play == 1) {
            String[][] mar = new String[10][10];
            // Tipos de navios
            String[] objetos = {"P", "E", "C", "S", "N"};

            // Inicializa o mar com ". "
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    mar[i][j] = ". ";
                }
            }

            Random h = new Random();
            int cont = 0; // Número de navios colocados
            String[] log = new String[5]; // Navios já colocados
            int o = 0; // Índice do log

            while (cont < 5) {
                int x = h.nextInt(objetos.length); // Sorteia um tipo de navio
                String navio = objetos[x];

                // Verifica se o navio já foi colocado
                boolean repetido = false;
                for (int i = 0; i < o; i++) {
                    if (log[i].equals(navio)) {
                        repetido = true;
                        break;
                    }
                }
                if (repetido) {
                    continue; // Sorteia outro navio se já foi colocado
                }

                log[o] = navio; // Armazena o navio
                o++;

                int quantidade;
                switch (navio) {
                    case "P": quantidade = 5; break;
                    case "E": quantidade = 4; break;
                    case "C":
                    case "S": quantidade = 3; break;
                    case "N": quantidade = 2; break;
                    default: quantidade = 0;
                }

                boolean vertical = h.nextBoolean();
                int linha, coluna;
                boolean podeColocar = true;

                if (vertical) {
                    linha = h.nextInt(10 - quantidade + 1);// sortei um numero garantindo que se caso vir um mesmo número aleatório ele não cair na mesma linha tomara que dê certo
                    coluna = h.nextInt(10);// autoexplicativo
                    for (int k = 0; k < quantidade; k++) {
                        if (!mar[linha + k][coluna].equals(". ")) {
                            podeColocar = false; //não coloca
                            break;
                        }
                    }
                    if (podeColocar) {
                        for (int k = 0; k < quantidade; k++) {
                            mar[linha + k][coluna] = navio + " "; //coloca, eu vi que dava pra somar espaço na string aqui em java achei legal e usei
                        }
                        cont++;
                    }
                } else { // horizontal
                    linha = h.nextInt(10);
                    coluna = h.nextInt(10 - quantidade + 1); // evita de se caso cair num mesmo número aleatório ele.... se já entendeu
                    for (int k = 0; k < quantidade; k++) {
                        if (!mar[linha][coluna + k].equals(". ")) {
                            podeColocar = false;
                            break;
                        }
                    }
                    if (podeColocar) {
                        for (int k = 0; k < quantidade; k++) {
                            mar[linha][coluna + k] = navio + " ";
                        }
                        cont++;
                    }
                }
            }

            // Printa na tela
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(mar[i][j]);
                }
                System.out.println();
            }
        }
        return;// tive problemas com a leitura de string ele simplesmente não queria ler de jeito nenhum ai troquei para colocar 1 pra iniciar o jogo em vez de "play", se caso a pessoa não colocar o número 1 ele encerra o programa
    }
}
