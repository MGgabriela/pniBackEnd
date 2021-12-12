package br.com.pni.model.upload;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author gabri
 */
@Data
@Builder 
public class Fiotec {

    //Variaveis de todo contrato
    private String instituicao;   
    private String nome;
    private String modalidade;
    private Date dataInicio;
    private Date dataFim;
    private Double contratoFaixaSalarial;//valores no excel
    private String cpf;
    private String status;     

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Double getContratoFaixaSalarial() {
        return contratoFaixaSalarial;
    }

    public void setContratoFaixaSalarial(Double contratoFaixaSalarial) {
        this.contratoFaixaSalarial = contratoFaixaSalarial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
            
}

    

    