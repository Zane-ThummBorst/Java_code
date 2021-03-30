package Pairs;

public class Dict<K,V> {
	private Pairs<K,V>[] ass;
	static final int SIZE = 10;

	Dict(){
		ass = (Pairs <K,V>[]) (new Object [SIZE]);
	}
	public boolean found(K key) {
		for (int i = 0; i < ass.length;i++) {
			if (ass[i].getA() == key) {
				return true;
			}
		}
		return false;
	}
	public V getValue(K key) {
		for (int i = 0; i < ass.length;i++) {
			if (ass[i].getA() == key) {
				return ass[i].getB();
			}
		}
		return null;
	}
}
