package gov.usgs.earthquake.nshmp.util.www.enums;

/**
 * Identifiers for different parameter types:
 *    <ul>
 *      <li> Integer </li>
 *      <li> Number </li>
 *      <li> String </li>
 *    </ul>
 *
 * @author Brandon Clayton
 */
public enum ParamType implements EnumString {
  INTEGER,
  NUMBER,
  STRING;
 
  public String toLowerCamelCase() {
    return EnumToString.toLowerCamelCase(this);
  }
  
  public String toLowerCase() {
    return EnumToString.toLowerCase(this);
  }
  
  public String toUpperCamelCase() {
    return EnumToString.toUpperCamelCase(this);
  }
  
  public String toUpperCase() {
    return EnumToString.toUpperCase(this);
  }

}
