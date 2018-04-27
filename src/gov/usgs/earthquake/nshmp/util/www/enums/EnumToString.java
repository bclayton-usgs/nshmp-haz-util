package gov.usgs.earthquake.nshmp.util.www.enums;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;

/**
 * Static methods for converting an {@code Enum} into different types
 *    of {@code String}s.
 * <br><br>
 * 
 * Turn an {@code Enum} into:
 *    <ul>
 *      <li> Lower camel case: {@link #toLowerCamelCase(Enum)} </li>
 *      <li> Lower case: {@link #toLowerCase(Enum)} </li>
 *      <li> Upper camel case: {@link #toUpperCamelCase(Enum)} </li>
 *      <li> Upper case: {@link #toUpperCase(Enum)} </li>
 *    </ul>
 *    
 *      
 * @author Brandon Clayton
 */
public class EnumToString {

  /**
   * Return a lower camel case {@code String} from an {@code Enum}.
   * @param e The {@code Enum}
   * @return The lower camel case string.
   */
  public static <E extends Enum<E>> String toLowerCamelCase(E e) {
    return UPPER_UNDERSCORE.to(LOWER_CAMEL, e.name());
  }
 
  /**
   * Return a lower case {@code String} from an {@code Enum}. 
   * @param e The {@code Enum}
   * @return The lower case string
   */
  public static <E extends Enum<E>> String toLowerCase(E e) {
    return e.name().toLowerCase();
  }
 
  /**
   * Return a upper camel case {@code String} from an {@code Enum}.
   * @param e The {@code Enum}
   * @return The upper camel case string.
   */
  public static <E extends Enum<E>> String toUpperCamelCase(E e) {
    return UPPER_UNDERSCORE.to(UPPER_CAMEL, e.name());
  }
  
  /**
   * Return a lower case {@code String} from an {@code Enum}. 
   * @param e The {@code Enum}
   * @return The lower case string
   */
  public static <E extends Enum<E>> String toUpperCase(E e) {
    return e.name().toUpperCase();
  }
 
}
