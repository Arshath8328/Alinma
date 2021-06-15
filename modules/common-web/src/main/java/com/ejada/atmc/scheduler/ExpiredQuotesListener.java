//package com.ejada.atmc.scheduler;
//
//import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
//import com.ejada.atmc.bsl.db.service.NotificationsLocalServiceUtil;
//import com.ejada.atmc.bsl.db.service.QuotationLocalServiceUtil;
//import com.ejada.atmc.web.common.NotificationTypes.Type;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
//import com.liferay.portal.kernel.messaging.DestinationNames;
//import com.liferay.portal.kernel.messaging.Message;
//import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
//import com.liferay.portal.kernel.scheduler.SchedulerException;
//import com.liferay.portal.kernel.scheduler.TimeUnit;
//import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
//import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.LocaleUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.PropsUtil;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import org.osgi.service.component.annotations.Activate;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Modified;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(
//// immediate = true, property = {"cron.expression=0 0 0 * * ?"},
//// service = SchedulerListener.class
//)
//public class ExpiredQuotesListener extends BaseSchedulerEntryMessageListener {
//	
//	public static final String PENDING_PAYMENT_STATUS = "PP";
//	public static final String PENDING_SURVEY_STATUS = "PS";
//	public static final String EXPIRED_STATUS = "EX";
//	public static final boolean SMS_FLAG = false;
//	public static final boolean UPDATED_FLAG = true; 
//
//	private SchedulerEngineHelper _schedulerEngineHelper;
//
//	@Reference(unbind = "-")
//	public void setschedulerEngineHelper(SchedulerEngineHelper _schedulerEngineHelper) {
//		this._schedulerEngineHelper = _schedulerEngineHelper;
//	}
//
//	
//	/**
//	 * 
//	 */
//	@Override
//	protected void doReceive(Message message) {
//
//		_log.info("expired quotes Scheduled task executed...====================================================");
//		List<Quotation> quots;
//		try {
//			quots = QuotationLocalServiceUtil.getAllPendingQuotations(new Date(), PENDING_PAYMENT_STATUS, SMS_FLAG);
//			
//			if(!(quots.isEmpty()))
//			{
//				for(Quotation q: quots)
//				{
//					long quotId = q.getQuotationId();
//					String mobile = q.getInsuredMobile();
//					String email = q.getInsuredEmail();
//					String[] mailArgs = {};
//					String[] smsArgs = {PropsUtil.get("dashboardURL")};
//					
//					Locale locale = new Locale("en", "US");
//					_log.info("Logging Locale:" + locale.toString());
//
//					locale = getUserLocale(); 
//					_log.info("Logging Locale Sent:" + locale.toString());
//					
//					List<File> files = new ArrayList<File>();
//					List<String> filesname = new ArrayList<String>();
//					
//					NotificationsLocalServiceUtil.notifyUser(locale, Type.QUOTATION_EXPIRY_AND_NOT_PAID.val(), email, mobile, mailArgs, smsArgs,files,filesname,null,0,0);
//					
//					QuotationLocalServiceUtil.updateQuoteFlag(quotId, UPDATED_FLAG);
//					
//				}
//			}
//			
//			//String[] statusArr = {PENDING_PAYMENT_STATUS,PENDING_SURVEY_STATUS};
//			String[] statusArr = {PENDING_PAYMENT_STATUS};
//			List<Quotation> expiredQuots = QuotationLocalServiceUtil.getExpiredQuotsByDate(new Date(),statusArr);
//			if(!(expiredQuots.isEmpty()))
//			{
//				for(Quotation quote: expiredQuots)
//				{
//					long quotId = quote.getQuotationId();
//					
//					QuotationLocalServiceUtil.updateQuoteStatus(quotId, EXPIRED_STATUS);
//				}
//			}
//			
//			
//		} catch (PortalException e) {
//			// TODO Auto-generated catch block
//			_log.error(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 
//	 * @param properties
//	 * @throws SchedulerException
//	 */
//	@Activate
//	@Modified
//	protected void activate(Map<String, Object> properties) throws SchedulerException {
//
//		schedulerEntryImpl.setTrigger(
//				TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(), 1, TimeUnit.HOUR));
//		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
//
//	}
//	
//	private Locale getUserLocale()
//	{
//		return LocaleUtil.US;
//	}
//
//	private static final Log _log = LogFactoryUtil.getLog(ExpiredQuotesListener.class);
//}