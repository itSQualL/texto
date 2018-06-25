package com.texto;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.StringBuilder;
import java.util.Scanner;

public class Main {
    public static Scanner read = new Scanner (System.in);

    public static void main(String[] args) throws IOException {
        String texto = readFile("/home/itsquall/IdeaProjects/Texto/src/com/texto/quijote1.txt", Charset.defaultCharset());

        System.out.println("Bienvenid@.\n¿Qué estrategia quieres usar?\n1.- Fuerza Bruta\n2.- Karp-Rabin");
        byte strategyElection = read.nextByte();

        System.out.println("Introduce cuanto quieres acortar el texto (de 0,0 a 1,0)");
        Double porcentaje = read.nextDouble();
        texto = acortar(texto, porcentaje);

        System.out.println("Introduce el patrón");
        String patron = read.next();

        int ocurrencias;
        switch (strategyElection) {
            case 1:
                ocurrencias = ocurrencias(new Bruta(), patron, texto);
                System.out.println("Ocurrencias de "+ patron +": "+ ocurrencias);
                break;
            case 2:
                ocurrencias = ocurrencias(new KarpRabin(), patron, texto);
                System.out.println("Ocurrencias de "+ patron +": "+ ocurrencias);
                break;
        }

    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    static String acortar(String texto, double porcentaje) {
        double borrar = (texto.length() * porcentaje);
        StringBuilder sb = new StringBuilder(texto);

        for(int i = 0; i < (int) borrar; i++) {
            sb.deleteCharAt((int)Math.random() * sb.length());
        }

        return sb.toString();
    }

    static int ocurrencias(Strategy estrategia, String patron, String texto) {
        return estrategia.ocurrencias(patron, texto);
    }
}
