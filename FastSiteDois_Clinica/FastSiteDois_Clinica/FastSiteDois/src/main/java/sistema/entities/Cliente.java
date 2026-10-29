package sistema.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100, name = "login")
    private String login;
    @Column(nullable = false, length = 100, name = "senha")
    private String senha;
    @Column(nullable = false, length = 100, name = "nome")
    private String nome;
    @Column(nullable = false, length = 100, name = "endereco")
    private String endereco;
    @Column(nullable = false, length = 8, name = "cep")
    private Integer cep;
    @Column(nullable = false, length = 10, name = "numero")
    private Integer numero;
    @Column(nullable = false, length = 11, name = "telefone")
    private Long telefone;
    @Column(nullable = false, length = 200, name = "observacao")
    private String observacao;

    public Cliente(){

    }


    public Cliente(String nome, String endereco, Integer cep, Integer numero, Long telefone, String observacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.numero = numero;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString() {
        return "Login:" + getLogin() + " Senha: " + getSenha() + "Nome: " + getNome() + " Enderço: " + getEndereco() + " CEP: " + getCep() + " Número da Residência: " + getNumero() + " Número de Telefone: " + getTelefone() + " Observação: " + getObservacao();
    }
}
