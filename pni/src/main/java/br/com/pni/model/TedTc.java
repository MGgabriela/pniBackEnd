package br.com.pni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ted_tc")
public class TedTc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ted_tc_id")
	private Long id;

	@Column(name = "ted_tc_numero")
	private String tedTcNumero;

	public TedTc(Long id, String tedTcNumero) {
		this.id = id;
		this.tedTcNumero = tedTcNumero;
	}

	public TedTc() {
	}

	public String getTedTcNumero() {
		return this.tedTcNumero;
	}

	public void setTedTcNumero(String tedTcNumero) {
		this.tedTcNumero = tedTcNumero;
	}

	public long getId() {
		return this.id.longValue();
	}

	public void setId(long id) {
		this.id = Long.valueOf(id);
	}
}
