package blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
================================================================================
  LA CLASE BLOCK NOS SIRVE PARA CREAR LOS BLOQUES QUE COMPONDRAN AL BLOCKCHAIN,
  SIGUIENDO LAS INDICACIONES PROPORCIONADAS POR EL DOCENTE, UN BLOQUE TENDRA 
  COMO ATRIBUTOS:

  - NUMERO BLOQUE
  - TIMESTAMP
  - DATOS
  - HASH ANTERIOR
  - HASH DEL BLOQUE

  NOTA: SE MODIFICO EL METODO PARA OBTENER EL VALOR HASH, ADECUANDOLO A LOS
        REQUERIMIENTOS DEL PROGRAMA.
================================================================================
*/

public class Block {

    //Atributos
    private int numBloque;
    private Long timeStamp;
    private String datos;
    private String hashAnterior;
    private String hashBloque;

    //Constructor
    public Block(int numBloque, String datos, String hashAnterior) {
        this.numBloque = numBloque;
        this.timeStamp = System.currentTimeMillis();
        this.datos = datos;
        this.hashAnterior = hashAnterior;
        this.hashBloque = calcularHash();
    }

    //Getters - Setters
    public int getNumBloque() {
        return numBloque;
    }

    public void setNumBloque(int numBloque) {
        this.numBloque = numBloque;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public void setHashAnterior(String hashAnterior) {
        this.hashAnterior = hashAnterior;
    }

    public String getHashBloque() {
        return hashBloque;
    }

    public void setHashBloque(String hashBloque) {
        this.hashBloque = hashBloque;
    }

    //Se modifico el metodo proporcionado para calcular el hash
    public String calcularHash() {

        String text = String.valueOf(numBloque + hashAnterior + String.valueOf(timeStamp) + String.valueOf(datos));

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        final byte bytes[] = md.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();

        for (final byte b : bytes) {
            String hex = Integer.toHexString(b);

            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);

        }

        return hexString.toString();

    }

    @Override
    public String toString() {
        
        System.out.println("=========================================================================================================================================");
        System.out.println("- NumBloque: " + numBloque);
        System.out.println("- TimeStamp: " + timeStamp);
        System.out.println("- Datos: " + datos);
        System.out.println("- HashAnterior: " + hashAnterior);
        System.out.println("- HashBloque: " + hashBloque);        
        System.out.println("=========================================================================================================================================");
        
        return "";
    }
    
}
