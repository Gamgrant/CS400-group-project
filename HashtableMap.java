// --== CS400 Project One File Header ==--
// Name: Nathin Williams
// CSL Username: nathin
// Email: nwilliams32@wisc.edu
// Lecture #: 004 @4:00pm

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * A Hashtable implementation that can be used for storing key/value pairs
 * 
 * @author nathi
 *
 * @param <KeyType>   the object type for the keys
 * @param <ValueType> the object type for the values
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  protected LinkedList<HashtableNode<KeyType, ValueType>>[] array;

  /**
   * A constructor that creates a new Hashtable
   * 
   * @param capacity the initial array capacity
   */
  @SuppressWarnings("unchecked")
  public HashtableMap(int capacity) {
    array = (LinkedList<HashtableNode<KeyType, ValueType>>[]) new LinkedList[capacity];
  }

  /**
   * A constructor that creates a new Hashtable
   */
  @SuppressWarnings("unchecked")
  public HashtableMap() {
    array = (LinkedList<HashtableNode<KeyType, ValueType>>[]) new LinkedList[20];

  }

  /**
   * Adds a new key/value pair to the hashtable
   * 
   * @param key   the key for the pair
   * @param value the value for the pair
   * @return true if the pair was successfully added
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    // check for null key
    if (key == null) {
      return false;
    }
    // resize table if it's too large
    if ((this.size() + 1) * 100 / array.length >= 75) {
      this.resizeTable();
    }
    int index = Math.abs(key.hashCode()) % array.length;
    if (array[index] == null) {
      // create LinkedList and add node
      array[index] = new LinkedList<HashtableNode<KeyType, ValueType>>();
      HashtableNode<KeyType, ValueType> node = new HashtableNode<KeyType, ValueType>(key, value);
      array[index].add(node);
      return true;
    } else {
      // check for the same key already existing
      for (int i = 0; i < array[index].size(); i++) {
        if (key.equals(array[index].get(i).getKey())) {
          return false;
        }
      }
      // add node
      HashtableNode<KeyType, ValueType> node = new HashtableNode<KeyType, ValueType>(key, value);
      array[index].add(node);
      return true;
    }
  }

  /**
   * Gets the value associated with a given key
   * 
   * @param key the key to search for
   * @return the value found
   * @throws NoSuchElementException if the given key isn't found
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if (key != null) {
      int index = Math.abs(key.hashCode()) % array.length;
      if (!(array[index] == null)) {
        for (int i = 0; i < array[index].size(); i++) {
          if (key.equals(array[index].get(i).getKey())) {
            return array[index].get(i).getValue();
          }
        }
      }
    }
    throw new NoSuchElementException();
  }

  /**
   * Returns the number of elements in the hashtable
   * 
   * @return the size
   */
  @Override
  public int size() {
    int size = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != null) {
        size += array[i].size();
      }
    }

    return size;
  }

  /**
   * Searches for a given key and sees if it's in the table
   * 
   * @param key the key to search for
   * @return true if the key is found, false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    if (key != null) {
      int index = Math.abs(key.hashCode()) % array.length;
      if (!(array[index] == null)) {
        for (int i = 0; i < array[index].size(); i++) {
          if (key.equals(array[index].get(i).getKey())) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Removes a pair from the table
   * 
   * @param key the key of the pair to remove
   * @return the value of the pair removed, null if not found
   */
  @Override
  public ValueType remove(KeyType key) {
    if (key != null) {
      int index = Math.abs(key.hashCode()) % array.length;
      if (!(array[index] == null)) {
        for (int i = 0; i < array[index].size(); i++) {
          if (key.equals(array[index].get(i).getKey())) {
            ValueType value = array[index].get(i).getValue();
            array[index].remove(i);
            return value;
          }
        }
      }
    }
    return null;
  }

  /**
   * Clears the hashtable of all values
   */
  @Override
  public void clear() {
    for (int i = 0; i < array.length; i++) {
      array[i] = null;
    }
  }

  /**
   * Helper method for resizing the table when it reaches the load factor
   */
  @SuppressWarnings("unchecked")
  protected void resizeTable() {
    LinkedList<HashtableNode<KeyType, ValueType>>[] newArray =
        (LinkedList<HashtableNode<KeyType, ValueType>>[]) new LinkedList[array.length * 2];
    LinkedList<HashtableNode<KeyType, ValueType>>[] oldArray = array;
    array = newArray;
    // rehash the old values to the new table
    for (int i = 0; i < oldArray.length; i++) {
      if (!(oldArray[i] == null)) {
        for (int ii = 0; ii < oldArray[i].size(); ii++) {
          HashtableNode<KeyType, ValueType> node = oldArray[i].get(ii);
          int index = Math.abs(node.getKey().hashCode()) % array.length;
          if (array[index] == null) {
            // create LinkedList and add node
            array[index] = new LinkedList<HashtableNode<KeyType, ValueType>>();
          }
          array[index].add(node);
        }
      }
    }
  }
}

