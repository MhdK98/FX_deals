package base.main.fx_deals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import base.main.fx_deals.dao.*;

@Service
public class FxService {

	@Autowired
	public Fx_usersDao Fx_usersDao;

	@Autowired
	public Fx_currenciesDao Fx_currenciesDao;

	@Autowired
	public Fx_dealsDao Fx_dealsDao;

	@Autowired
	public Fx_deals_viewDao Fx_deals_viewDao;

	public FxService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAuthenticUser(String user, String pass) {
		boolean res = false;
		try {
			if (Fx_usersDao.getFx_usersByUserName(user).get(0).getUser_pass().equals(pass)) {
				res = true;
			}
		} catch (Exception e) {
			// user not found ....
		}
		return res;
	}

}
