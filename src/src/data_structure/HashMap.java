package src.data_structure;

import javafx.util.Pair;

import java.util.ArrayList;

public class HashMap {
    private ArrayList<Pair<String, Integer>>[] data;
    private int size;

    HashMap(int size){
        this.data = new ArrayList[size];
        this.size = size;
    }

    private int hashFunction(String key){
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = key.charAt(i) + hash;
        }
        return hash % this.size;
    }

    public void set(String key, Integer value){
        ArrayList<Pair<String, Integer>> bucket = data[hashFunction(key)];
        boolean keyExists = false;

        if (bucket == null) {
            bucket = new ArrayList<>();
        }
        for (int i = 0; i < bucket.size(); i++){
            if((bucket.get(0).getKey().equals(key))) {
                bucket.set(i, new Pair<>(key, value));
                keyExists = true;
            }
        }
        if(!keyExists)  bucket.add(new Pair(key, value));

        data[hashFunction(key)] = bucket;
    }

    public Integer get(String key){
        ArrayList<Pair<String, Integer>> bucket = data[hashFunction(key)];
        if(bucket != null){
            for (Pair p : bucket){
                if(p.getKey().equals(key)){
                    return (int) p.getValue();
                }
            }
        }
        return -1;
    }

}
