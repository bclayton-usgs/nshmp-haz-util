package gov.usgs.earthquake.nshmp.util.www.enums;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * Delimiter identifiers, each of which can provide a {@link Joiner} and
 * {@link Splitter}.
 * 
 * @author Peter Powers
 */
public enum Delimiter {

  /** Colon (':') delimiter. */
  COLON(':'),

  /** Comma (',') delimiter. */
  COMMA(','),

  /** Dash ('-') delimiter. */
  DASH('-'),

  /** Period ('.') delimiter. */
  PERIOD('.'),

  /** Forward-slash ('/') delimiter. */
  SLASH('/'),

  /**
   * Whitespace (' ') delimiter.
   * @see CharMatcher#WHITESPACE
   */
  SPACE(' ', CharMatcher.whitespace()),

  /** Underscore ('_') delimiter. */
  UNDERSCORE('_');

  private Joiner joiner;
  private Splitter splitter;

  private Delimiter(char separator) {
    joiner = Joiner.on(separator).skipNulls();
    splitter = Splitter.on(separator).omitEmptyStrings().trimResults();
  }

  private Delimiter(char joinSeparator, CharMatcher splitMatcher) {
    joiner = Joiner.on(joinSeparator).skipNulls();
    splitter = Splitter.on(splitMatcher).omitEmptyStrings().trimResults();
  }

  /**
   * Returns a null-skipping {@link Joiner} on this {@code Delimiter}.
   * @see Joiner#skipNulls()
   */
  public Joiner joiner() {
    return joiner;
  }

  /**
   * Returns an empty-string-omitting and result-trimming {@link Splitter} on
   * this {@code Delimiter}.
   *
   * @see Splitter#omitEmptyStrings()
   * @see Splitter#trimResults()
   */
  public Splitter splitter() {
    return splitter;
  }
}
