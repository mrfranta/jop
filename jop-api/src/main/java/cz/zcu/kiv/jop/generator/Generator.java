package cz.zcu.kiv.jop.generator;

import java.lang.annotation.Annotation;

/**
 * The common interface for all generators of values for populated properties.
 * The interface is generic where first type parameter is for class type of
 * generated values. Second parameter is for annotation type of parameters for
 * generator. The parameters for {@link #getValue method} which generates the
 * value is always stored in annotation (by which is annotated the field for
 * which will be generated value).
 *
 * @author Mr.FrAnTA
 * @since 1.0
 *
 * @param <T> Type of generated values.
 * @param <P> Annotation type of generator parameters.
 */
public interface Generator<T, P extends Annotation> {

  /**
   * Returns class type of values generated by this generator.
   *
   * @return Class type of generated values.
   */
  public Class<T> getValueType();

  /**
   * Returns generated value according to given parameters.
   *
   * @param params the parameters for generation of value.
   * @return Generated value.
   * @throws GeneratorException if some error occurs during value generation or
   *           if given parameters are not valid.
   */
  public T getValue(P params) throws GeneratorException;

}