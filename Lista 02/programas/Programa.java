package programas;

import java.util.InputMismatchException;
import java.util.Scanner;
import classes.Funcionario;

public class Programa {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Guarda a quantidade de funcionários que serão cadastrados
    int qtdFuncs = 0;
    boolean leuQtdFuncs;

    do {
      try {
        System.out.print("Quantos funcionários serão digitados? ");
        qtdFuncs = sc.nextInt(); // Representa o N do enunciado
        leuQtdFuncs = true;
      } catch (InputMismatchException ex) {
        System.out.println("Por favor, digite um número inteiro.");
        leuQtdFuncs = false;
      }
      sc.nextLine(); // Retira o ENTER que não foi lido ao ler o número no nextInt()
    } while (!leuQtdFuncs);// Aqui uso a negação (!) para inverter o valor de leuQtdFuncs.
    // Se leuQtdFuncs == false, então NOT false == true
    // Se leuQtdFuncs == true, então NOT true == false
    // Como queremos que o loop aconteça ENQUANTO  ele NÃO LEU QTDFUNCS, usamos NOT false (true) na condição

    // Armazena o SOMATÓRIO dos salários
    double totalSalarios = 0;

    // Vetor (caixa de caixas) para armazenar os funcionários que serão lidos
    Funcionario[] funcionarios = new Funcionario[qtdFuncs];

    // Lendo os dados dos N (qtdFuncs) funcionários
    for (int i = 0; i < qtdFuncs; i++) {
      funcionarios[i] = new Funcionario();
     
      System.out.print("\nNome: ");
      try {
        funcionarios[i].setNome(sc.nextLine());
      } catch (RuntimeException ex) {
        System.out.println(ex.getMessage());
        System.out.println("O programa será encerrado!");

        System.exit(-1);
      }

      System.out.print("Matrícula: ");
      funcionarios[i].setMatricula(sc.nextInt());

      System.out.print("Salário: ");
      try {
        funcionarios[i].setSalario(sc.nextDouble());
      } catch(InputMismatchException ex) {
        System.out.println("Salário inválido. Atribuindo um salário mínimo ao funcionário.");
        funcionarios[i].setSalario(1100);
      }
      
      sc.nextLine(); // Retira o ENTER que não foi lido ao ler o número no nextDouble()

      totalSalarios = totalSalarios + funcionarios[i].getSalario();
    }

    // Fecha o Scanner e "libera" o teclado
    sc.close();

    // Exibir os dados de todos os funcionários lidos
    // Leitura do for: "PARA CADA Funcionario 'func' existente na coleção
    // 'funcionaros, FAÇA o que está dentro das chaves"
    System.out.println("-------------------------------\nCADASTRO DOS FUNCIONÁRIOS: ");
    for (Funcionario func : funcionarios) {
      System.out.println("\nNome: " + func.getNome());
      System.out.println("Matrícula: " + func.getMatricula());
      System.out.println("Salário: " + func.getSalario());
    }

    // Calculo a média salarial (total dividido pela quantidade)
    double mediaSalarial = totalSalarios / qtdFuncs;

    // Exibo a média e assim não há mais nada no enunciado que eu não tenha feito
    System.out.println("\nA média salarial é: R$ " + mediaSalarial);
  }
}
