package base.main.fx_deals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import base.main.fx_deals.entity.Fx_deals_view;

public interface Fx_deals_viewDao extends CrudRepository<Fx_deals_view, Integer> {

	@Query("from Fx_deals_view where user_id = :user_id order by deal_id desc")
	public List<Fx_deals_view> getFx_deals_viewByUserId(@Param("user_id") Integer userId);
}
