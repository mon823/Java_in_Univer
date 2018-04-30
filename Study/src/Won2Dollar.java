
public class Won2Dollar extends Converter {
	public Won2Dollar() {
		ratio = 1200;
	}
	
	public Won2Dollar(double ratio) {
		this.ratio = ratio;
	}
	
	@Override
	public String getSrcString() {
		return "won";
	}
	
	@Override
	public String getDestString() {
		return "dollar";
	}
	
	@Override
	public double convert(double src) {
		return src/ratio;
	}

}
