package com.example.formacionBitboxer2.serviceTest;

import com.example.formacionBitboxer2.converter.ProveedorConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import com.example.formacionBitboxer2.service.ProveedorService;
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
public class ProveedorServiceTest {
    @Mock
    IProveedorRepository proveedorRepository;

    @InjectMocks
    ProveedorService proveedorService;

    private ProveedorConverter proveedorConverter = new ProveedorConverter();

    @Before
    public void setUp(){
        final Proveedor proveedor = new Proveedor("empresa1", "España");
        final Proveedor proveedor_2 = new Proveedor("empresa2", "España");
        final Proveedor proveedor_3 = new Proveedor("empresa3", "Suecia");
        final Proveedor proveedor_4 = new Proveedor("empresa4", "Japón");
        final Proveedor proveedor_5 = new Proveedor("empresa5", "Japón");
        final Proveedor proveedor_6 = new Proveedor("empresa6", "Suecia");
        Mockito.when(proveedorRepository.findByNombre(proveedor.getNombre())).thenReturn(proveedor);
        Mockito.when(proveedorRepository.findByNombre(proveedor_2.getNombre())).thenReturn(proveedor_2);
        Mockito.when(proveedorRepository.findByNombre(proveedor_3.getNombre())).thenReturn(proveedor_3);
        Mockito.when(proveedorRepository.findByNombre(proveedor_4.getNombre())).thenReturn(proveedor_4);
        Mockito.when(proveedorRepository.findByNombre(proveedor_5.getNombre())).thenReturn(proveedor_5);
        Mockito.when(proveedorRepository.findByNombre(proveedor_6.getNombre())).thenReturn(proveedor_6);

    }

    @Test
    public void obtener_por_nombre_TEST(){
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa1"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa2"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa3"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa4"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa5"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa6"));
    }

    @Test
    public void obtener_pais_TEST(){
        Assert.assertEquals(proveedorService.obtenerPorNombre("empresa1").getPais(), "España");
        Assert.assertEquals(proveedorService.obtenerPorNombre("empresa3").getPais(), "Suecia");
        Assert.assertEquals(proveedorService.obtenerPorNombre("empresa4").getPais(), "Japón");
    }
    @Test
    public void obtener_numero_articulos_TEST(){
        Proveedor proveedor = new Proveedor(1, "empresa_nueva", "España", new ArrayList<Articulo>());
        Mockito.when(proveedorRepository.findByNombre(proveedor.getNombre())).thenReturn(proveedor);
        Assert.assertEquals(proveedorRepository.findByNombre(proveedor.getNombre()).getArticulos().size(),0);
        //Lista de artículos y artículos
        List<Articulo> articulos = new ArrayList<>();
        proveedor.setArticulos(articulos);
        Articulo articulo = new Articulo();
        Articulo articulo_2 = new Articulo();

        //Lista con un artículo
        articulos.add(articulo);
        Assert.assertEquals(proveedorRepository.findByNombre(proveedor.getNombre()).getArticulos().size(),1);

        //Lista con dos artículos
        articulos.add(articulo_2);
        Assert.assertEquals(proveedorRepository.findByNombre(proveedor.getNombre()).getArticulos().size(),2);
    }

    @Test
    public void guardar_proveedor_TEST(){
        final ProveedorDTO proveedorDTO = new ProveedorDTO ();
        proveedorDTO.setPais("España");
        proveedorDTO.setNombre("proveedor-nuevo");
        //Lista de articulos para el proveedor
        List<ArticuloDTO> articulos = new ArrayList<>();
        proveedorDTO.setArticulos(articulos); //asignación
        ArticuloDTO articulo = new ArticuloDTO();
        ArticuloDTO articulo_2 = new ArticuloDTO();

        articulos.add(articulo);
        articulos.add(articulo_2);

        when(proveedorRepository.findByNombre(proveedorDTO.getNombre())).thenReturn(null);
        proveedorService.guardarProveedor(proveedorDTO);
        Proveedor proveedor = proveedorConverter.dto2pojo(proveedorDTO);
        when(proveedorRepository.save(Mockito.any(Proveedor.class))).thenReturn(proveedor);

        verify(proveedorRepository, times(1)).save(Mockito.any(Proveedor.class));

        Assert.assertEquals(proveedorDTO.getNombre(), proveedor.getNombre());
        Assert.assertEquals(proveedorDTO.getPais(), proveedor.getPais());
        Assert.assertEquals(proveedorDTO.getArticulos().size(), proveedor.getArticulos().size());
    }

    @Test
    public void obtener_articulo_mas_barato_TEST(){
        Proveedor proveedor = new Proveedor(1, "empresa_nueva", "España", new ArrayList<Articulo>());
        final Articulo articulo = new Articulo(1002, "articulo 2", 1);
        articulo.setPrecio(1.9);
        final Articulo articulo_2 = new Articulo(1003, "articulo 3", 1);
        articulo_2.setPrecio(2.9);
        final Articulo articulo_3 = new Articulo(1004, "articulo 4", 2);
        articulo_3.setPrecio(3.9);
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(articulo);
        articulos.add(articulo_2);
        articulos.add(articulo_3);
        proveedor.setArticulos(articulos);
        Mockito.when(proveedorRepository.findByNombre(proveedor.getNombre())).thenReturn(proveedor);

        final double DELTA = 1e-15;
        ArticuloDTO articulo_barato = proveedorService.articuloMasBaratoPorProveedor(proveedor.getNombre());
        Assert.assertEquals(0, Double.compare(articulo_barato.getPrecio(), 1.9));
        Assert.assertNotEquals(0, Double.compare(articulo_barato.getPrecio(), 2.9));
        Assert.assertNotEquals(0, Double.compare(articulo_barato.getPrecio(), 3.9));
    }
}
