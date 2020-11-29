package usantatecla;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntervalIntersectsChainOfResponsibilityTest {
  
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

  @Test
  public void testChainOfResponsibility(){
    Pair<Interval, Interval> intervals = new Pair<>(this.createInterval(left.getEquals(), right.getEquals(), IntervalType.OPEN),
                    this.createInterval(10.0, 20.0, IntervalType.OPEN));

    intervals.getValue0().intersectsWithChainOfResponsibility(intervals.getValue1());
  }
}