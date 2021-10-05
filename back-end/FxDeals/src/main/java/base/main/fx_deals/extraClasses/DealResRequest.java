package base.main.fx_deals.extraClasses;

public class DealResRequest {

	public Integer user_id;
	public Integer from_currency;
	public Integer to_currency;
	public Double amount;
	public String username;

	public DealResRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DealResRequest [user_id=" + user_id + ", from_currency=" + from_currency + ", to_currency="
				+ to_currency + ", amount=" + amount + ", username=" + username + "]";
	}

}
