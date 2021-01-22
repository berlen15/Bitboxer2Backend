package com.example.formacionBitboxer2.serviceTest;

import com.example.formacionBitboxer2.Rol;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import com.example.formacionBitboxer2.service.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class UsuarioServiceTest {
    @Mock
    IUsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    @Before
    public void setUp(){
        final Usuario usuario = new Usuario ("belen","belen", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_2 = new Usuario ("belen2","belen2", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_3 = new Usuario ("belen3","belen3", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_4 = new Usuario ("admin","admin", Rol.valueOf("ADMIN"), new ArrayList<Articulo>());
        Mockito.when(usuarioRepository.findByNombreusuario(usuario.getNombreusuario())).thenReturn(usuario);
        Mockito.when(usuarioRepository.findByNombreusuario(usuario_2.getNombreusuario())).thenReturn(usuario);
        Mockito.when(usuarioRepository.findByNombreusuario(usuario_3.getNombreusuario())).thenReturn(usuario);
        Mockito.when(usuarioRepository.findByNombreusuario(usuario_4.getNombreusuario())).thenReturn(usuario);

    }


    @Test
    public void should_return_null_user_because_not_exist(){
        final Usuario usuario = new Usuario ("nuevo","nuevo", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_2 = new Usuario();
        Assert.assertNull(usuarioService.buscarPorNombreUsuario(usuario.getNombreusuario()));
        Assert.assertNull(usuarioService.buscarPorNombreUsuario(usuario_2.getNombreusuario()));
    }

    @Test
    public void should_return_user_because_exist(){
        String nombreusuario = "belen";
        UsuarioDTO usuario = usuarioService.buscarPorNombreUsuario(nombreusuario);
        Assert.assertEquals(usuario.getNombreusuario(), "belen");
    }

    @Test
    public void should_return_size_0(){
        Assert.assertEquals(usuarioService.findAll().size(), 0);
    }

    @Test
    public void should_return_number_of_users(){
        final Usuario usuario = new Usuario ("belen","belen", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_2 = new Usuario ("belen2","belen2", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_3 = new Usuario ("belen3","belen3", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Usuario usuario_4 = new Usuario ("admin","admin", Rol.valueOf("ADMIN"), new ArrayList<Articulo>());
        List<Usuario> usuarios = new ArrayList<>();
        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);
        usuarios.add(usuario);
        usuarios.add(usuario_2);
        Assert.assertEquals(usuarioService.findAll().size(), 2);
        usuarios.add(usuario_3);
        usuarios.add(usuario_4);
        Assert.assertEquals(usuarioService.findAll().size(), 4);
    }

}
