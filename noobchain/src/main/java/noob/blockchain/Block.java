package noob.blockchain;

import noob.util.StringUtil;

import java.util.Date;

public class Block {

    protected Integer id;
    protected String hash;
    protected String previousHash;
    protected String data;
    protected Long timestamp;
    private int nonce;

    // Block constructor
    public Block(Integer id, String previousHash, String data) {
        this.id = id;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();

        this.hash = calculateHash();
    }

    /*public Block(String previousHash, String data) {
        this.id = null;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();

        this.hash = calculateHash();
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    // ====================================

    public String calculateHash() {

        String calculatedHash = StringUtil.applySha256(
                getHashString()
        );

        return calculatedHash;
    }

    private String getHashString(){
        return previousHash
                + timestamp.toString()
                + Integer.toString(nonce)
                + data;
    }

    // ====================================

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    // ====================================

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
