package com.consultas.springbatch;

import org.springframework.batch.item.ItemProcessor;

import com.consultas.model.Paciente;

public class PacienteProcessor implements ItemProcessor<Paciente, Paciente> {

	public Paciente process(Paciente paciente) throws Exception {
		System.out.println("Processing paciente from the file agenda-consulta.txt: " + paciente);
		
		if(paciente.getPercentage() <= 60){
			return null;
		}
		
		return paciente;
	}

}
