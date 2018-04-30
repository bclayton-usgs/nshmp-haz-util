package gov.usgs.earthquake.nshmp.util.www;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import gov.usgs.earthquake.nshmp.util.www.enums.ParamType;

/**
 * Static classes for common Gson {@code TypeAdapter}.
 * 
 * @author Peter Powers
 */
public class GsonTypeAdapter {

  /** Constrain all doubles to 8 decimal places */
  public static final class DoubleSerializer implements JsonSerializer<Double> {
    @Override
    public JsonElement serialize(
        Double d, 
        Type type, 
        JsonSerializationContext context) {
      double dOut = Double.valueOf(String.format("%.8g", d));
      return new JsonPrimitive(dOut);
    }
  }

  /** Serialize param type enum as lowercase */
  public static class ParamTypeSerializer implements JsonSerializer<ParamType> {
    @Override
    public JsonElement serialize(
        ParamType paramType, 
        Type type, 
        JsonSerializationContext context) {
      return new JsonPrimitive(paramType.toLowerCase());
    }
  }

}
