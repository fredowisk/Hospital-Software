package model.bean;

import java.util.Date;



/**
 *
 * @author fredaum
 */
public class Paciente {
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private String cpf;
    private String sus;
    private String sexo;
    private String atendido;
    
    


    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the sus
     */
    public String getSus() {
        return sus;
    }

    /**
     * @param sus the sus to set
     */
    public void setSus(String sus) {
        this.sus = sus;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the atendido
     */
    public String getAtendido() {
        return atendido;
    }

    /**
     * @param atendido the atendido to set
     */
    public void setAtendido(String atendido) {
        this.atendido = atendido;
    }
    
    

}
