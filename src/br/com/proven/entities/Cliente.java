package br.com.proven.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{

    private Double limite;

    private List<Venda> vendasParticipadas = new ArrayList<>();

    public Cliente(String nome, String sobrenome, String cpf, Double limite) {
        super(nome, sobrenome, cpf);
        this.limite = limite;
    }

    public Double getLimite() {
        return this.limite;
    }

    public List<Venda> getVendasParticipadas() {
        return this.vendasParticipadas;
    }

    public void adicionarVenda(Venda venda) {
        this.vendasParticipadas.add(venda);
    }

    public void removerVenda(Venda venda) {
        this.vendasParticipadas.remove(venda);
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String mostrarDados() {
        return super.mostrarDadosPessoa() + " | " + getLimite();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Super=" + super.toString() +
                "limite=" + limite + '}';
    }
}
