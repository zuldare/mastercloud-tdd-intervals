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

  /*   Testing
       (----)
                (*****)
   */
  @Test
  public void givenIntervalsOneOnTheLeft_OtherOnTheRight_NotConnected_ShouldReturnFalse(){
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftOther = new Point(10.0);
    Point rightOther = new Point(20.0);

    Interval intervalOther = (new IntervalBuilder()).open(leftOther.getEquals()).open(rightOther.getEquals()).build();
    boolean result = interval.intersects(intervalOther);
    assertNotNull(result);
    assertFalse(result);
  }

  /* Testing
             (-----)
      (****)
   */
  @Test
  public void givenIntervalsOneOnTheRight_OtherOnTheLeft_NotConnected_ShouldReturnFalse(){
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Point leftOther = new Point(-20.0);
    Point rightOther = new Point(-10.0);
    Interval intervalOther = (new IntervalBuilder()).open(leftOther.getEquals()).open(rightOther.getEquals()).build();
    assertFalse(interval.intersects(intervalOther));
  }

  /* Testing ------
        (------)
        (******)
     Testing ------
        [------]
        [******]
   */
  @Test
  public void givenTheSameIntervals_ShouldReturnTrue(){
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    Interval intervalOther = (new IntervalBuilder()).open(left.getEquals()).open(right.getEquals()).build();
    boolean result = interval.intersects(intervalOther);
    assertTrue(result);
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