package com.example.formacionBitboxer2.serviceTest;

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

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProveedorServiceTest {
    @Mock
    IProveedorRepository proveedorRepository;

    @InjectMocks
    ProveedorService proveedorService;

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
    public void should_return_notnull(){
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa1"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa2"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa3"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa4"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa5"));
        Assert.assertNotNull(proveedorService.obtenerPorNombre("empresa6"));
    }

    @Test
    public void shlould_return_country(){
        Assert.assertEquals(proveedorService.obtenerPorNombre("empresa1").getPais(), "España");
        Assert.assertEquals(proveedorService.obtenerPorNombre("empresa3").getPais(), "Suecia");
        Assert.assertEquals(proveedorService.obtenerPorNombre("empresa4").getPais(), "Japón");
    }
    @Test
    public void should_return_size_articles_list(){
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
}
