package classfile;
import java.io.*;
import java.lang.String;
import java.util.*;

class TNode {
    boolean isWord;
    TNode[] array = new TNode[26];
}

public class Tries {
    public TNode root;
    public Tries() {
        root = new TNode();
        root.isWord = true;
    }
    public  int map(char ch) {
        return (int)ch - 'a';
    }
    public  void add(TNode r, int[] arr, int k) {
        if( k < arr.length) {
            if(r.array[arr[k]] == null)
                r.array[arr[k]] = new TNode();
            if(k == arr.length-1)
                r.isWord = true;
            add(r.array[arr[k]], arr, k+1);
        }
    }

    public  boolean contains(TNode r, int[] arr, int h) {
        if(h < arr.length && r.array[arr[h]] != null) {
            if(h + 1 == arr.length && r.isWord)
                return true;
            else
                return contains(r.array[arr[h]], arr, h+1);
        }
        return false;
    }
    public  void addWord(TNode r,  String word, int k) {
        if( k < word.length()) {
            if(r.array[map(word.charAt(k))] == null)
                r.array[map(word.charAt(k))] = new TNode();
            if(k == word.length()-1)
                r.isWord = true;
            addWord(r.array[map(word.charAt(k))], word, k+1);
        }
    }
    public  boolean containsWord(TNode r, String word, int k) {
        if(word.length() == 0)
            return r.isWord;
        if(k < word.length() && r.array[map(word.charAt(k))] != null) {
            if(k + 1 == word.length() && r.isWord)
                return true;
            else
                return containsWord(r.array[map(word.charAt(k))], word, k+1);
        }
        return false;
    }
}
