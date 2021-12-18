package com.ria.scratchpad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomisedSet {

    HashMap<Integer, Integer> hashmap;
    List<Integer> list;

    public static void main(String[] args) {
        RandomisedSet randomisedSet = new RandomisedSet();
        randomisedSet.insert(2);
        randomisedSet.insert(3);
        randomisedSet.insert(6);
        randomisedSet.insert(1);
        System.out.println(randomisedSet.getRandom());
        randomisedSet.print();
        randomisedSet.remove(3);
        randomisedSet.print();
        randomisedSet.remove(6);
        randomisedSet.print();
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.getRandom());
    }

    public void print() {
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();
    }

    RandomisedSet() {
        hashmap = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int num) {
        if(hashmap.containsKey(num))
            return false;
        else {
            list.add(num);
            hashmap.put(num, list.size()-1);
            return true;
        }
    }

    public boolean remove(int num) {
        if(hashmap.containsKey(num)) {
            int index = hashmap.get(num);
            list.set(index, list.get(list.size()-1));
            list.remove(list.size() - 1);
            hashmap.remove(num);
            return true;
        } else
            return false;
    }

    public boolean search(int num) {
        return hashmap.containsKey(num);
    }

    public int getRandom() {
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }

}
