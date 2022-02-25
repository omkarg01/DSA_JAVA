import java.util.LinkedList;

public class HashMap<K, V> {

    private class HMNode {
        K key;
        V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<HMNode>[] buckets;

    public HashMap() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bi = hashFunc(key);
        int di = getIndexWithinBucket(key, bi);

        if (di != -1) {
            HMNode node = buckets[bi].get(di);
            node.value = value;
        } else {
            HMNode node = new HMNode(key, value);
            buckets[bi].add(node);
            size++;
        }
    }

    private int getIndexWithinBucket(K key, int bi) {
        int di = 0;

        for (HMNode node : buckets[bi]) {
            if (node.key.equals(key)) {
                return di;
            }
            di++;
        }
        return -1;
    }

    private int hashFunc(K key) {
        int bi = key.hashCode();
        return Math.abs(bi) % buckets.length;
    }

    public void display() {
        // System.out.println(buckets);
        String str = "{\n";
        for (LinkedList<HMNode> linkedList : buckets) {
            for (HMNode node : linkedList) {
                str += ("  " + node.key + " = " + node.value + ",\n");
            }
        }
        str += "}";
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Omkar", 15);
        map.put("Pooja", 10);
        map.put("Pooja", 20);
        map.display();
    }

}
