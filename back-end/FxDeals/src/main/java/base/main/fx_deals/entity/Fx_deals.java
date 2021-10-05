package base.main.fx_deals.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Entity
@Table(name = "fx_deals")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Fx_deals {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "deal_id")
	private Integer deal_id;
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "from_curr")
	private Integer from_curr;
	@Column(name = "to_curr")
	private Integer to_curr;
	@Column(name = "deal_time")
	private Date deal_time;
	@Column(name = "amount")
	private Double amount;

	public Fx_deals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(Integer deal_id) {
		this.deal_id = deal_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getFrom_curr() {
		return from_curr;
	}

	public void setFrom_curr(Integer from_curr) {
		this.from_curr = from_curr;
	}

	public Integer getTo_curr() {
		return to_curr;
	}

	public void setTo_curr(Integer to_curr) {
		this.to_curr = to_curr;
	}

	public Date getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Fx_deals [deal_id=" + deal_id + ", user_id=" + user_id + ", from_curr=" + from_curr + ", to_curr="
				+ to_curr + ", deal_time=" + deal_time + ", amount=" + amount + "]";
	}

}
