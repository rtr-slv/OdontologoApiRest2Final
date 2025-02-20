package ec.webmarket.restful.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Odontologo;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
	
	List<Odontologo> findByNombre(String nombre);
	
	List<Odontologo> findByApellido(String apellido);
	
	List<Odontologo> findByTelefono(String telefono);
	
	List<Odontologo> findByEmail(String email);
	
	Optional<Odontologo> findByUsuario_Id(Long usuarioId);

    Optional<Odontologo> findByUsuario_NombreUsuario(String nombreUsuario);

    Optional<Odontologo> findByCedula(String cedula);
}

