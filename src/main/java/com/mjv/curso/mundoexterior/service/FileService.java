package com.mjv.curso.mundoexterior.service;

import com.mjv.curso.mundoexterior.model.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    public static List<Superhero> readSuperheroesFromFile(String filePath) {
        List<Superhero> superheroes = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                superheroes.add(new Superhero(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return superheroes;
    }

    public static void main(String[] args) {
        String filePath = "E:\\CursoJava\\Workspace\\mundo-exterior\\mundo-exterior\\mundoExterior.txt";

        List<Superhero> superheroes = FileService.readSuperheroesFromFile(filePath);

        // Imprima os heróis no console
        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getName());
        }

        // Crie um relatório ao término da impressão
        System.out.println("Quantidade de Linhas: " + superheroes.size());
        System.out.println("Quantidade de Caracteres: " + countCharacters(superheroes));
    }

    private static int countCharacters(List<Superhero> superheroes) {
        int totalCharacters = 0;
        for (Superhero superhero : superheroes) {
            totalCharacters += superhero.getName().length();
        }
        return totalCharacters;
    }
}
