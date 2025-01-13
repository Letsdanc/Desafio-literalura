/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.literalura.repository;

/**
 *
 * @author kille
 */



import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

// Añadir método para buscar por nombre
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);  // Método para buscar por nombre
}
