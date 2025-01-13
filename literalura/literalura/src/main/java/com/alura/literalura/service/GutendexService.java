/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.literalura.service;

/**
 *
 * @author kille
 */

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {

    private final RestTemplate restTemplate;

    public GutendexService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Busca un libro por título en la API de Gutendex.
     * @param titulo El título del libro a buscar.
     * @return La respuesta de la API en formato JSON.
     */
    public String buscarLibroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Error al buscar el libro: " + e.getMessage();
        }
    }

    public String buscarLibro(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}