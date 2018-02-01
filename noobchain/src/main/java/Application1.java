import noob.blockchain.Block;
import noob.blockchain.Blockchain;

import java.util.logging.Logger;

public class Application1 {

    private static final Logger logger =  Logger.getLogger(Application1.class.getName());

    /**
     * Test basic list based block chain
     * @param args
     */
    public static void main(String[] args){

        Blockchain blockchain = new Blockchain();

        blockchain.getChain().add(new Block(0,"0", "First Block"));
        blockchain.getChain().add(new Block(1, blockchain.getChain().get(blockchain.getChain().size()-1).getHash(), "Second Block"));
        blockchain.getChain().add(new Block(2,blockchain.getChain().get(blockchain.getChain().size()-1).getHash(), "Third Block"));
        blockchain.getChain().add(new Block(3,blockchain.getChain().get(blockchain.getChain().size()-1).getHash(), "Fourth Block"));
        blockchain.getChain().add(new Block(4,blockchain.getChain().get(blockchain.getChain().size()-1).getHash(), "Fifth Block"));

        logger.info("Full chain: " + blockchain.toString() ) ;

    }


}
