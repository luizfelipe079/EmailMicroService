package br.com.luxfacta.ms.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luxfacta.ms.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Integer>{

}
