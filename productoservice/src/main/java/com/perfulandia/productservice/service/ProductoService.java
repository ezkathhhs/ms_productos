package com.perfulandia.productservice.service;

import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; // Necesario para la comunicación

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;
    private final RestTemplate restTemplate;

    @Value("${usuarioservice.url=http://localhost:8080/api/usuarios}")
    private String usuarioServiceUrl;

    public ProductoService(ProductoRepository repo, RestTemplate restTemplate){
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    // listar
    public List<Producto> listar(){
        return repo.findAll();
    }

    // Guardar
    public Producto guardar(Producto producto){
        return repo.save(producto);
    }

    // Buscar por id
    public Producto buscar(long id){
        return repo.findById(id).orElse(null);
    }

    // Eliminar por id
    public void eliminar(long id){
        repo.deleteById(id);
    }
}