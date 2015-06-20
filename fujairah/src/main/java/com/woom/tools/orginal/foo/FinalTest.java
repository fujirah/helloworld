package com.woom.tools.orginal.foo;

/**
 * Created by yuhao.zx on 15-1-19.
 */
public class FinalTest {
    static final class HashEntry<K,V> {
        final K key;
        final int hash;
        volatile V value;
        final HashEntry<K,V> next;
        HashEntry(int hash, K key, V value, HashEntry<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
