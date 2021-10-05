package base.main.fx_deals.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.main.fx_deals.entity.Fx_currencies;
import base.main.fx_deals.entity.Fx_deals;
import base.main.fx_deals.extraClasses.DealResRequest;
import base.main.fx_deals.extraClasses.DealResResponse;
import base.main.fx_deals.service.FxService;;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/main")
public class DealsController {

	@Autowired
	public FxService FxService;
	
	@PostMapping(value = "/getUserInfo")
	public ResponseEntity<DealResResponse> getUserInfo(@RequestBody DealResRequest req) {
		DealResResponse res = new DealResResponse();
		try {
			res.userInfo = FxService.Fx_usersDao.getFx_usersByUserName(req.username).get(0);
			res.messege = "success !!";
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			e.printStackTrace();
			res.error = "something went wrong while getting user info";
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}
	
	@PostMapping(value = "/getOptions", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DealResResponse> getOptions(@RequestBody DealResRequest req) {
		DealResResponse res = new DealResResponse();
		try {
			res.currencies = (List<Fx_currencies>) FxService.Fx_currenciesDao.findAll();
			res.user_deals = FxService.Fx_deals_viewDao.getFx_deals_viewByUserId(req.user_id);
			res.messege = "success !!";
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			e.printStackTrace();
			res.error = "something went wrong while fetching data";
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}

	@PostMapping(value = "/getDealResult", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DealResResponse> getDealResult(@RequestBody DealResRequest req) {
		DealResResponse res = new DealResResponse();
		try {
			Fx_currencies from = FxService.Fx_currenciesDao.findById(req.from_currency).get();
			Fx_currencies to = FxService.Fx_currenciesDao.findById(req.to_currency).get();
			Double factor = from.getCurrency_value() / to.getCurrency_value();
			// An example formula for the test purpose
			res.value = factor * req.amount;
			res.messege = "calculated successfully !!";
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			e.printStackTrace();
			res.error = "something went wrong while calculating the values";
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}

	@PostMapping(value = "/makeAdeal", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DealResResponse> makeAdeal(@RequestBody DealResRequest req) {
		DealResResponse res = new DealResResponse();
		try {
			Fx_deals deal = new Fx_deals();
			deal.setDeal_time(new Date());
			deal.setFrom_curr(req.from_currency);
			deal.setTo_curr(req.to_currency);
			deal.setAmount(req.amount);
			deal.setUser_id(req.user_id);
			FxService.Fx_dealsDao.save(deal);
			res.user_deals = FxService.Fx_deals_viewDao.getFx_deals_viewByUserId(req.user_id);
			res.messege = "deal done successfully !!";
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			e.printStackTrace();
			res.error = "something went wrong while completing the deal";
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}
}
