package com.consultas.springbatch;

import org.joda.time.LocalDate;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.consultas.model.Paciente;

public class PacienteFieldSetMapper implements FieldSetMapper<Paciente> {

	public Paciente mapFieldSet(FieldSet fieldSet) throws BindException {
		Paciente paciente = new Paciente();
		paciente.setName(fieldSet.readString(0));
		paciente.setDob(new LocalDate(fieldSet.readDate(1, "dd/MM/yyyy")));
		paciente.setPercentage(fieldSet.readDouble(2));
		
		return paciente;
	}

}
