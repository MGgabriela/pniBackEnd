package br.com.pni.controller.form;

import br.com.pni.model.Status;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class StatusForm {
  @NotNull
  @NotEmpty
  @Length(min = 2, max = 50)
  private String nome;
  
  public String getNome() {
    return this.nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public Status converter() {
    return new Status(this.nome);
  }
}
