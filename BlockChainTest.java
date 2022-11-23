package blockchain;

/*
================================================================================
      LA CLASE BLOCKCHAINTEST SIRVE PARA PROBAR LO REALIZADO ANTERIORMENTE

 SE COMIENZA POR CREAR UN OBJETO DE TIPO BLOCKLIST; POSTERIORMENTE, SE PROCEDE 
 A AÑADIR ELEMENTOS A LA LISTA DE BLOQUES; DESPUÉS, SE VALIDA SI EL BLOCKCHAIN
 ES VALIDO, RETORNANDO TRUE.

 POR ULTIMO, SE MODIFICA EL SEGUNDO BLOQUE CONTENIDO EN EL BLOCKCHAIN, ASIGNANDOLE
 OTRO VALOR. NUEVAMENTE SE VALIDA, OBTENIENDO COMO RESULTADO UN FALSE, DEBIDO A
 QUE SE MODIFICO EL VALOR DE UNO DE LOS BLOQUES.
================================================================================
 */
public class BlockChainTest {

    public static void main(String[] args) {

        BlockList blockChain = new BlockList();

        //Creamos el primer bloque
        blockChain.crearPrimerBloque("Luis tiene 800 pesos");

        //Añadimos más bloques al BlockChain
        blockChain.agregarBloque("Le presta 500 a su amigo jesus");
        blockChain.agregarBloque("Jesus se gasta 200 ");

        
        //BlockChain antes de modificar --> True
        System.out.println(blockChain.elChainEsValido());                                       
        System.out.println(blockChain.toString());
        
        
        System.out.println("\n\n");
        

        //BlockChain después de modificar --> False
        blockChain.getBlockChain().get(1).setDatos("Le regala 500 a su amigo jesus");
        System.out.println(blockChain.elChainEsValido());                                                      
        System.out.println(blockChain.toString());
    }
}
