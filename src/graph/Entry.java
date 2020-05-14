package graph;


/**
 * Entry class that store a K, V pair. 
 * @author Andrea C. Miranda Acevedo
 *
 * @param <K>
 * @param <V>
 */
public class Entry<K, V> {
	
	K node;
	V value;
	
	// Constructor
	
	public Entry(K node, V value) {
		this.node = node;
		this.value = value;
	}
	
	//Setters and getters
	public K getNode() {
		return node;
	}
	public void setNode(K node) {
		this.node = node;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	
	

}
