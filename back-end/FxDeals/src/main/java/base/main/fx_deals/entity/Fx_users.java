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
@Table(name = "fx_users")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Fx_users {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "user_pass")
	private String user_pass;

	public Fx_users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	@Override
	public String toString() {
		return "Fx_users [user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass + "]";
	}

}
