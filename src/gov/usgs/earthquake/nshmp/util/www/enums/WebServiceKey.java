package gov.usgs.earthquake.nshmp.util.www.enums;

/**
 * Common web service query keys.
 * 
 * @author Brandon Clayton
 */
public enum WebServiceKey implements EnumString {
  EDITION,
  REGION,
  VS30,
  LATITUDE,
  LONGITUDE,
  IMT,
  RETURNPERIOD,
  DISTANCE,
  FORMAT,
  TIMESPAN,
  Z1P0,
  Z2P5;
  
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
