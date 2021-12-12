package br.com.pni.config.validation;

public class ErroFormDto {
	
	private String campo;
	private String erro;
	
	
	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	public ErroFormDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

}
