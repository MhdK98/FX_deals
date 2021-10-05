package base.main.fx_deals.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Entity
@Table(name = "fx_currencies")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Fx_currencies {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "currency_id")
	private Integer currency_id;
	@Column(name = "currency_desc")
	private String currency_desc;
	@Column(name = "currency_value")
	private Double currency_value;

	public Fx_currencies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(Integer currency_id) {
		this.currency_id = currency_id;
	}

	public String getCurrency_desc() {
		return currency_desc;
	}

	public void setCurrency_desc(String currency_desc) {
		this.currency_desc = currency_desc;
	}

	public Double getCurrency_value() {
		return currency_value;
	}

	public void setCurrency_value(Double currency_value) {
		this.currency_value = currency_value;
	}

	@Override
	public String toString() {
		return "Fx_currencies [currency_id=" + currency_id + ", currency_desc=" + currency_desc + ", currency_value="
				+ currency_value + "]";
	}

}
