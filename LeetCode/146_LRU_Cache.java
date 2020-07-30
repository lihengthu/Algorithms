public class LRUCache {
    private int capa;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capa = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.remove(key);
        map.put(key, val);

        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }

        map.put(key, value);
        if (map.size() > this.capa) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

