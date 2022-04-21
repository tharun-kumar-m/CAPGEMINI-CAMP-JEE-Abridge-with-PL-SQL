package q30;

public class Stocks {
	public float stockRate;

	public Stocks(float stockRate) {
		this.stockRate = stockRate;
	}
	public String checkRate(float Rate) throws Exception{
		float tot=Rate*100/stockRate;
		if(tot==80.0f)
			return "Hope to raise";
		else if(tot<80.0f)
			throw new StockLowException("Under Loss");
		else
			throw new StockHighException("Under Profit");
	}

	public static void main(String[] args) {
		Stocks stock = new Stocks(10.0f);
		try {
			System.out.println(stock.checkRate(5.0f));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

@SuppressWarnings("serial")
class StockLowException extends Exception{
	public StockLowException(String s) {
		super(s);
	}
}
@SuppressWarnings("serial")
class StockHighException extends Exception{
	public StockHighException(String s){
		super(s);
	}
}