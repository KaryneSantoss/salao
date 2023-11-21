package models;

public class Funcionario extends Pessoa {
    private float salario;

    public Funcionario() {
    }

    public Funcionario(float salario, int id, String nome, String email, String telefone, String rg, String cpf) {
        super(id, nome, email, telefone, rg, cpf);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
}
