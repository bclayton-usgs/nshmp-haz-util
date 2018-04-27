package gov.usgs.earthquake.nshmp.util.www;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;

import gov.usgs.earthquake.nshmp.util.www.enums.Delimiter;
import gov.usgs.earthquake.nshmp.util.www.enums.WebServiceKey;

/**
 * Static methods to read values from a {@code Map<String, String[]>}, 
 *    generally from the {@code HttpServletRequest.getParamterMap()} method.
 * 
 * @author Peter Powers and Brandon Clayton
 */
public class ReadValues {
  
  /**
   * Return the {@code double} associated with a {@link WebServiceKey}
   *    from a {@code Map<String, String[]>}.
   *     
   * @param paramMap The {@code Map} 
   * @param key The {@code WebServiceKey} to find the value.
   * @return The {@code double} value associated with the {@code WebServiceKey}.
   */
  public static double readDoubleValue(
      Map<String, String[]> paramMap, 
      WebServiceKey key) {
    return Double.valueOf(readValue(paramMap, key));
  }
  
  /**
   * Return the {@code double} associated with an {@code Enum} key
   *    from a {@code Map<String, String[]>}.
   *     
   * @param paramMap The {@code Map} 
   * @param key The {@code Enum} key to find the value.
   * @return The {@code double} value associated with
   *    the {@code Enum}.
   */   
  public static double readDoubleValue(
      Map<String, String[]> paramMap, 
      Enum<?> key) {
    return Double.valueOf(readValue(paramMap, key));
  }
  
  /**
   * Return the {@code String} associated with a {@link WebServiceKey}
   *    from a {@code Map<String, String[]>}.
   *     
   * @param paramMap The {@code Map} 
   * @param key The {@code WebServiceKey} to find the value.
   * @return The {@code String} value associated with the {@code WebServiceKey}.
   */
  public static String readValue(Map<String, String[]> paramMap, WebServiceKey key) {
    String keyStr = key.toLowerCase();
    String[] values = paramMap.get(keyStr);
    validate(keyStr, values);
    
    return values[0];
  }
  
  /**
   * Return the {@code String} associated with an {@code Enum} 
   *    from a {@code Map<String, String[]>}.
   *     
   * @param paramMap The {@code Map} 
   * @param key The {@code Enum} to find the value.
   * @return The {@code String} value associated with the {@code WebServiceKey}.
   */
  public static String readValue(Map<String, String[]> paramMap, Enum<?> key) {
    String keyStr = key.name().toLowerCase();
    String values[] = paramMap.get(keyStr);
    validate(keyStr, values);
    
    return values[0];
  }

  /**
   * Convert a {@code String} value into the associated 
   *    {@code Enum} of specified type, if exists.
   * 
   * @param value The {@code String} value to find a matching {@code Enum}.
   * @param type The {@code Enum} type.
   * @return The {@code Enum} matching the {@code String} value.
   */
  public static <T extends Enum<T>> T readValue(String value, Class<T> type) {
    Optional<T> opt = Enums.getIfPresent(type, value);
    checkState(opt.isPresent(), "Invalid value [%s] for enum: %s", value, type.getName());
    return opt.get();
  }

  /**
   * Return the {@code Enum} of specified type associated with the 
   *    {@code String} value in a {@code Map<String, String[]>} 
   *    given the {@link WebServiceKey}.
   *    
   * @param paramMap The {@code Map}.
   * @param key The {@code WebServiceKey}.
   * @param type The {@code Enum} type.
   * @return The {@code Enum} associated with the value of 
   *    {@code WebServiceKey}.
   */
  public static <T extends Enum<T>> T readValue(
      Map<String, String[]> paramMap, 
      WebServiceKey key, 
      Class<T> type) {
    return readValue(readValue(paramMap, key), type);
  }
 
  /**
   * Return the {@code Enum} of specified type associated with the 
   *    {@code String} value in a {@code Map<String, String[]>} 
   *    given the {@code Enum} key.
   *    
   * @param paramMap The {@code Map}.
   * @param key The {@code Enum} key.
   * @param type The {@code Enum} type.
   * @return The {@code Enum} associated with the value of 
   *    the {@code Enum} key.
   */
  public static <E extends Enum<E>> E readValue(
      Map<String, String[]> paramMap,
      Enum<?> key,
      Class<E> type) {
    return readValue(readValue(paramMap, key), type);
  }
 
  /**
   * Return a {@code Set<Enum>} of specified {@code Enum} type 
   *    corresponding to a comma delimited {@code String}.
   *    
   * @param values The comma delimited {@code String} to turn 
   *    to a {@code Set<Enum}.
   * @param type The {@code Enum} type to return.
   * @return The {@code Set<Enum>}.
   */
  public static <T extends Enum<T>> Set<T> readValues(String values, Class<T> type) {
    return EnumSet.copyOf(
        FluentIterable.from(split(values, Delimiter.COMMA))
            .transform(Enums.stringConverter(type))
            .toList());
  }

  /**
   * Return a {@code Set<Enum>} of specifed {@code Enum} type
   *    corresponding to a {@link WebServiceKey} in a 
   *    {@code Map<String, String[]>}.
   *    
   * @param paramMap The {@code Map}.
   * @param key The {@webServiceKey} to search the {@code Map}.
   * @param type The {@code Enum} type to return.
   * @return The {@code Set<Enum>}.
   */
  public static <T extends Enum<T>> Set<T> readValues(
      Map<String, String[]> paramMap, 
      WebServiceKey key,
      Class<T> type) {
    return readValues(readValue(paramMap, key), type);
  }
  
  /**
   * Return a {@code Set<Enum>} of specifed {@code Enum} type
   *    corresponding to a {@link WebServiceKey} in a 
   *    {@code Map<String, String[]>}.
   *    
   * @param paramMap The {@code Map}.
   * @param key The {@webServiceKey} to search the {@code Map}.
   * @param type The {@code Enum} type to return.
   * @return The {@code Set<Enum>}.
   */
  public static <T extends Enum<T>> Set<T> readValues(
      Map<String, String[]> paramMap, 
      Enum<?> key,
      Class<T> type) {
    return readValues(readValue(paramMap, key), type);
  }
  
  /**
   * Check that the {@code String[]} values in not null and
   *    the length of {@code String[]} values in greater than 0;
   *    
   * @param key The {@code String} key that found the values.
   * @param values The {@code String[]} values.
   */
  private static void validate(String key, String[] values) {
    checkNotNull(values, "Missing query key: %s", key);
    checkState(values.length > 0, "Empty value array for key: %s", key);
  }
  
  /**
   * Split a {@code sequence} into string components and make them available
   * through a (possibly-lazy) {@code Iterator}.
   *
   * @param sequence the sequence of characters to split
   * @param delimiter the {@link Delimiter} to split on
   * @see Splitter
   */
  private static Iterable<String> split(CharSequence sequence, Delimiter delimiter) {
    return delimiter.splitter().split(sequence);
  }

}
