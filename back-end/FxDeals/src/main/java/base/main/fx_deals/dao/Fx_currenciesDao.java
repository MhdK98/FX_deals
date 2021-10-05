package base.main.fx_deals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import base.main.fx_deals.entity.Fx_currencies;

public interface Fx_currenciesDao extends CrudRepository<Fx_currencies, Integer> {

	@Query("from Fx_currencies where currency_desc = :ISO_code")
	public List<Fx_currencies> getFx_currenciesByISO_code(@Param("ISO_code") String ISO_code);
}
