package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClosedMaxTest extends MaxTest {

  @Override
  protected Max createMax() {
    return new ClosedMax(this.point.getEquals());
  }

  @Test
  @Override
  public void givenMaxWhenContainsWithEqualsValue(){
    assertTrue(this.max.contains(this.point.getEquals()));
  }
  
}
