package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  private IntervalBuilder intervalBuilder;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
  }

  @Test
  public void testIntersects(){
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftOther = new Point(10.0);
    Point rightOther = new Point(20.0);

    Interval intervalOther = (new IntervalBuilder()).open(leftOther.getEquals()).open(rightOther.getEquals()).build();
    assertNotNull(interval.intersects(intervalOther));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.contains(left.getLess()));
    assertFalse(interval.contains(left.getEquals()));
    assertTrue(interval.contains(left.getGreater()));
    assertTrue(interval.contains(right.getLess()));
    assertFalse(interval.contains(right.getEquals()));
    assertFalse(interval.contains(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.contains(left.getLess()));
    assertTrue(interval.contains(left.getEquals()));
    assertTrue(interval.contains(left.getGreater()));

    assertTrue(interval.contains(right.getLess()));
    assertFalse(interval.contains(right.getEquals()));
    assertFalse(interval.contains(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.contains(left.getLess()));
    assertFalse(interval.contains(left.getEquals()));
    assertTrue(interval.contains(left.getGreater()));

    assertTrue(interval.contains(right.getLess()));
    assertTrue(interval.contains(right.getEquals()));
    assertFalse(interval.contains(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.contains(left.getLess()));
    assertTrue(interval.contains(left.getEquals()));
    assertTrue(interval.contains(left.getGreater()));

    assertTrue(interval.contains(right.getLess()));
    assertTrue(interval.contains(right.getEquals()));
    assertFalse(interval.contains(right.getGreater()));
  }

}