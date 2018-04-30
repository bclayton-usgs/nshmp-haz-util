package gov.usgs.earthquake.nshmp.util.www;

import com.google.common.base.Throwables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gov.usgs.earthquake.nshmp.util.www.enums.Status;

/**
 * Static factory method {@link #errorMessage(String, Throwable, boolean)} 
 *    for web service error handling.
 *     
 * @author Peter Powers and Brandon Clayton
 */
public class ServiceError {
  private static final Gson GSON;
 
  /** The web service status: error */
  final String status;
  /** The {@code String} request url */
  final String request;
  /** The error message */
  final String message;
  
  static {
    GSON = new GsonBuilder()
        .serializeNulls()
        .disableHtmlEscaping()
        .setPrettyPrinting()
        .create();
  }
 
  /**
   * Create a new instance of {@code ServiceError}.
   * 
   * @param request Request url.
   * @param e The {@code Throwable} error.
   * @param trace Whether to print stack in message.
   */
  private ServiceError(String request, Throwable e, boolean trace) {
    this.status = Status.ERROR.toLowerCase();
    this.request = request;
    String message = e.getMessage() + " (see logs)";
    if (trace) {
      message += "\n" + Throwables.getStackTraceAsString(e);
    }
    this.message = message;
  }
  
  /**
   * Return a JSON formatted {@code String} describing the 
   *    {@code Throwable} error. 
   * <br><br>
   * 
   * Example:
   * <pre>
   * String url = "request_url";
   * try {
   *   something ...
   * } catch (Exception e) {
   *   String message = errorMessage(url, e, false);
   *   response.getWriter().print(message);
   * }
   * </pre>   
   * 
   * @param url The request url {@code String}.
   * @param e The {@code Throwable} error.
   * @param trace Whether to print stack.
   * @return A JSON formatted {@code String} describing the error.
   */
  public static String errorMessage(String url, Throwable e, boolean trace) {
    ServiceError error = new ServiceError(url, e, trace);
    return GSON.toJson(error);
  }

}
