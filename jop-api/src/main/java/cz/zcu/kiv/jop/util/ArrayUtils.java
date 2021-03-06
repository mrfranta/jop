package cz.zcu.kiv.jop.util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cz.zcu.kiv.jop.JopRuntimeException;

/**
 * Helper static class for operations with arrays.
 *
 * @author Mr.FrAnTA
 * @since 1.0.0
 */
public abstract class ArrayUtils {

  /** Logger used for logging. */
  private static final Log logger = LogFactory.getLog(ArrayUtils.class);

  /** Constant for empty array of {@code boolean}. */
  public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
  /** Constant for empty array of {@code Boolean}. */
  public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];

  /** Constant for empty array of {@code byte}. */
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  /** Constant for empty array of {@code Byte}. */
  public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];

  /** Constant for empty array of {@code char}. */
  public static final char[] EMPTY_CHAR_ARRAY = new char[0];
  /** Constant for empty array of {@code Character}. */
  public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

  /** Constant for empty array of {@code short}. */
  public static final short[] EMPTY_SHORT_ARRAY = new short[0];
  /** Constant for empty array of {@code Short}. */
  public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];

  /** Constant for empty array of {@code int}. */
  public static final int[] EMPTY_INT_ARRAY = new int[0];
  /** Constant for empty array of {@code Integer}. */
  public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];

  /** Constant for empty array of {@code long}. */
  public static final long[] EMPTY_LONG_ARRAY = new long[0];
  /** Constant for empty array of {@code Long}. */
  public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];

  /** Constant for empty array of {@code float}. */
  public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
  /** Constant for empty array of {@code Float}. */
  public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];

  /** Constant for empty array of {@code double}. */
  public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
  /** Constant for empty array of {@code Double}. */
  public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];

  /**
   * Private constructor in combination with abstract modifier of this class makes it static.
   */
  private ArrayUtils() {}

  /**
   * Copies given array of primitive boolean values into array of Booleans. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>boolean</code> values.
   * @return The array of {@link Boolean} values or <code>null</code>.
   */
  public static Boolean[] toObjectArray(boolean[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_BOOLEAN_OBJECT_ARRAY;
    }

    Boolean[] retArray = new Boolean[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Boolean(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Boolean} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>false</code> values instead.
   *
   * @param array the array of {@link Boolean} values.
   * @return The array of <code>boolean</code> values or <code>null</code>.
   */
  public static boolean[] toPrimitiveArray(Boolean[] array) {
    return toPrimitiveArray(array, false);
  }

  /**
   * Copies given array of {@link Boolean} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Boolean} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>boolean</code> values or <code>null</code>.
   */
  public static boolean[] toPrimitiveArray(Boolean[] array, boolean valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_BOOLEAN_ARRAY;
    }

    boolean[] retArray = new boolean[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].booleanValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive byte values into array of Bytes. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>byte</code> values.
   * @return The array of {@link Byte} values or <code>null</code>.
   */
  public static Byte[] toObjectArray(byte[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_BYTE_OBJECT_ARRAY;
    }

    Byte[] retArray = new Byte[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Byte(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Byte} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0</code> values instead.
   *
   * @param array the array of {@link Byte} values.
   * @return The array of <code>byte</code> values or <code>null</code>.
   */
  public static byte[] toPrimitiveArray(Byte[] array) {
    return toPrimitiveArray(array, (byte)0);
  }

  /**
   * Copies given array of {@link Byte} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Byte} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>byte</code> values or <code>null</code>.
   */
  public static byte[] toPrimitiveArray(Byte[] array, byte valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_BYTE_ARRAY;
    }

    byte[] retArray = new byte[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].byteValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive char values into array of Characters. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>char</code> values.
   * @return The array of {@link Character} values or <code>null</code>.
   */
  public static Character[] toObjectArray(char[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_CHARACTER_OBJECT_ARRAY;
    }

    Character[] retArray = new Character[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Character(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Character} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0</code> values instead.
   *
   * @param array the array of {@link Character} values.
   * @return The array of <code>char</code> values or <code>null</code>.
   */
  public static char[] toPrimitiveArray(Character[] array) {
    return toPrimitiveArray(array, (char)0);
  }

  /**
   * Copies given array of {@link Character} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Character} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>char</code> values or <code>null</code>.
   */
  public static char[] toPrimitiveArray(Character[] array, char valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_CHAR_ARRAY;
    }

    char[] retArray = new char[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].charValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive short values into array of Shorts. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>short</code> values.
   * @return The array of {@link Short} values or <code>null</code>.
   */
  public static Short[] toObjectArray(short[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_SHORT_OBJECT_ARRAY;
    }

    Short[] retArray = new Short[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Short(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Short} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0</code> values instead.
   *
   * @param array the array of {@link Short} values.
   * @return The array of <code>short</code> values or <code>null</code>.
   */
  public static short[] toPrimitiveArray(Short[] array) {
    return toPrimitiveArray(array, (short)0);
  }

  /**
   * Copies given array of {@link Short} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Short} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>short</code> values or <code>null</code>.
   */
  public static short[] toPrimitiveArray(Short[] array, short valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_SHORT_ARRAY;
    }

    short[] retArray = new short[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].shortValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive int values into array of Integers. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>int</code> values.
   * @return The array of {@link Integer} values or <code>null</code>.
   */
  public static Integer[] toObjectArray(int[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_INTEGER_OBJECT_ARRAY;
    }

    Integer[] retArray = new Integer[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Integer(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Integer} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0</code> values instead.
   *
   * @param array the array of {@link Integer} values.
   * @return The array of <code>int</code> values or <code>null</code>.
   */
  public static int[] toPrimitiveArray(Integer[] array) {
    return toPrimitiveArray(array, 0);
  }

  /**
   * Copies given array of {@link Integer} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Integer} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>int</code> values or <code>null</code>.
   */
  public static int[] toPrimitiveArray(Integer[] array, int valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_INT_ARRAY;
    }

    int[] retArray = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].intValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive long values into array of Longs. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>long</code> values.
   * @return The array of {@link Long} values or <code>null</code>.
   */
  public static Long[] toObjectArray(long[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_LONG_OBJECT_ARRAY;
    }

    Long[] retArray = new Long[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Long(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Long} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0</code> values instead.
   *
   * @param array the array of {@link Long} values.
   * @return The array of <code>long</code> values or <code>null</code>.
   */
  public static long[] toPrimitiveArray(Long[] array) {
    return toPrimitiveArray(array, 0L);
  }

  /**
   * Copies given array of {@link Long} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Long} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>long</code> values or <code>null</code>.
   */
  public static long[] toPrimitiveArray(Long[] array, long valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_LONG_ARRAY;
    }

    long[] retArray = new long[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].longValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive float values into array of Floats. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>float</code> values.
   * @return The array of {@link Float} values or <code>null</code>.
   */
  public static Float[] toObjectArray(float[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_FLOAT_OBJECT_ARRAY;
    }

    Float[] retArray = new Float[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Float(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Float} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0.0</code> values instead.
   *
   * @param array the array of {@link Float} values.
   * @return The array of <code>float</code> values or <code>null</code>.
   */
  public static float[] toPrimitiveArray(Float[] array) {
    return toPrimitiveArray(array, 0f);
  }

  /**
   * Copies given array of {@link Float} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Float} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>float</code> values or <code>null</code>.
   */
  public static float[] toPrimitiveArray(Float[] array, float valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_FLOAT_ARRAY;
    }

    float[] retArray = new float[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].floatValue();
    }

    return retArray;
  }

  /**
   * Copies given array of primitive double values into array of Doubles. This method returns
   * <code>null</code> for given <code>null</code> value.
   *
   * @param array the array of <code>double</code> values.
   * @return The array of {@link Double} values or <code>null</code>.
   */
  public static Double[] toObjectArray(double[] array) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_DOUBLE_OBJECT_ARRAY;
    }

    Double[] retArray = new Double[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = new Double(array[i]);
    }

    return retArray;
  }

  /**
   * Copies given array of {@link Double} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put <code>0.0</code> values instead.
   *
   * @param array the array of {@link Double} values.
   * @return The array of <code>double</code> values or <code>null</code>.
   */
  public static double[] toPrimitiveArray(Double[] array) {
    return toPrimitiveArray(array, 0d);
  }

  /**
   * Copies given array of {@link Double} values into array of primitives. This method returns
   * <code>null</code> for given <code>null</code> value. If some value is <code>null</code>, it
   * will put given <code>valueForNull</code> values instead.
   *
   * @param array the array of {@link Double} values.
   * @param valueForNull the default value for <code>null</code> values.
   * @return The array of <code>double</code> values or <code>null</code>.
   */
  public static double[] toPrimitiveArray(Double[] array, double valueForNull) {
    if (array == null) {
      return null;
    }

    if (array.length == 0) {
      return EMPTY_DOUBLE_ARRAY;
    }

    double[] retArray = new double[array.length];
    for (int i = 0; i < array.length; i++) {
      retArray[i] = (array[i] == null) ? valueForNull : array[i].doubleValue();
    }

    return retArray;
  }

  /**
   * Generic method which copies given array of primitive values into array of objects. This method
   * returns <code>null</code> for given <code>null</code> value and original array for given array
   * of object values. The multidimensional array is not supported.
   *
   * @param array the array of values.
   * @return The array of object values or <code>null</code>.
   * @throws IllegalArgumentException If given object is not array or if given object is
   *           multidimensional array.
   */
  public static Object[] toObjectArray(Object array) {
    if (array == null) {
      return null;
    }

    // get class type of argument
    Class<?> clazz = array.getClass();
    Preconditions.checkArgument(clazz.isArray(), "Given object is not array");

    // get length of array
    int length = Array.getLength(array);

    // prepare class type of array members
    Class<?> componentType = clazz.getComponentType();

    // check whatever the array is multidimensional
    if (componentType.isArray()) {
      throw new IllegalArgumentException("Multidimensional array is not supported");
    }

    // check whatever the array is array of primitives
    if (!componentType.isPrimitive()) {
      // return original argument
      return (Object[])array;
    }

    // prepare Object variant of component type
    Class<?> componentObjectType = PrimitiveUtils.wrap(componentType);

    // prepare array
    Object[] primitiveArray = (Object[])Array.newInstance(componentObjectType, length);
    for (int i = 0; i < length; i++) {
      // autoboxing using constructors with primitive argument
      Object value = Array.get(array, i);
      try {
        Constructor<?> construct = componentObjectType.getConstructor(componentType);
        primitiveArray[i] = construct.newInstance(value);
      }
      catch (Exception exc) {
        // this should not happen
        logger.error("Cannot autobox value: " + value + " into " + componentObjectType.getName());
        primitiveArray[i] = null;
      }
    }

    return primitiveArray;
  }

  /**
   * Copies given one dimensional array of wrapper instances into array of primitives. This method
   * returns <code>null</code> for given <code>null</code> value. If given array object is already
   * array of primitives, it returns the same array. If some value is <code>null</code>, it will put
   * default value instead.
   *
   * @param array the array object to copy.
   * @return The array of primitive values.
   * @throws IllegalArgumentException If given object is not array, is multidimensional, is array of
   *           Voids or is not array of wrappers.
   * @throws JopRuntimeException If copying (boxing) of given array object fails.
   */
  public static Object toPrimitiveArray(Object array) {
    if (array == null) {
      return null;
    }

    Class<?> objType = array.getClass();
    if (!objType.isArray()) {
      throw new IllegalArgumentException("Given object has to be array");
    }

    if (objType.getComponentType().isPrimitive()) {
      return array;
    }

    Class<?> compType = objType.getComponentType();
    if (compType.isArray()) {
      throw new IllegalArgumentException("Multidimensional array is not supported");
    }

    if (Void.class.equals(compType)) {
      throw new IllegalArgumentException("Array of Voids is not supported");
    }

    if (!PrimitiveUtils.isWrapper(compType)) {
      throw new IllegalArgumentException("Given array has to be array of wrapper classes");
    }

    Method toPrimitiveArray = ReflectionUtils.getMethod(ArrayUtils.class, "toPrimitiveArray", objType);
    if (toPrimitiveArray == null) {
      throw new IllegalArgumentException("Unsupported array type: " + compType.getName());
    }

    try {
      return toPrimitiveArray.invoke(null, array);
    }
    catch (Exception exc) {
      // should not happen
      throw new JopRuntimeException("Transformation to primitive type failed for array type: " + compType.getName(), exc);
    }
  }

  /**
   * Clones given array object. The array object may be multidimensional.
   *
   * @param array the array object to clone.
   * @return Clone of given array object.
   */
  public static Object cloneArray(Object array) {
    if (array == null) {
      return null;
    }

    Class<?> objType = array.getClass();
    if (!objType.isArray()) {
      throw new IllegalArgumentException("Given object has to be array");
    }

    Class<?> compType = objType.getComponentType();
    int len = Array.getLength(array);
    Object clone = Array.newInstance(compType, len);
    if (compType.isArray()) { // multidimensional array support
      for (int i = 0; i < len; i++) {
        Array.set(clone, i, cloneArray(Array.get(array, i)));
      }
    }
    else {
      System.arraycopy(array, 0, clone, 0, len);
    }

    return clone;
  }

  /**
   * The method for generic calculation of hash code for given array object. The array object may be
   * multidimensional. This method is supported for the benefit of hash tables such as those
   * provided by {@link java.util.HashMap}.
   *
   * @param array the array object for which will be returned hash code.
   * @return A hash code value for given array object.
   */
  public static int hashCode(Object array) {
    if (array == null) {
      return 0;
    }

    Class<?> objType = array.getClass();
    if (!objType.isArray()) {
      throw new IllegalArgumentException("Given object has to be array");
    }

    int result = 1;

    Class<?> compType = objType.getComponentType();
    int len = Array.getLength(array);
    for (int i = 0; i < len; i++) {
      int elementHash = 0;
      Object value = Array.get(array, i);
      if (value != null) {
        if (!compType.isArray()) {
          elementHash = value.hashCode();
        }
        else {// multidimensional array
          elementHash = hashCode(value);
        }
      }

      result = 31 * result + elementHash;
    }

    return result;
  }

  /**
   * The method for generic checking of equality of two arrays given as object parameters. The
   * arrays may be multidimensional.
   *
   * @param array1 the first array to check.
   * @param array2 the second array to check.
   * @return <code>true</code> if given array objects are equals; <code>false</code> otherwise.
   */
  public static boolean equals(Object array1, Object array2) {
    if (array1 == null || array2 == null) {
      return false;
    }

    // check whatever both arguments are arrays
    if (!array1.getClass().isArray() || !array2.getClass().isArray()) {
      return false;
    }

    // check equality
    if (array1 == array2) {
      return true;
    }

    // check length
    int len = Array.getLength(array1);
    if (len != Array.getLength(array2)) {
      return false;
    }

    // supports boxing
    for (int i = 0; i < len; i++) {
      Object value1 = Array.get(array1, i);
      Object value2 = Array.get(array2, i);
      if (value1 == null) {
        if (value2 != null) {
          return false;
        }
        continue;
      }
      else if (value2 == null) {
        return false;
      }

      // multidimensional array
      if (value1.getClass().isArray()) {
        if (!equals(value1, value2)) {
          return false;
        }
        continue;
      }

      if (!value1.equals(value2)) {
        return false;
      }
    }

    return true;
  }
}
