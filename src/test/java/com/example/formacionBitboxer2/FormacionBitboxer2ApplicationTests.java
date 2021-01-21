package com.example.formacionBitboxer2;

import com.example.formacionBitboxer2.controller.ArticuloController;
import com.example.formacionBitboxer2.controller.ProveedorController;
import com.example.formacionBitboxer2.controller.ReduccionController;
import com.example.formacionBitboxer2.controller.UsuarioController;
import com.example.formacionBitboxer2.converter.ArticuloConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FormacionBitboxer2ApplicationTests {

	@Autowired
	private ArticuloController articuloController;

	@Autowired
	private UsuarioController usuarioController;

	@Autowired
	private ReduccionController reduccionController;

	@Autowired
	private ProveedorController proveedorController;


	@Test
	void contextLoads() throws Exception{
		assertThat(articuloController).isNotNull();
		assertThat(usuarioController).isNotNull();
		assertThat(reduccionController).isNotNull();
		assertThat(proveedorController).isNotNull();
	}

}
