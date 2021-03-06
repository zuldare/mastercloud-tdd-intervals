package usantatecla;

public class Interval {

	private Min min;
	private Max max;

	public Interval(Min min, Max max) {
		assert min.value <= max.value;
		this.min = min;
		this.max = max;
	}

	public boolean intersects(Interval other) {
		assert other != null;
		if (other.contains(this.min.value) || other.contains(this.max.value))
			return true;

		if (this.hasSameLimits(other))
			return true;

		if (this.limitsAreContained(other))
		   	return true;

		return false;
	}

	private boolean limitsAreContained(Interval other){
		return this.contains(other.min.value) || other.contains(this.min.value) ||
			   this.contains(other.max.value) || other.contains(this.min.value);
	}

	private boolean hasSameLimits(Interval other){
		return this.min.equals(other.min) || this.max.equals(other.max);
	}

	public boolean contains(double value) {
			return this.min.contains(value) && this.max.contains(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((max == null) ? 0 : max.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (max == null) {
			if (other.max != null)
				return false;
		} else if (!max.equals(other.max))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		return true;
	}

	public Object intersectsWithChainOfResponsibility(Interval value1) {
		return null;
	}


	@Override
	public String toString() {
		return this.min.toString() + ", " + max.toString();
	}


}