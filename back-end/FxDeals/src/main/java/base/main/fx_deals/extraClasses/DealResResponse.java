package base.main.fx_deals.extraClasses;

import java.util.List;

import base.main.fx_deals.entity.Fx_currencies;
import base.main.fx_deals.entity.Fx_deals_view;
import base.main.fx_deals.entity.Fx_users;

public class DealResResponse {

	public Double value;
	public String messege;
	public String error;
	public List<Fx_deals_view> user_deals;
	public List<Fx_currencies> currencies;
	public Fx_users userInfo;

	public DealResResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DealResResponse [value=" + value + ", messege=" + messege + ", error=" + error + ", user_deals="
				+ user_deals + ", currencies=" + currencies + ", userInfo=" + userInfo + "]";
	}

}
