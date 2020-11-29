package usantatecla;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class IntervalTest {
  
  private Point left;
  private Point right;
  private IntervalBuilder intervalBuilder;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
  }

  private Interval createInterval(double left, double right, IntervalType type){
    if(IntervalType.OPEN.equals(type)){
      return this.intervalBuilder.open(left).open(right).build();
    } else {
      return this.intervalBuilder.closed(left).closed(right).build();
    }
  }

  /*   Testing all combination
       (--)         |      (--) | [--]
            (**)    | (**)      |      (**)  ....
   */
  @Test
  public void givenIntervalsOneOnTheLeft_OtherOnTheRight_NotConnected_ShouldReturnFalseInAnyCombination(){
    List<Pair<Interval, Interval>> solutionCheckers = Arrays.asList(
          new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN),
                  this.createInterval(10.0, 20.0, IntervalType.OPEN)),
          new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.CLOSED),
                  this.createInterval(10.0, 20.0, IntervalType.CLOSED)),
          new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN),
                  this.createInterval(10.0, 20.0, IntervalType.CLOSED)),
          new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.CLOSED),
                  this.createInterval(10.0, 20.0, IntervalType.OPEN))
        );

      for(Pair<Interval, Interval> condition: solutionCheckers){
          assertThat( condition.getValue0().intersects(condition.getValue1()), is(Boolean.FALSE));
      }
  }

  /* Testing ------
        (--)  | [--]
        (**)  | [**]
   */
  @Test
  public void givenTheSameIntervals_ShouldReturnTrue(){
    List<Pair<Interval, Interval>> intervalPairLists = Arrays.asList(
            new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN),
                    this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN)),

            new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.CLOSED),
                    this.createInterval(left.getEquals(), right.getEquals(), IntervalType.CLOSED))
    );

    for(Pair<Interval, Interval> intervalPair: intervalPairLists){
        assertTrue(intervalPair.getValue0().intersects(intervalPair.getValue1()));
    }
  }

  @Test
  public void givenTheSameIntervalsButDifferentType_ShouldReturnTrue(){
    List<Pair<Interval, Interval>> intervalPairLists = Arrays.asList(
            new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.CLOSED),
                    this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN))
            ,
            new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN),
                    this.createInterval(left.getEquals(), right.getEquals(), IntervalType.CLOSED))
    );

    for(Pair<Interval, Interval> intervalPair: intervalPairLists){
      assertTrue(intervalPair.getValue0().intersects(intervalPair.getValue1()));
    }
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