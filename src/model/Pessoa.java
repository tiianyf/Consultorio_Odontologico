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

    public Pessoa() {
        
        this.nome = "";
        this.idade = 0;
        this.telefone = "";
        this.email = "";
        this.cpf = "";
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
    
    public String getCabecalhoCSV(){        
         String info = "NOME;IDADE;TELEFONE;EMAIL;CPF\n";
         return info;
    }
    
    public String getInfoCSV(){        
        String info = this.nome + ";" + this.idade + ";" + this.telefone + ";" +
            this.email + ";" + this.cpf + ";" + "\n";
        return info;
    }
    
    public void setCSVInfo(String linhaCSV){
        String []temp = linhaCSV.split(";");
        this.nome = temp[1];
        this.idade = Integer.parseInt(temp[2]);
        this.telefone = temp[3];
        this.email = temp[4];
        this.cpf = temp[5];
    }
}
