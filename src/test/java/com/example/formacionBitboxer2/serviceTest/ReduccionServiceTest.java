package com.example.formacionBitboxer2.serviceTest;

import com.example.formacionBitboxer2.Rol;
import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IReduccionRepository;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import com.example.formacionBitboxer2.service.ReduccionService;
import com.example.formacionBitboxer2.service.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ReduccionServiceTest {
    @Mock
    IReduccionRepository reduccionRepository;

    @InjectMocks
    ReduccionService reduccionService;

    private ReduccionConverter reduccionConverter = new ReduccionConverter();

    @Before
    public void setUp(){
        final Usuario usuario = new Usuario ("belen","belen", Rol.valueOf("USER"), new ArrayList<Articulo>());
        final Articulo articulo = new Articulo(1001, "articulo 1", 1);
        articulo.setCreador(usuario);
        Date fechaFin = new Date();
        fechaFin.setYear(2021);
        fechaFin.setMonth(1);
        fechaFin.setDate(31);
        final Reduccion reduccion_art = new Reduccion(0.5, fechaFin, articulo, 1L, true);
        when(reduccionRepository.findByCodigoreduccion(reduccion_art.getCodigoreduccion())).thenReturn(reduccion_art);
    }

    @Test
    public void obtener_reduccion_por_codigo_TEST(){
        ReduccionDTO reduccion = reduccionService.obtenerPorCodigoreduccion(1L);
        Assert.assertNotNull(reduccion);
        Assert.assertNull(reduccionService.obtenerPorCodigoreduccion(2L));
    }
}
