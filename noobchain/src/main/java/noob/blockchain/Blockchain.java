package noob.blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Blockchain {

    private static final Logger logger =  Logger.getLogger(Blockchain.class.getName());

    private List<Block> chain;

    public Blockchain() {
        this.chain = new ArrayList<Block>();
    }

    public Blockchain(List<Block> chain) {
        this.chain = chain;
    }

    public List<Block> getChain() {
        return chain;
    }

    public Block get(int index){
        return chain.get(index);
    }

    public void add(String data) throws Exception {
        if(data != null){
            chain.add(new Block(chain.size(), chain.get(chain.size()-1).getHash(), data));
        } else {
            throw new Exception("Data is blank");
        }
    }

    // ==================================================

    public Boolean isValidChain(){
        Block currentBlock;
        Block previousBlock;

        // loop through blockchain to check hashes
        for(int i=1; i<chain.size(); i++){
            currentBlock = chain.get(i);
            previousBlock = chain.get(i-1);

            // Compare registered hashes against computed hashes
            if( !currentBlock.getHash().equals(currentBlock.calculateHash()) ){
                logger.info("Current hashes are not equal");
                return false;
            }

            // Compare previous hashes against current registered previous hash
            if( !previousBlock.getHash().equals(currentBlock.getPreviousHash()) ){
                logger.info("Previous hashes are not equal");
                return false;
            }
        }

        return true;
    }


    // ==================================================

    @Override
    public String toString() {

        return new GsonBuilder().setPrettyPrinting().create().toJson(chain);

        /*return "Noobchain {" +
                "chain=" + chain +
                '}';*/
    }
}
