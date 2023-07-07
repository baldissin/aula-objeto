import java.util.Scanner;

public class OperacoesComMatriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //objeto responsavel por fazer leitura do teclado

        System.out.print("Digite o número de linhas das matrizes: ");
        int linhas = scanner.nextInt(); //leitura do que for escrito no teclado

        System.out.print("Digite o número de colunas das matrizes: ");
        int colunas = scanner.nextInt();

        int[][] matrizA = lerMatriz(scanner, linhas, colunas); //chama a função lerMatriz (segurar CTRL e clicar no método para ir até o codigo)
        int[][] matrizB = lerMatriz(scanner, linhas, colunas);

        System.out.println("Matriz A: ");
        imprimirMatriz(matrizA);

        System.out.println("Matriz B: ");
        imprimirMatriz(matrizB);

        int[][] matrizSoma = somarMatrizes(matrizA, matrizB);  
        int[][] matrizSubtracao = subtrairMatrizes(matrizA, matrizB);  
        int[][] matrizMultiplicacao = multiplicarMatrizes(matrizA, matrizB);  
        int[][] matrizTranspostaA = calcularTransposta(matrizA);
        int[][] matrizTranspostaB = calcularTransposta(matrizB);

        System.out.println("Matriz Soma: ");
        imprimirMatriz(matrizSoma);

        System.out.println("Matriz Subtração: ");
        imprimirMatriz(matrizSubtracao);  

        System.out.println("Matriz Multiplicação: ");
        imprimirMatriz(matrizMultiplicacao);  

        System.out.println("Matriz Transposta A: ");
        imprimirMatriz(matrizTranspostaA);  

        System.out.println("Matriz Transposta B: ");
        imprimirMatriz(matrizTranspostaB);  

        scanner.close(); //essse método garante que nao sera lido mais nada no teclado. é opcioal usa-lo
    }

    private static int[][] lerMatriz(Scanner scanner, int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];

        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    private static int[][] somarMatrizes(int[][] matrizA, int[][] matrizB) {
        int linhas = matrizA.length;
        int colunas = matrizA[0].length;

        int[][] matrizSoma = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizSoma[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return matrizSoma;
    }

    private static int[][] subtrairMatrizes(int[][] matrizA, int[][] matrizB) {
        int linhas = matrizA.length;
        int colunas = matrizA[0].length;

        int[][] matrizSubtracao = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizSubtracao[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }

        return matrizSubtracao;
    }

    private static int[][] multiplicarMatrizes(int[][] matrizA, int[][] matrizB) {
        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;
        int linhasB = matrizB.length;
        int colunasB = matrizB[0].length;

        if (colunasA != linhasB) {  //regra matematica de matriz
            System.out.println("As matrizes não podem ser multiplicadas. O número de colunas da matriz A deve ser igual ao número de linhas da matriz B.");
            return null;
        }

        int[][] matrizResultante = new int[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    matrizResultante[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return matrizResultante;
    }

    private static int[][] calcularTransposta(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int[][] matrizTransposta = new int[colunas][linhas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizTransposta[j][i] = matriz[i][j];
            }
        }

        return matrizTransposta;
    }

    private static void imprimirMatriz(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t"); // o \t é para inserir um espaçamento, algo semelhante com apertar a tecla TAB em arquivo do WORD, por exemplo
            }
            System.out.println(); //pular linha quando for printar outra linha
        }
    }
}