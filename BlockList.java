package blockchain;

import java.util.List;
import java.util.ArrayList;

/*
================================================================================
  LA CLASE BLOCKLIST NOS SIRVE PARA CREAR NUESTRA LISTA DE BLOQUES DE FORMA
  DINAMICA, DEFINIENDO LOS METODOS RESPECTIVOS PARA LA MANIPULACIÓN DE LOS
  MISMOS. TALES COMO:
  
  - OBTENER EL ULTIMO BLOQUE
  - CREAR EL PRIMER BLOQUE DE LA LISTA
  - AÑADIR BLOQUE 
  - VERIFICAR SI LA LISTA ESTA BIEN ASIGNADA
  
================================================================================
 */
public class BlockList {

    private List<Block> blockChain = new ArrayList<>();

    //Getter
    public List<Block> getBlockChain() {
        return blockChain;
    }           
    
    //Metodos
    public void crearPrimerBloque(String datos) {
        blockChain.add(new Block(1, datos, "0"));
    }

    public void agregarBloque(String datos) {
        Block bloqueAnterior = obtenerUltimoBloque();
        Block nuevoBloque = new Block(bloqueAnterior.getNumBloque() + 1, datos, bloqueAnterior.getHashBloque());
        blockChain.add(nuevoBloque);
    }
    
    private Block obtenerUltimoBloque() {        
        return blockChain.get(blockChain.size() - 1);
    }

    //Este metodo verifica la integridad de la información contenida en el BlockChain.
    //Devuelve true, si la información esta intacta
    //Devuelve false, si la información fue modificada    
    public boolean elChainEsValido() {
        for (int i = 1; i < blockChain.size(); i++) {
            Block bloqueActual = blockChain.get(i);
            Block bloqueAnterior = blockChain.get(i - 1);

            if (!bloqueActual.getHashBloque().equals(bloqueActual.calcularHash())) {
                return false;
            }

            if (!bloqueActual.getHashAnterior().equals(bloqueAnterior.calcularHash())) {
                return false;
            }
        }
        return true;
    }        
    
    @Override
    public String toString() {                                        
        return blockChain.toString();
    }
   
}
