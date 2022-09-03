package telran.measure;

public class Length implements Comparable<Length> {
	
	private final float amount;
	private final LengthUnit unit;
	
	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	@Override
	/**
	 * equals two Length objects according to LengthUnit
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		return getAmountInMM((Length)obj) == getAmountInMM(this);
	}

	@Override
	public int compareTo(Length o) {
		float oAmountInMM = getAmountInMM(o);
		float thisAmountInMM = getAmountInMM(this);
		return oAmountInMM == thisAmountInMM 
				? 0 : oAmountInMM < thisAmountInMM
				? 1 : -1;
	}
	/**
	 * t b
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit unit) {
		return new Length(getAmountInMM(this) / unit.value, unit);
	}
	@Override 
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		return new String((int)amount + unit.name());
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

	private float getAmountInMM(Length o) {
		return o.getAmount() * o.getUnit().value;
	}

}