package com.mediamath.jterminalone;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mediamath.jterminalone.Exceptions.ClientException;
import com.mediamath.jterminalone.Exceptions.ParseException;
import com.mediamath.jterminalone.models.Agency;
import com.mediamath.jterminalone.models.Campaign;
import com.mediamath.jterminalone.models.JsonResponse;
import com.mediamath.jterminalone.utils.ConditionQuery;
import com.mediamath.jterminalone.utils.Filters;
import com.mediamath.jterminalone.utils.QueryParamValues;

import junit.framework.TestCase;

public class BasicTest extends TestCase {
	
	@Test
	public void testAgencyPost() throws ClientException {
		JTerminalOne t1 = new JTerminalOne("nitesh.chauhan@xoriant.com", "xoriant123#","e34f74vnubr9uxasz2n7bdfv");
		
		Agency agency = new Agency();
		agency.setName("Nitesh6");
		agency.setOrganization_id(100048);
		try {
			agency = t1.save(agency);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCampaignPost() throws ClientException {
		JTerminalOne t1 = new JTerminalOne("nitesh.chauhan@xoriant.com", "xoriant123#","e34f74vnubr9uxasz2n7bdfv");
		
		Campaign camp = new Campaign();
		camp.setName("NitCamp");
		camp.setAd_server_fee(10.0f);
		camp.setAd_server_id(9);
		camp.setAdvertiser_id(154359);
		camp.setConversion_type("variable");
		camp.setConversion_variable_minutes(1);
		camp.setEnd_date(new Date());
		camp.setGoal_type(Campaign.goal_types.cpa);
		camp.setGoal_value(100);
		camp.setService_type(Campaign.serv_types.SELF);
		camp.setStart_date(new Date());
		camp.setTotal_budget(100);
		camp.setUse_mm_freq(false);
		camp.setMerit_pixel_id(3);
		
		try {
			camp = t1.save(camp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tmpe");
	}
	
	@Test
	public void testJTerminalOneStringStringString() {
		JTerminalOne t1;
		try {
			t1 = new JTerminalOne("nitesh.chauhan@xoriant.com", "xoriant123#","e34f74vnubr9uxasz2n7bdfv");
			assertEquals(true, t1.isAuthenticated());
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testJTerminalOneAuthenticate() throws ClientException {
		JTerminalOne t1 = new JTerminalOne();
		boolean isAuthenticated = t1.authenticate("nitesh.chauhan@xoriant.com", "xoriant123#","e34f74vnubr9uxasz2n7bdfv");
		assertEquals(true, isAuthenticated);
	}

	@Test
	public void testBaiscGetWithChildUsingQueryCriteria() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("nitesh.chauhan@xoriant.com", "xoriant123#", "e34f74vnubr9uxasz2n7bdfv");
		
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setEntity(154161)
									.setInclude(new ConditionQuery("agency", "organization"))
									.build();
		
		
		query = QueryCriteria.builder(query)
							.setInclude(new ConditionQuery("ad_server"))
							.setInclude(new ConditionQuery("vertical"))
							.build();

		
		JsonResponse<?> jsonresponse = null;
		
		try {
			jsonresponse = jt1.get(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	
	@Test
	public void testBaiscGetWithSortByUsingQueryCriteria() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setSortBy("-id")
									.build();
		
		JsonResponse<?> jsonresponse = null;
		
		try {
			jsonresponse = jt1.get(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	
	@Test
	public void testBaiscGetWithPageLimit() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		
		QueryCriteria query = QueryCriteria.builder().setCollection("advertisers").setPageLimit(40).build();
		
		JsonResponse<?> jsonresponse = null;
		
		try {
			jsonresponse = jt1.get(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	@Test
	public void testBaiscGetWithPageLimitOffset() throws ClientException  {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setPageLimit(40)
									.setPageOffset(300)
									.build();
		
		JsonResponse<?> jsonresponse = null;
		
		try {
			jsonresponse = jt1.get(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	
	@Test
	public void testBaiscGetWithLimit() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		Map<String, Long> limitList = new HashMap<String, Long>();
		limitList.put("agency", Long.valueOf(111555));
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setLimit(limitList)
									.setPageLimit(100)
									.build();
		
		JsonResponse<?> jsonresponse = null;
		
		try {
			jsonresponse = jt1.get(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	
	@Test
	public void testBaiscGetWithQuery() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		Map<String, Long> limitList = new HashMap<String, Long>();
		limitList.put("agency", Long.valueOf(111555));
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setInclude(new ConditionQuery("agency", "organization"))
									.setQuery("agency_id%3E=109308")
									.setPageLimit(100)
									.build();
		JsonResponse<?> jsonresponse = null;
		try {
			jsonresponse = jt1.get(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
		
	}
	
	@Test
	public void testBaiscGetWithFind() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		Map<String, Long> limitList = new HashMap<String, Long>();
		limitList.put("agency", Long.valueOf(111555));
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setQueryParamName("agency_id")
									.setQueryOperator(Filters.GREATER_OR_EQUAL)
									.setQueryParams(new QueryParamValues(109308))
									.setPageLimit(100)
									.build();
		JsonResponse<?> jsonresponse = null;
		try {
			jsonresponse = jt1.find(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			throw new AssertionError();
			
		}
		
		
		
		assertNotNull(jsonresponse);
	
	}
	
	@Test
	public void testBaiscGetWithFind1() throws ClientException {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		Map<String, Long> limitList = new HashMap<String, Long>();
		limitList.put("agency", Long.valueOf(111555));
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setQueryParamName("name")
									.setQueryOperator(Filters.EQUALS)
									.setQueryParams(new QueryParamValues("Retirement"))
									.setPageLimit(100)
									.build();
		
		JsonResponse<?> jsonresponse = null;
		try {
			jsonresponse = jt1.find(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	
	@Test
	public void testBaiscGetWithFind2() throws ClientException  {
		JTerminalOne jt1 = new JTerminalOne();
		jt1.authenticate("jitendra.chaudhari@xoriant.com", "xoriant123#", "kdcvkmat98dk7atjx5evsb6d");
		Map<String, Long> limitList = new HashMap<String, Long>();
		limitList.put("agency", Long.valueOf(111555));
		List<Object> qParams = new ArrayList<Object>();
		qParams.add(154121);
		qParams.add(153226);
		qParams.add(150994);
		QueryCriteria query = QueryCriteria.builder()
									.setCollection("advertisers")
									.setQueryParams(new QueryParamValues("name"))
									.setQueryOperator(Filters.IN)
									.setQueryParams(new QueryParamValues(qParams))
									.setPageLimit(100)
									.build();
		JsonResponse<?> jsonresponse = null;
		try {
			jsonresponse = jt1.find(query);
		} catch (ClientException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(jsonresponse);
	
	}
	
}
