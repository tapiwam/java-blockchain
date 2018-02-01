import noob.blockchain.Block;
import noob.blockchain.Blockchain;

import java.util.logging.Logger;

public class Application2 {

    private static final Logger logger =  Logger.getLogger(Application2.class.getName());

    /**
     * Test basic list based block chain
     * @param args
     */
    public static void main(String[] args){

        Blockchain blockchain = new Blockchain();
        int difficulty = 3;

        for(int i=0; i<=5; i++){

            blockchain.getChain().add(new Block(i,"0", "Block " + i));
            logger.info("Trying to mine " + i + "...");
            blockchain.get(i).mineBlock(difficulty);

        }

        logger.info("Full chain: " + blockchain.toString() ) ;

    }


}
