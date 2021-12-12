package br.com.pni.model.upload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder 
public class RhTodos {
    
//    private BigDecimal cpf;
    private String cpf;
    private String nome;
    private String sexo;
    private String formacao;
    private String escolaridade;
    private String vinculo;
    private String cargo;
    private String departamento;
    private String unidade;
    private String atuacao;
//    private String contratoFaixaSalarial;
    private String instituicao;      

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }

//    public String getContratoFaixaSalarial() {
//        return contratoFaixaSalarial;
//    }
//
//    public void setContratoFaixaSalarial(String contratoFaixaSalarial) {
//        this.contratoFaixaSalarial = contratoFaixaSalarial;
//    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }



    
    
}
