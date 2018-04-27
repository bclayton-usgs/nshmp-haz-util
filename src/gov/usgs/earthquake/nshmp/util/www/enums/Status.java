package gov.usgs.earthquake.nshmp.util.www.enums;

/**
 * Identifiers for different web service return types:
 *    <ul> 
 *      <li> Error </li>
 *      <li> Success </li>
 *      <li> Usage </li>
 *    </ul>
 *    
 * @author Brandon Clayton
 */
public enum Status implements EnumString {
  ERROR,
  SUCCESS,
  USAGE;
  
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
