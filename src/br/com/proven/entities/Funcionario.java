package br.com.proven.entities;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa{

    private Double salario;

    private List<Venda> vendasFeitas = new ArrayList<>();

    public Funcionario(String nome, String sobrenome, String cpf, Double salario) {
        super(nome, sobrenome, cpf);
        this.salario = salario;
    }

    public Double getSalario() {
        return this.salario;
    }

    public List<Venda> getVendasFeitas() {
        return this.vendasFeitas;
    }

    public void aumentarSalarioPorPorcentagem(Double porcentagem) {
        this.salario += salario * porcentagem / 100;
    }

    public void adicionarVendas(Venda venda) {
        this.vendasFeitas.add(venda);
    }

    public void removerVendas(Venda venda) {
        this.vendasFeitas.remove(venda);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "Super=" + super.toString() +
                "salario=" + salario + '}';
    }
}
