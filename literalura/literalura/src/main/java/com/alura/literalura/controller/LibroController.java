/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.literalura.controller;

/**
 *
 * @author kille
 */
import com.alura.literalura.model.Libro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.service.GutendexService;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LibroController {

    @Autowired
    private GutendexService gutendexService;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;  // Inyecta el repositorio de Autor

    public void buscarLibro(String titulo) {
        // Llama a la API Gutendex para buscar el libro
        String respuesta = gutendexService.buscarLibroPorTitulo(titulo);

        // Aquí debes agregar el código para parsear el JSON de la respuesta
        if (respuesta != null) {
            if (!libroRepository.existsByTitulo(titulo)) {
                // Crear un nuevo libro
                Libro libro = new Libro();
                libro.setTitulo(titulo);

                // Lógica para registrar el autor
                // Aquí supongo que puedes extraer el nombre del autor de la respuesta JSON
                String nombreAutor = "Nombre del Autor";  // Extraído de la respuesta de la API

                Autor autor = buscarORegistrarAutor(nombreAutor);  // Llamar al método para buscar o registrar el autor
                libro.setAutor(autor);  // Establecer el autor en el libro

                libroRepository.save(libro);  // Guardar el libro en la base de datos
                System.out.println("Libro registrado correctamente.");
            } else {
                System.out.println("El libro ya está registrado.");
            }
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }

    private Autor buscarORegistrarAutor(String nombreAutor) {
        // Buscar el autor en la base de datos
        Autor autor = autorRepository.findByNombre(nombreAutor);
        if (autor == null) {
            // Si no existe, crear uno nuevo
            autor = new Autor();
            autor.setNombre(nombreAutor);
            autorRepository.save(autor);  // Guardar el autor en la base de datos
        }
        return autor;  // Retornar el autor
    }
}