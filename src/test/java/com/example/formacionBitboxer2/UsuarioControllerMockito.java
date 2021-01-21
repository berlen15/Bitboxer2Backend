package com.example.formacionBitboxer2;

import com.example.formacionBitboxer2.controller.UsuarioController;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(properties = { "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" })
@AutoConfigureTestDatabase
public class UsuarioControllerMockito {
    @InjectMocks
    private UsuarioController usuarioController = new UsuarioController();

    @Mock
    private IUsuarioRepository usuarioRepository;

    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


   /* @Test
    public void createUserTest(){
        Usuario usuario = new Usuario("javi", "javi", Rol.USER, new ArrayList<Articulo>());
        usuarioController.crearUsuario(usuarioConverter.pojo2dto(usuario));
        verify(usuarioRepository.findByNombreusuario("javi"));

    }*/
}
