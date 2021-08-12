package classes;

public class Funcionario {
  private int matricula;
  private String nome;
  private double salario;

  public int getMatricula() {
    return matricula;
  }

  public void setMatricula(int novaMatricula) {
    matricula = novaMatricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String novoNome) {
    if (novoNome.matches("(.*)\\d(.*)")) {
      // Não posso ter nomes com caracteres numéricos, então, se assim for o caso, LANÇO UMA EXCEÇÃO!!
      throw new RuntimeException("Nome não pode ter caracteres numéricos.");
    }
    nome = novoNome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double novoSalario) {
    salario = novoSalario;
  }
}