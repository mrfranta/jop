package cz.zcu.kiv.jop.factory.binding;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Basic implementation of {@link Binder} interface which contains map for all created bindings
 * (even if they wasn't finished by their builder). This implementation allows extension of
 * annotation type checking (for more complex conditions) by overriding of method
 * {@link #checkAnnotation}.
 *
 * @author Mr.FrAnTA
 * @since 1.0
 *
 * @param <T> Type of objects which can be bound for some annotation. It's strongly suggested to
 *          choose interface or abstract class as generic type.
 */
public class BinderImpl<T> implements Binder<T> {

  /**
   * Map of all created bindings. The map is used because of simpler getting of created binding
   * because each annotation can have only one binding.
   */
  protected final Map<Class<? extends Annotation>, Binding<T>> bindings;

  /**
   * Constructs a new binder.
   */
  public BinderImpl() {
    bindings = new HashMap<Class<? extends Annotation>, Binding<T>>();
  }

  /**
   * Check conditions for given annotation type. This method is mainly intended for extensions of
   * binder. This method check by default only whether the given annotation isn't <code>null</code>.
   * In overridden versions can be applied more complicated conditions.
   *
   * @param annotation the annotation type to check.
   * @throws BindingException if entered annotation isn't valid.
   */
  protected void checkAnnotation(Class<? extends Annotation> annotation) throws BindingException {
    if (annotation == null) {
      throw new BindingException("Annotation type cannot be null");
    }
  }

  /**
   * {@inheritDoc}
   */
  public BindingBuilder<T> bind(Class<? extends Annotation> annotation) throws BindingException {
    checkAnnotation(annotation);

    if (bindings.containsKey(annotation)) {
      throw new BindingException("Binding for annotation '" + annotation.getName() + "' already exists");
    }

    return prepareBindingBuilder(annotation);
  }

  /**
   * {@inheritDoc}
   */
  public BindingBuilder<T> rebind(Class<? extends Annotation> annotation) throws BindingException {
    checkAnnotation(annotation);

    // no presence checking here...

    return prepareBindingBuilder(annotation);
  }

  /**
   * Prepares binding builder for given annotation. Also adds binding which will be builded into map
   * of bindings.
   *
   * @param annotation the class type of annotation of which will be prepared binding builder.
   * @return Prepared binding builder.
   */
  protected BindingBuilder<T> prepareBindingBuilder(Class<? extends Annotation> annotation) {
    BindingBuilderImpl<T> bindingBuilder = new BindingBuilderImpl<T>(annotation);
    bindings.put(annotation, bindingBuilder.getBinding());

    return bindingBuilder;
  }

  /**
   * {@inheritDoc}
   */
  public Binding<T> getBinding(Class<? extends Annotation> annotation) throws BindingException {
    checkAnnotation(annotation);

    Binding<T> binding = bindings.get(annotation);
    if (binding == null) {
      throw new BindingException("No binding found for annotation '" + annotation.getName() + "'");
    }

    return binding;
  }

  /**
   * {@inheritDoc}
   */
  public List<Binding<T>> getBindings() {
    return new ArrayList<Binding<T>>(bindings.values());
  }

}
