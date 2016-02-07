package cz.zcu.kiv.jop.strategy;

import cz.zcu.kiv.jop.property.Property;
import cz.zcu.kiv.jop.queue.PopulatorQueue;

/**
 * The common interface for all populating strategies for properties. The strategy is applied to
 * some property and it may populate some value into that property or enqueue class into populator
 * queue to populate. Strategies can be used in combination with class providers or instance
 * matchers.
 *
 * @author Mr.FrAnTA
 * @since 1.0.0
 */
public interface PopulatingStrategy {

  /**
   * Applies populating strategy to given property. It may populate some value into property or
   * enqueue class into populator queue to populate.
   *
   * @param property the property on which will be applied this populating strategy.
   * @param queue the holder of already generated objects for possibility to get already generated
   *          instances or check whatever can be enqueued new object to generate.
   * @throws PopulatingStrategyException if some error occurs during applying of populating strategy
   *           to given property.
   */
  public void applyStrategy(Property<?> property, PopulatorQueue queue) throws PopulatingStrategyException;

}