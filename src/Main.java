//AULA 10 - Operações com matriz

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // objeto necessario pra poder ler do teclado

        System.out.print("Digite o número de linhas da matriz: "); //cout
        int linhas = scanner.nextInt(); //cin

        System.out.print("Digita o número de colunas da matriz: ");
        int colunas = scanner.nextInt();

        int[][] matriz = new int[linhas][colunas];

        //ler matriz
        for (int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                System.out.print("Elemento[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        //printar matriz
        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
            //System.out.println();
        }
        //desafio: ler 2 matrizes, somar, subtrair, multiplicar e transposta de cada uma
    }
}