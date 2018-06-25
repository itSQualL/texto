package com.texto;

public class KarpRabin implements Strategy {
    public int ocurrencias(String patron, String texto){
        int ocurrencia = 0;
        int m=patron.length();

        for(int n=0;n<=texto.length()-m;n++){
            String aux=texto.substring(n, n+m);
            if (aux.hashCode()==patron.hashCode() && aux.equals(patron)) ocurrencia++;
        }

        return ocurrencia;
    }
}
