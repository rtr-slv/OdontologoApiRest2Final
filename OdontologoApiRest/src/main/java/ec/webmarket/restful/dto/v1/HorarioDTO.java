package ec.webmarket.restful.dto.v1;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class HorarioDTO {
	
	private Long id;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horafinal;
	private Boolean disponibilidad;
	private OdontologoDTO Odontologo;
	
}
