package cz.zcu.kiv.jop.generator;

import cz.zcu.kiv.jop.JopException;

/**
 * exception which can be thrown if some error occurs during value generation. Also can be thrown in
 * case of value of some parameter is not valid. It's recommended to not throw another exception
 * from {@link ValueGenerator#getValue generating method}.
 *
 * @author Mr.FrAnTA
 * @since 1.0.0
 */
public class ValueGeneratorException extends JopException {

  /**
   * Determines if a de-serialized file is compatible with this class.
   * <p>
   * Maintainers must change this value if and only if the new version of this class is not
   * compatible with old versions. See Oracle docs for <a
   * href="http://docs.oracle.com/javase/1.5.0/docs/guide/serialization/">details</a>.
   * <p>
   * Not necessary to include in first version of the class, but included here as a reminder of its
   * importance.
   */
  private static final long serialVersionUID = 20160205L;

  /**
   * Constructs a new exception for value generator with <code>null</code> as its detail message.
   * The cause is not initialized, and may subsequently be initialized by a call to
   * {@link #initCause}.
   */
  public ValueGeneratorException() {
    super();
  }

  /**
   * Constructs a new exception for value generator with the specified detail message. The cause is
   * not initialized, and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the
   *          {@link #getMessage()} method.
   */
  public ValueGeneratorException(String message) {
    super(message);
  }

  /**
   * Constructs a new exception for value generator with the specified cause and <code>null</code>
   * as its detail message. This constructor is different to parent
   * {@link Exception#Exception(Throwable) constructor} which sets detail message as message from
   * cause. This constructor brings possibility to use {@link #getDefaultMessage} instead.
   *
   * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
   *          (A <tt>null</tt> value is permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   */
  public ValueGeneratorException(Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a new exception for value generator with the specified detail message and cause.
   * <p>
   * Note that the detail message associated with <code>cause</code> is <i>not</i> automatically
   * incorporated in this exception's detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the
   *          {@link #getMessage()} method).
   * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
   *          (A <tt>null</tt> value is permitted, and indicates that the cause is nonexistent or
   *          unknown.)
   */
  public ValueGeneratorException(String message, Throwable cause) {
    super(message, cause);
  }

}
