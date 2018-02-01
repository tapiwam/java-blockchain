import noob.blockchain.Block;
import noob.blockchain.Blockchain;

import java.util.logging.Logger;

/**
 * Test basic block implementation individually
 */
public class Application {

    private static final Logger logger =  Logger.getLogger(Application.class.getName());

    public static void main(String[] args){

        Block genesisBlock = new Block("0", "First Block");
        logger.info("Block 1: " + genesisBlock.toString() ) ;

        Block secondBlock = new Block(genesisBlock.getHash(), "Yo im the second block");
        logger.info("Block 1: " + secondBlock.toString() ) ;

        Block thirdBlock = new Block(secondBlock.getHash(), "Yo im the third block");
        logger.info("Block 1: " + thirdBlock.toString() ) ;

    }


}
