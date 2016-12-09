package hashmap;

public class MyHashMap<K, V> implements MyHashMapInterface<K, V> {

	private BucketInterface<K, V>[] buckets;
	private double loadFactor;
	private int size;

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		size = 8;
		loadFactor = 10;
		buckets = new LinkedBucket[size];
	}

	@Override
	public void put(K key, V value) {
		int bucketIndex = calculateBucketIndex(key);

		buckets[bucketIndex].add(key, value);
	}

	@Override
	public V get(K key) {
		int bucketIndex = calculateBucketIndex(key);

		return buckets[bucketIndex].get(key);
	}

	@Override
	public void remove(K key) {
		int bucketIndex = calculateBucketIndex(key);

		buckets[bucketIndex].remove(key);
	}

	@Override
	public boolean containsKey(K key) {
		return (get(key) != null);
	}

	private int calculateBucketIndex(K key) {
		return key.hashCode() % size;
	}

	@SuppressWarnings("unused")
	private void resize() {

	}

	/*
	 * Resize
	 * 
	 * 1. create new LinkedBucket[2*size]
	 * 
	 * 2. oldlist = this.list list = newList
	 * 
	 * 3.for each element in oldList -> put() into newList
	 * 
	 */

}
