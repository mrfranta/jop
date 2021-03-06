package cz.zcu.kiv.jop.class_provider;

import javax.inject.Singleton;

import cz.zcu.kiv.jop.annotation.class_provider.TargetClass;
import cz.zcu.kiv.jop.generator.ValueGeneratorException;
import cz.zcu.kiv.jop.generator.clazz.TargetClassGenerator;

/**
 * Implementation of class provider for annotation {@link TargetClass} which uses
 * {@link TargetClassGenerator} for providing classes.
 *
 * @author Mr.FrAnTA
 * @since 1.0.0
 */
@Singleton
public class TargetClassProvider extends TargetClassGenerator implements ClassProvider<TargetClass> {

  /**
   * This method provides the class type generated by method {@link #getValue} of random class
   * generator.
   *
   * @param params parameters of class provider.
   * @return Class type generated by random class generator.
   * @throws ClassProviderException If generating of provided class by random class generator throws
   *           exception because of incorrect parameters or because of some problem during
   *           generating.
   */
  public Class<?> get(TargetClass params) throws ClassProviderException {
    try {
      return getValue(params);
    }
    catch (ValueGeneratorException exc) {
      throw new ClassProviderException(exc.getMessage());
    }
  }
}
