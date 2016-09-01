package com.mediamath.terminalone.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Test;

import com.mediamath.terminalone.ReportCriteria;
import com.mediamath.terminalone.TerminalOne;
import com.mediamath.terminalone.Exceptions.ClientException;
import com.mediamath.terminalone.models.JsonResponse;
import com.mediamath.terminalone.models.reporting.ReportValidationResponse;
import com.mediamath.terminalone.models.reporting.Reports;


public class ReportingFunctionalTest {

	@After
	public final void tearDown() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	@Test
	public void testMetaReport() {
		TerminalOne t1;
		
		try {
			t1 = new TerminalOne("nitesh.chauhan@xoriant.com", "xoriant123#","ys7ph5479kfrkpeb747mpgu3");
			assertEquals(true, t1.isAuthenticated());
			
			JsonResponse<?> jsonresponse = null;
			jsonresponse = t1.getMeta();
			
			assertNotNull(jsonresponse);
			
		} catch (ClientException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testPerformanceReport() throws ParseException, ClientException {
		TerminalOne t1;
		
			t1 = new TerminalOne("nitesh.chauhan@xoriant.com", "xoriant123#","ys7ph5479kfrkpeb747mpgu3");
			assertEquals(true, t1.isAuthenticated());
			
			ReportCriteria report = new ReportCriteria();

			report.setDimension("advertiser_name");
			report.setDimension("campaign_id");
			report.setDimension("campaign_name");
			report.setFilter("organization_id", "=", "100048");
			report.setMetric("impressions");
			report.setMetric("clicks");
			report.setMetric("total_conversions");
			report.setMetric("media_cost");
			report.setMetric("total_spend");
			
			// set having
			//report.setHaving("key1", "=", "val1,val2");
			
			// set time_rollup
			report.setTime_rollup("by_day");

			// set time_window only when no start date and end date specified.
			//report.setTime_window("last_60_days");
			
			/*
			 * start date & end_date supported format
			 * month - YYYY-MM
			 * day - YYYY-MM-DD
			 * hour - YYYY-MM-DDThh
			 * minute - YYYY-MM-DDThh:mi
			 * second - YYYY-MM-DDThh:mi:ss
			 */
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			String dateInString = "2015-02-06";
			String endDateInString = "2015-04-16";
			
			String stateDate = df.format(df.parse(dateInString));
			String endDate = df.format(df.parse(endDateInString));
			
			report.setStart_date(stateDate);
			report.setEnd_date(endDate);
			
			t1.getReport(Reports.PERFORMANCE, report);
	}
	
	@Test
	public void testValidatePerformanceReport() throws ParseException, ClientException {
		TerminalOne t1;
		
			t1 = new TerminalOne("nitesh.chauhan@xoriant.com", "xoriant123#","ys7ph5479kfrkpeb747mpgu3");
			assertEquals(true, t1.isAuthenticated());
			
			ReportCriteria report = new ReportCriteria();

			report.setDimension("advertiser_name");
			report.setDimension("campaign_id");
			report.setDimension("campaign_name");
			report.setFilter("organization_id", "=", "100048");
			report.setMetric("impressions");
			report.setMetric("clicks");
			report.setMetric("total_conversions");
			report.setMetric("media_cost");
			report.setMetric("total_spend");
			
			// set having
			//report.setHaving("key1", "=", "val1,val2");
			
			// set time_rollup
			report.setTime_rollup("by_day");

			// set time_window only when no start date and end date specified.
			//report.setTime_window("last_60_days");
			
			/*
			 * start date & end_date supported format
			 * month - YYYY-MM
			 * day - YYYY-MM-DD
			 * hour - YYYY-MM-DDThh
			 * minute - YYYY-MM-DDThh:mi
			 * second - YYYY-MM-DDThh:mi:ss
			 */
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			String dateInString = "2015-02-06";
			String endDateInString = "2015-04-16";
			
			String stateDate = df.format(df.parse(dateInString));
			String endDate = df.format(df.parse(endDateInString));
			
			report.setStart_date(stateDate);
			report.setEnd_date(endDate);
			
			ReportValidationResponse response = t1.validateReport(Reports.PERFORMANCE, report);
			
			assertNotNull(response);
	}
	
	
}
