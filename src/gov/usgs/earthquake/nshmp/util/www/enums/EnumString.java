package gov.usgs.earthquake.nshmp.util.www.enums;

/**
 * Interface for ensuring {@code Enum}s will get converted to different
 *    styles of {@code String}s.
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
 * @author Brandon Clayton
 */
public interface EnumString {

  /**
   * Return a lower camel case {@code String}.
   * @return The lower camel case {@code String}.
   */
  public String toLowerCamelCase();
  
  /**
   * Return a lower case {@code String}.
   * @return The lower case {@code String}.
   */
  public String toLowerCase();
  
  /**
   * Return an upper camel case {@code String}.
   * @return The upper camel case {@code String}.
   */
  public String toUpperCamelCase();
  
  /**
   * Return an upper case {@code String}.
   * @return The upper camel case {@code String}.
   */
  public String toUpperCase();
  
}
