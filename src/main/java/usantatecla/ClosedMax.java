package usantatecla;

public class ClosedMax extends Max {

  public ClosedMax(double value) {
    super(value);
  }

  @Override
  public boolean contains(double value) {
    return super.contains(value) || this.value == value;
  }

  @Override
	public String toString() {
		return this.value + "]";
	}	

}
