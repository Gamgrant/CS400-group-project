// --== CS400 Project One File Header ==--
// Name: Nathin Williams
// CSL Username: nathin
// Email: nwilliams32@wisc.edu
// Lecture #: 004 @4:00pm

import java.util.LinkedList;
import java.util.List;
public class HashTableSortedSets<KeyType,ValueType extends Comparable<ValueType>> extends HashtableMap<KeyType, List<ValueType>> implements IHashTableSortedSets <KeyType,ValueType>{

  /**
   * This add method is different from the put() method in that it appends a
   * single value to the end of the list associated with a given key.  If a
   * key does not yet have a list of values associated with it, then a new 
   * one will be created when this method is called.
   * @param key used to later lookup the list containing this value
   * @param value associated with the previous key
   */
  @Override
  public void add(KeyType key, ValueType value) {   
    if (key == null || value == null) {
      return;
    }
    
    int index = Math.abs(key.hashCode()) % array.length;
    if (array[index] == null) {
      // create LinkedList at index
      array[index] = new LinkedList<HashtableNode<KeyType, List<ValueType>>>();
      //Create list for values of the same key and add first value
      LinkedList<ValueType> valueList = new LinkedList<ValueType>();
      valueList.add(value);
      //Create node for key/list of values and add to hashtable array
      HashtableNode<KeyType, List<ValueType>> node = new HashtableNode<KeyType, List<ValueType>>(key, valueList);
      array[index].add(node);
    //resize table if needed
      if ((this.size() + 1) * 100 / array.length >= 75) {
        this.resizeTable();
      }
    }
    else {
   // check for the same key already existing in the LinkedList
      for (int i = 0; i < array[index].size(); i++) {
        //If the key is found in the LinkedList, add a new value to that key's List
        if (key.equals(array[index].get(i).getKey())) {
          List<ValueType> keyList = array[index].get(i).getValue();
          for (int ii = 0; ii < keyList.size(); ii ++) {
            int comparison = keyList.get(ii).compareTo(value);
            //List is sorted in ascending order
            if (comparison >= 0) {
              keyList.add(ii, value);
              return;
            }
          }
          keyList.add(value);
        }
        
      }
      //if the key is not found in the LinkedList, create a new key/list combo
      //Create list for values of the same key and add first value
        LinkedList<ValueType> valueList = new LinkedList<ValueType>();
        valueList.add(value);
      //Create node for key/list of values and add to hashtable's LinkedList
        HashtableNode<KeyType, List<ValueType>> node = new HashtableNode<KeyType, List<ValueType>>(key, valueList);
        array[index].add(node);
        
    }
  }

}
