package noob.blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

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

    public void setChain(List<Block> chain) {
        this.chain = chain;
    }

    @Override
    public String toString() {

        return new GsonBuilder().setPrettyPrinting().create().toJson(chain);

        /*return "Noobchain {" +
                "chain=" + chain +
                '}';*/
    }
}
