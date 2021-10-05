package base.main.fx_deals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import base.main.fx_deals.entity.Fx_users;

public interface Fx_usersDao extends CrudRepository<Fx_users, Integer> {

	@Query("from Fx_users where user_name = :username")
	public List<Fx_users> getFx_usersByUserName(@Param("username") String user);
}
