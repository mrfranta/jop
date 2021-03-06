package cz.zcu.kiv.jop.generator.clazz;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.zcu.kiv.jop.annotation.class_provider.TargetClassImpl;
import cz.zcu.kiv.jop.generator.ValueGeneratorException;

/**
 * Test of class {@link TargetClassGenerator}.
 *
 * @author Mr.FrAnTA
 */
public class TargetClassGeneratorTest {

  /** Tested class generator. */
  private static TargetClassGenerator targetClassGenerator;

  /**
   * Prepares tested class generator. It may be static because it doesn't have state.
   */
  @BeforeClass
  public static void setUpBeforeClass() {
    targetClassGenerator = new TargetClassGenerator();
  }

  /**
   * Clears tested class generator.
   */
  @AfterClass
  public static void tearDownAfterClass() {
    targetClassGenerator = null;
  }

  /**
   * Test of method {@link TargetClassGenerator#getValueType()} which has to return class of class
   * type.
   */
  @Test
  public void testGetValueType() {
    Assert.assertEquals(Class.class, targetClassGenerator.getValueType());
  }

  /**
   * Test of method {@link TargetClassGenerator#getValue} for given null value. Expected
   * {@link ValueGeneratorException}.
   */
  @Test(expected = ValueGeneratorException.class)
  public void testGetValueForNull() throws ValueGeneratorException {
    targetClassGenerator.getValue(null);
  }

  /**
   * Test of method {@link TargetClassGenerator#getValue} for given annotation with null value.
   * Expected {@link ValueGeneratorException}.
   */
  @Test(expected = ValueGeneratorException.class)
  public void testGetValueForNullValue() throws ValueGeneratorException {
    targetClassGenerator.getValue(new TargetClassImpl(null));
  }

  /**
   * Test of method {@link TargetClassGenerator#getValue} for given annotation with class value
   * which will be returned.
   */
  @Test
  public void testGetValue() throws ValueGeneratorException {
    Assert.assertEquals(Integer.class, targetClassGenerator.getValue(new TargetClassImpl(Integer.class)));
  }

}
