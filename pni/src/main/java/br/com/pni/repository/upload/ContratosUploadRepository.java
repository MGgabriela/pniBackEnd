package br.com.pni.repository.upload;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pni.model.Contracts;
import br.com.pni.model.upload.Contratos;

public interface ContratosUploadRepository extends JpaRepository<Contratos, Long>{

}
