package usantatecla;

public class ClosedMin extends Min {

  public ClosedMin(double value) {
    super(value);
  }

  @Override
  public boolean contains(double value) {
    return super.contains(value) || this.value == value;
  }

  @Override
	public String toString() {
		return "[" + this.value;
  }	
  
}
