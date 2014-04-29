import java.util.HashMap;



public class LRUCache {
    private HashMap<Integer, DoubleLinkedNode> hashing = new HashMap<Integer, DoubleLinkedNode>();
    private DoubleLinkedNode head;
    private DoubleLinkedNode end;
    int capacity;
    int length = 0;


    private void setHead(DoubleLinkedNode node) {
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;

        head = node;
        if (end ==null)
            end = head;
    }    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashing.containsKey(key)) {
            DoubleLinkedNode queryNode = hashing.get(key);
            // remove query node to the head;
            if (queryNode.prev != null) 
                queryNode.prev.next = queryNode.next;
            else
                head = queryNode.next;
            if (queryNode.next != null)
                queryNode.next.prev = queryNode.prev;
            else
                end = queryNode.prev;
            
            setHead(queryNode);
            
            return head.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (hashing.containsKey(key)) {
            DoubleLinkedNode setNode = hashing.get(key);
            setNode.value = value;

            if (setNode.prev != null)
                setNode.prev.next = setNode.next;
            else
                head = setNode.next;
            if (setNode.next != null)
                setNode.next.prev = setNode.prev;
            else
                end = setNode.prev;
            setHead(setNode);
        } else {
            if (length == capacity) {
                if (end != null) {
                    hashing.remove(end.key);
                    if (end.prev != null)
                        end.prev.next = end.next;
                    end = end.prev;
                }
                --length;
            }
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            setHead(newNode);
            hashing.put(key, newNode);
            ++length;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(1,1);
        System.out.println(cache.get(2));
        cache.set(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
