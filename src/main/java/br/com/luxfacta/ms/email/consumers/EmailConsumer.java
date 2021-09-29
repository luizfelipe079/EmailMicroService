package br.com.luxfacta.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.luxfacta.ms.email.dtos.ClienteDto;
import br.com.luxfacta.ms.email.models.ClienteModel;
import br.com.luxfacta.ms.email.models.EmailModel;
import br.com.luxfacta.ms.email.service.EmailService;

@Component
public class EmailConsumer {

	@Autowired
	private EmailService emailService;
	
//	@RabbitListener(queues = "${spring.rabbitmq.queue}")
//	public void listen(@Payload EmailDTO emailDto) {
//		EmailModel emailModel = new EmailModel();
//		BeanUtils.copyProperties(emailDto, emailModel);
//		emailService.sendEmail(emailModel);
//		System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
//	}
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listen(@Payload ClienteDto objDto) {
		ClienteModel clienteModel = new ClienteModel();
		BeanUtils.copyProperties(objDto, clienteModel);
		
		EmailModel emailModel = new EmailModel("Luiz",
											   "desenvolvedorjavatestes@gmail.com",
											   objDto.getEmail(), "Singup Success !",
											   "O cadastro foi realizado com sucesso !");
	
		emailService.sendEmail(emailModel);
		System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
	}
}
