package base.main.fx_deals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import base.main.fx_deals.entity.Fx_deals;

public interface Fx_dealsDao extends CrudRepository<Fx_deals,Integer> {

	@Query("from Fx_deals where user_id = :user_id order by deal_id desc")
	public List<Fx_deals> getFx_dealsByUserId(@Param("user_id") Integer userId);
}
