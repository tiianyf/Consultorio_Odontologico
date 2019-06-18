package model;

/**
 *
 * @author cfreitas
 */
abstract public class Pessoa {

    protected String nome;
    protected int idade;
    protected String telefone;
    protected String email;
    protected String cpf;
    protected char sexo;

    public Pessoa() {

        this.nome = "";
        this.idade = -1;
        this.telefone = "";
        this.email = "";
        this.cpf = "";
        this.sexo = 'F';
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCabecalhoCSV() {
        String info = "NOME;IDADE;TELEFONE;EMAIL;CPF;SEXO";
        return info;
    }

    /**
     * Salvar (save) informação no arquivo CSV.
     *
     * @return uma string em linha única contendo as informações do objeto.
     */
    public String getInfoCSV() {
        String info = this.nome + ";" + this.idade + ";" + this.telefone + ";"
            + this.email + ";" + this.cpf + ";" + this.sexo;
        return info;
    }

    /**
     * Carregar (load) informação do arquivo CSV.
     *
     * @param linhaCSV
     */
    public void setInfoCSV(String linhaCSV) {
        String[] info = linhaCSV.split(";");
        this.nome = info[0];
        this.idade = Integer.parseInt(info[1]);
        this.telefone = info[2];
        this.email = info[3];
        this.cpf = info[4];
        this.sexo = info[5].charAt(0);
    }
}
