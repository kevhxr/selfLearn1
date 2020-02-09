package indi.kevin.selfLearn1.concurrentTest;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 * ((f = tabAt(tab, i = (n - 1) & hash)) == null)
 * if (casTabAt(tab, i, null, new Node<K,V>(hash, key, value, null))
 *
 * 不断循环计算table（散列表）的每个桶位（slot）的散列值i ,直到找到tab[i] 为空的桶位，
 * casTabAt将put（增加）的节点Node 放到空仓（empty bin）中，
 * 如果在put 的过程中，别的线程更改了tab[i],导致tab[i] 不为空，那么casTabAt返回false，
 * 继续循环找tab[i]== null的桶位。整个put 过程没加锁，
 * 利用table 是volatile 的特性，保证在多线程并发更新的过程中table 对所有线程是一致的，
 * Unsafe 可以直接操作内存中的对象。
 *
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("a",1);
        map.put("a",2);
        map.put("b",3);
        System.out.println(map.get("a"));

        /**
         *
         * when reach cap thread (16*0.75=12)
         * create new node table
         * give new node table cap as oldcap << 1 (*2 = 24)
         * copy old node table val to new node table
         * 若桶中链表元素个数大于等于8时，链表转换成树结构
         */
        HashMap map2 = new HashMap();
        for (int i = 0; i <20 ; i++) {
            map2.put("a"+i,i);
        }
        System.out.println(map2.get("a"));

        byte[] dst = new byte[1024];

        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put("abcdefg".getBytes());
        System.out.println(buf.position()+" "+buf.limit()+" "+buf.capacity());
        //buf.get(dst, 0, 2);
        System.out.println(buf.position()+" "+buf.limit()+" "+buf.capacity());
        buf.flip();
        System.out.println(buf.position()+" "+buf.limit()+" "+buf.capacity());
        buf.mark();
        buf.get(dst,0,2);
        System.out.println(buf.position()+" "+buf.limit()+" "+buf.capacity());
        buf.reset();
        System.out.println(buf.position()+" "+buf.limit()+" "+buf.capacity());
        buf.get(dst,2,4);
        System.out.println(buf.position()+" "+buf.limit()+" "+buf.capacity());
        System.out.println(new String(dst,0,dst.length));
    }
}
