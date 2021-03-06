package cz.zcu.kiv.jop.annotation;

import java.lang.annotation.Annotation;

/**
 * Helper "implementation" of annotation {@link Foo} which may be used for manual creation of
 * annotation instance.
 *
 * @author Mr.FrAnTA
 */
public class FooImpl implements Foo {

  /** Annotation value. */
  private final int value;

  /**
   * Constructs annotation.
   *
   * @param value value of annotation.
   */
  public FooImpl(int value) {
    this.value = value;
  }

  /**
   * Returns type of annotation (this class).
   *
   * @return type of annotation.
   */
  public Class<? extends Annotation> annotationType() {
    return getClass();
  }

  /**
   * @return Value of annotation.
   */
  public int value() {
    return value;
  }
}
