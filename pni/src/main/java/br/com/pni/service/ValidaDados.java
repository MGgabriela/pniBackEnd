package br.com.pni.service;

import br.com.pni.model.Atuacao;
import br.com.pni.model.Cargo;
import br.com.pni.model.Contracts;
import br.com.pni.model.Escolaridade;
import br.com.pni.model.Instituicao;
import br.com.pni.model.Modalidade;
import br.com.pni.model.Status;
import br.com.pni.model.Vinculo;

public class ValidaDados {
	
	
	public Long validaStatus(String string){		
		Status s = new Status();		
		switch (string) {
		case "ENCERRADO":
			s.setId(1);
			break;
		case "VIGENTE":
			s.setId(2);
			break;
		case "CANCELADO":
			s.setId(3);
			break;
		case "CONTRATADO":
			s.setId(4);
			break;
		case "CONTRATADA":
			s.setId(4);
			break;
		case "RENOVADO":
			s.setId(5);
			break;
		case "TRAMITAÇÃO":
			s.setId(6);
			break;
		case "AGUARDAR":
			s.setId(7);
			break;
		case "AGUARDAR TR":
			s.setId(8);
			break;
		case "ADITIVADA":
			s.setId(9);
			break;
		default:
			System.out.println("\n***(Status)N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}

	public Long validaVinculo(String string){		
		Vinculo s = new Vinculo();		
		switch (string.toUpperCase().trim()) {
		case "BOLSA":
			s.setId(1);
			break;
		case "BOLSISTA":
			s.setId(1);
			break;
		case "PRODUTO":
			s.setId(2);
			break;
		case "SERVIDOR(A)":
			s.setId(3);
			break;
		case "SERVIDOR (A)":
			s.setId(3);
			break;
		case "SERVIDOR":
			s.setId(3);
			break;
		case "SERVIDORA":
			s.setId(3);
			break;
		case "TERCEIRIZADO(A)":
			s.setId(4);		
			break;
		case "TERCEIRIZADO (A)":
			s.setId(4);		
			break;
		case "TERCEIRIZADO":
			s.setId(4);		
			break;
		case "TERCEIRIZADA":
			s.setId(4);		
			break;
		case "CLT":
			s.setId(5);
			break;
		case "TRAMITAÇÃO":
			s.setId(6);
			break;
		case "AGUARDAR":
			s.setId(7);
			break;
		case "AGUARDAR TR":
			s.setId(8);
			break;
		case "ADITIVADA":
			s.setId(9);
			break;
		default:
			System.out.println("\n***(Vinculo "+string+")N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}
	
	public Long validaEscolaridade(String string){		
		Escolaridade s = new Escolaridade();	
		switch (string.toUpperCase().trim()) {		
		case "SUPERIOR INCOMPLETO":			
			s.setId(7);			
			break;
		case "SUPERIORINCOMPLETO":
			s.setId(7);
			break;
		case "SUPERIOR-INCOMPLETO":
			s.setId(7);
			break;
		case "PÓS-MESTRADO":
			s.setId(6);
			break;
		case "PÓSMESTRADO":
			s.setId(6);
			break;
		case "PÓS MESTRADO":
			s.setId(6);
			break;
		case "PÓS-GRADUAÇÃO":			
			s.setId(2);			
			break;
		case "PÓSGRADUAÇÃO":
			s.setId(2);
			break;
		case "PÓS GRADUAÇÃO":
			s.setId(2);
			break;
		case "POS-GRADUAÇÃO":
			s.setId(2);
			break;
		case "PÓS-DOUTORADO":
			s.setId(5);
			break;
		case "PÓSDOUTORADO":
			s.setId(5);
			break;
		case "PÓS DOUTORADO":
			s.setId(5);
			break;
		case "POS-DOUTORADO":
			s.setId(5);
			break;
		case "MESTRADO":
			s.setId(4);
			break;
		case "GRADUAÇÃO":
			s.setId(1);
			break;
		case "GRADUAÇAO":
			s.setId(1);
			break;
		case "GRADUACAO":
			s.setId(1);
			break;
		case "DOUTORADO":
			s.setId(3);		
			break;		
		default:
			System.out.println("\n***(Escolaridade)N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}
	
	public Long validaModalidade(String string){		
		Modalidade s = new Modalidade();		
		switch (string) {
		case "BOLSA":
			s.setId(1);
			break;
		case "BOLSISTA":
			s.setId(1);
			break;
		case "SERVIDOR":
			s.setId(3);
			break;
		case "SERVIDOR(A)":
			s.setId(3);
			break;
		case "SERVIDOR (A)":
			s.setId(3);
			break;
		case "SERVIDORA":
			s.setId(3);		
			break;
		case "CLT":
			s.setId(2);
			break;
		default:
			System.out.println("\n***(Modalidade)N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}
	
	public Long validaInstituicao(String string){		
		Instituicao s = new Instituicao();		
		switch (string) {
		case "FIOTEC":
			s.setId(1);
			break;
		case "OPAS":
			s.setId(2);
			break;	
		default:
			System.out.println("\n***(Instituicao)N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}
	
	public Long validaCargo(String string){		
		Cargo s = new Cargo();		
		switch (string.toUpperCase().trim()) {
		case "BOLSA":
			s.setId(1);
			break;
		case "BOLSISTA":
			s.setId(1);
			break;
		case "CONSULTOR":
			s.setId(2);
			break;
		case "CONSULTOR(A)":
			s.setId(2);
			break;
		case "CONSULTOR (A)":
			s.setId(2);
			break;
		case "TECNOLOGISTA":
			s.setId(3);
			break;
		case "SERVIDOR":
			s.setId(4);
			break;
		case "SERVIDOR(A)":
			s.setId(4);
			break;
		case "SERVIDOR (A)":
			s.setId(4);
			break;
		case "SERVIDORA":
			s.setId(4);		
			break;
		default:
			System.out.println("\n***(Cargo "+string+")N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}
	
	public Long validaAtuacao(String string){		
		Atuacao s = new Atuacao();		
		switch (string.toUpperCase().trim()) {
		case "COORDENADORA-GERAL SUBSTITUTA DO PROGRAMA NACIONAL DE IMUNIZAÇÕES":
			s.setId(15);
			break;
		case "GT- AINFO - ANÁLISE DE DADOS E INFORMAÇÃO":
			s.setId(1);
			break;
		case "GT- EXANTEMÁTICAS":
			s.setId(2);
			break;
		case "GT - Respiratórias/Vigilância COVID-19":
			s.setId(3);
			break;
		case "CGPNI":
			s.setId(4);
			break;
		case "ACESSORIA JURÍDICA":
			s.setId(5);
			break;
		case "APOIO Á GESTÃO/PLANEJAMENTO":
			s.setId(6);
			break;
		case "GT- ADMINISTRAÇÃO":
			s.setId(7);
			break;
		case "GT- EAPV":
			s.setId(8);		
			break;
		case "GT- FA, HB, RAIVA, SAUDE DE":
			s.setId(9);		
			break;
		case "GT- MENIGITES E PNEUMONIA":
			s.setId(10);		
			break;
		case "GT- OPERACIONALIZAÇÃO":
			s.setId(11);		
			break;
		case "GT- PFA/PÓLIO E DTP":
			s.setId(12);
			break;
		case "GT- REDE DE FRIO E CONTROLE":
			s.setId(13);
			break;
		case "GT- REPIRATÓRIAS/VIGILÂNCIA":
			s.setId(14);
			break;
		default:
			System.out.println("\n***(Atuacao "+string+")N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getId();		
	}
	
	public String validaSexo(String string){		
		Contracts s = new Contracts();		
		switch (string.toUpperCase().trim()) {	
		case "F":
			s.setSexo("F");
			break;
		case "FEMININO":
			s.setSexo("F");
			break;
		case "M":
			s.setSexo("M");
			break;
		case "MASCULINO":
			s.setSexo("M");
			break;
		default:
			System.out.println("\n***(Sexo "+string+")N Ã O  E N C O N T R A D O  N O  B A N C O***\n");
			break;
		}
		return s.getSexo();	
	}
	
}
