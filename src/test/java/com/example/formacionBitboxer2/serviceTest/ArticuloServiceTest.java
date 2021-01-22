package com.example.formacionBitboxer2.serviceTest;

import com.example.formacionBitboxer2.Rol;
import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IArticuloRepository;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import com.example.formacionBitboxer2.service.ArticuloService;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ArticuloServiceTest {

    @Mock
    IArticuloRepository articuloRepository;

    @Mock
    IUsuarioRepository usuarioRepository;

    @InjectMocks
    ArticuloService articuloService;

    ArticuloConverter articuloConverter = new ArticuloConverter();

    @Before
    public void setUp(){
        final Usuario usuario = new Usuario ("belen","belen", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Articulo articulo = new Articulo(1001, "articulo 1", 1);
        articulo.setCreador(usuario);
        final Articulo articulo_2 = new Articulo(1002, "articulo 2", 1);
        final Articulo articulo_3 = new Articulo(1003, "articulo 3", 1);
        final Articulo articulo_4 = new Articulo(1004, "articulo 4", 2);
        Mockito.when(articuloRepository.findByCodigoarticulo(articulo.getCodigoarticulo())).thenReturn(articulo);
        Mockito.when(articuloRepository.findByCodigoarticulo(articulo_2.getCodigoarticulo())).thenReturn(articulo_2);
        Mockito.when(articuloRepository.findByCodigoarticulo(articulo_3.getCodigoarticulo())).thenReturn(articulo_3);
        Mockito.when(articuloRepository.findByCodigoarticulo(articulo_4.getCodigoarticulo())).thenReturn(articulo_4);
        Mockito.when(usuarioRepository.findByNombreusuario("belen")).thenReturn(usuario);
    }

    @Test
    public void should_return_notnull_article_exist(){
        Assert.assertNotNull(articuloService.obtenerPorCodigoarticulo(1001));
        Assert.assertNotNull(articuloService.obtenerPorCodigoarticulo(1002));
        Assert.assertNotNull(articuloService.obtenerPorCodigoarticulo(1003));
        Assert.assertNotNull(articuloService.obtenerPorCodigoarticulo(1004));
    }

    @Test
    public void should_return_state_1(){
        Assert.assertEquals(articuloService.obtenerPorCodigoarticulo(1001).getEstado().intValue(),1);
        Assert.assertNotEquals(articuloService.obtenerPorCodigoarticulo(1001).getEstado().intValue(),2);

        Assert.assertEquals(articuloService.obtenerPorCodigoarticulo(1002).getEstado().intValue(),1);
        Assert.assertNotEquals(articuloService.obtenerPorCodigoarticulo(1002).getEstado().intValue(),2);


        Assert.assertEquals(articuloService.obtenerPorCodigoarticulo(1003).getEstado().intValue(),1);
        Assert.assertNotEquals(articuloService.obtenerPorCodigoarticulo(1003).getEstado().intValue(),2);
    }

    @Test
    public void should_return_state_2(){
        Assert.assertEquals(articuloService.obtenerPorCodigoarticulo(1004).getEstado().intValue(),2);
        Assert.assertNotEquals(articuloService.obtenerPorCodigoarticulo(1004).getEstado().intValue(),1);
    }

    @Test
    public void should_return_size(){
        Assert.assertEquals(articuloService.obtenerTodos().size(),0);
        //4 artículos
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo());
        articulos.add(new Articulo());
        articulos.add(new Articulo());
        articulos.add(new Articulo());
        Mockito.when(articuloRepository.findAll()).thenReturn(articulos);
        Assert.assertEquals(articuloService.obtenerTodos().size(),4);

        //5 artículos
        articulos.add(new Articulo());
        Assert.assertEquals(articuloService.obtenerTodos().size(),5);

        //3 articulos
        articulos.remove(1);
        articulos.remove(1);
        Assert.assertEquals(articuloService.obtenerTodos().size(),3);
    }

    @Test
    public void save_article(){
        final Usuario usuario = new Usuario ("belen","belen", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final ArticuloDTO articuloDto = new ArticuloDTO ();
        articuloDto.setCreador(usuario);
        articuloDto.setPrecio(9.1);
        articuloDto.setDescripcion("Articulo de prueba");
        articuloDto.setEstado(1);
        articuloDto.setCodigoarticulo(1009);


        when(articuloRepository.findByCodigoarticulo(articuloDto.getCodigoarticulo())).thenReturn(null);
        articuloService.guardarArticulo(articuloDto);
        Articulo articulo = articuloConverter.dto2pojo(articuloDto);
        when(articuloRepository.save(Mockito.any(Articulo.class))).thenReturn(articulo);

        verify(articuloRepository, times(1)).save(Mockito.any(Articulo.class));

        Assert.assertEquals(articuloDto.getCodigoarticulo(), articulo.getCodigoarticulo());
    }

    /*@Test
    public void delete_article() throws Exception{
        final Articulo articulo = new Articulo(1001, "articulo 1", 1);
        articuloService.eliminarArticulo(articulo.getCodigoarticulo());
        Mockito.when(articuloRepository.findByCodigoarticulo(articulo.getCodigoarticulo())).thenReturn(null);

        Assert.assertEquals(articuloService.obtenerPorCodigoarticulo(articulo.getCodigoarticulo()), null);
    }*/

}
