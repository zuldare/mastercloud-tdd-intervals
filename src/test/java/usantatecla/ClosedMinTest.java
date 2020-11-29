package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClosedMinTest extends MinTest {

  @Override
  protected Min createMin() {
    return new ClosedMin(this.point.getEquals());
  }

  @Test
  @Override
  public void givenMinWhenContainsWithEqualsValue(){
    assertTrue(this.min.contains(this.point.getEquals()));
  }
  
}
