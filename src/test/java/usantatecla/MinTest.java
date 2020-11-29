package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinTest {
  
  protected Min min;
  protected Point point;

  @BeforeEach
  public void before(){
    this.point = new Point(4.4);
    this.min = this.createMin();
  }

  protected Min createMin() {
    return new Min(this.point.getEquals());
  }

  @Test
  public void givenMinWhenContainsWithLessValueThenTrue(){
    assertFalse(this.min.contains(this.point.getLess()));
  }

  @Test
  public void givenMinWhenContainsWithEqualsValue(){
    assertFalse(this.min.contains(this.point.getEquals()));
  }

  @Test
  public void givenMinWhenContainsWithGreaterValueThenTrue(){
    assertTrue(this.min.contains(this.point.getGreater()));
  }
 
}

