package telran.measure;

public enum LengthUnit {

	MM(1f), CM(10f), IN(25.4f), FT(304.8f), M(1000f), KM(1000000f);
	
	float value;
	
	private LengthUnit(float value) {
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}
	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return Length object with amount of the LengthUnit
	 * LengthUnit.M.between (new Length(200f, LengthUnit.CM), new Length(1f, LengthUnit.M)) -> Length(1, LengthUnit.M)
	 */
	public Length between(Length l1, Length l2) {
		float l1AmountInMM = (l1.getAmount() * l1.getUnit().value);
		float l2AmountInMM = (l2.getAmount() * l2.getUnit().value);
		float resAmount = l1AmountInMM - l2AmountInMM;
		float thisValue = getValue();
		resAmount = Math.abs(resAmount / thisValue);
		return new Length(resAmount, this);
	}
}