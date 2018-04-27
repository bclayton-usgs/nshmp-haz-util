package gov.usgs.earthquake.nshmp.util.www.enums;

import java.util.Set;

/**
 * Container for {@code Enum}s.
 * 
 * @author Brandon Clayton
 * @param <E>
 */
public final class EnumParameter<E extends Enum<E>> {

  public final String label;
  public final ParamType type;
  public final Set<E> values;
  
  public EnumParameter(String label, ParamType type, Set<E> values) {
    this.label = label;
    this.type = type;
    this.values = values;
  }
  
}
