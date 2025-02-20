package ec.webmarket.restful.service.crud;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Usuario;
import ec.webmarket.restful.dto.v1.UsuarioDTO;
import ec.webmarket.restful.persistence.UsuarioRepository;
import ec.webmarket.restful.service.GenericCrudServiceImpl;

import java.util.Optional;

@Service
public class UsuarioService extends GenericCrudServiceImpl<Usuario, UsuarioDTO> {

    @Autowired
    private UsuarioRepository repository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<Usuario> find(UsuarioDTO dto) {
        return repository.findById(dto.getId());
    }

    public UsuarioDTO register(UsuarioDTO dto) {
        Usuario usuario = mapToDomain(dto);
        return mapToDto(repository.save(usuario));
    }

    public Optional<UsuarioDTO> authenticate(String nombreUsuario, String clave) {
        Optional<Usuario> usuario = repository.findByNombreUsuarioAndClave(nombreUsuario, clave);
        return usuario.map(this::mapToDto);
    }

    public boolean updatePassword(Long id, String newPassword) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            usuario.get().setPassword(newPassword);
            repository.save(usuario.get());
            return true;
        }
        return false;
    }

    public boolean assignRole(Long id, Boolean userType) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            usuario.get().setUserType(userType);
            repository.save(usuario.get());
            return true;
        }
        return false;
    }

    @Override
    public Usuario mapToDomain(UsuarioDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }

    @Override
    public UsuarioDTO mapToDto(Usuario domain) {
        return modelMapper.map(domain, UsuarioDTO.class);
    }
}


