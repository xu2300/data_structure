public class Cell<K,V>{
	private K key;
	private V value;
	public Cell(K k, V v){
		key = k;
		value = v;
	}
	public K getKey() { return key; }
    public V getValue() { return value; }
	public boolean equivalent(K k) {
 		return key.equals(k);
	}
	
}	
	
public class Hash<K,V>{
	private final int max_size =10;
	 LinkedList <Cell <K,V>> [] items;
	 
	 public Hash(){
		items = (LinkedList<Cell<K,V>>)new LinkedList[max_size];
	 }
	 
	 public int hashCode(K key){
		return  key.toString().length()%items.length;
	}
	
	public void put(K key, V value){
		int x=hashCode(key);
		if(items[x] ==null){
			items[x] = new LinkedList<Cell<K,V>>;
		}
		LinkedList<Cell<K, V>> collided = items[x];
		for(Cell<K,V> c: collided){
			if(c.equivalent(key)){
				collided.remove(c);
				break;
			}
		}
		Cell<K,V> cell = new Cell<K,V>(key,value);
		collided.add(cell);
	}
	
	public V get(K key) {
		int x = hashCodedOfKey(key);
		if (items[x] == null) {
			return null;
		}
		LinkedList<Cell<K, V>> collided = items [x];
		for (Cell<K, V> c : collided) {
			if (c.equivalent(key)) {
				return c.getValue();
			}
		}
		return null;
		}
	}	 
}
