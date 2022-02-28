// --== CS400 Project One File Header ==--
// Name: Nathin Williams
// CSL Username: nathin
// Email: nwilliams32@wisc.edu
// Lecture #: 004 @4:00pm

/**
 * a helper class for key/value pairs
 * 
 * @author nathi
 *
 * @param <KeyType>   the key type
 * @param <ValueType> the value type
 */
public class HashtableNode<KeyType, ValueType> {
  protected ValueType value;

  protected KeyType key;

  /**
   * A constructor for a new key/value pair
   * 
   * @param key   the key
   * @param value the value
   */
  public HashtableNode(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Gets the key of this object
   * 
   * @return the key
   */
  public KeyType getKey() {
    return key;
  }

  /**
   * Gets the value of this object
   * 
   * @return the value
   */
  public ValueType getValue() {
    return value;
  }
}
