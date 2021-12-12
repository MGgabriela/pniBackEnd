package br.com.pni.controller.form;

import br.com.pni.model.Secretaria;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class SecretariaForm {
  @NotNull
  @NotEmpty
  @Length(min = 2, max = 50)
  private String nome;
  
  public String getNome() {
    return this.nome;
  }
  
  public void setNome(String nome) {
    nome = nome.toUpperCase();
    this.nome = nome;
  }
  
  public Secretaria converter() {
    return new Secretaria(this.nome);
  }
}
