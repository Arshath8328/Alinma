package com.atmc.scheduler;

//package com.atmc.scheduler;
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
//import com.ejada.atmc.acl.db.model.Quotations;
//import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
//import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
//import com.atmc.web.common.NotificationTypes.Type;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
//import com.liferay.portal.kernel.messaging.DestinationNames;
//import com.liferay.portal.kernel.messaging.Message;
//import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
//import com.liferay.portal.kernel.scheduler.SchedulerException;
//import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
//import com.liferay.portal.kernel.util.LocaleUtil;
//
//@Component(
//// immediate = true, property = {"cron.expression=0 0 0 * * ?"},
//// service = SchedulerListener.class
//)
//
//public class NotifyQuotesListener extends BaseSchedulerEntryMessageListener {
//
//	private SchedulerEngineHelper _schedulerEngineHelper;
//	public static final String PENDING_ACTIVE = "PA";
//	public static final String EXPIRE = "EX";
//
//	@Reference(unbind = "-")
//	public void setschedulerEngineHelper(SchedulerEngineHelper _schedulerEngineHelper) {
//		this._schedulerEngineHelper = _schedulerEngineHelper;
//	}
//	
//	/**
//	 * 
//	 */
//	@Override
//	protected void doReceive(Message message) {
//
//		_log.info("Notify quotes Scheduled task executed.................................................");
//		
//		List<Quotations> list = QuotationLocalServiceUtil.getQuotsByQuoteStatus(PENDING_ACTIVE);
//		_log.info("Count Quotation : " + list.size());
//		
////		sendSMS(30);
//		
//		
////		try {
////			String sDate0="11/10/2020";  
////			Date date0 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate0);
////			_log.info(sDate0+"\t"+date0);
////			
////			long difference0 = new Date().getTime() - date0.getTime();
////		    long daysBetween0 = (difference0 / (1000*60*60*24));
////		    _log.info("daysBetween0 : " + daysBetween0);
////		    
////		    
////		    String sDate15="27/10/2020";  
////			Date date15 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate15);
////			_log.info(sDate15+"\t"+date15);
////			
////			long difference15 = new Date().getTime() - date15.getTime();
////		    long daysBetween15 = (difference15 / (1000*60*60*24));
////		    _log.info("daysBetween15 : " + daysBetween15);
////		    
////		    
////		    String sDate30="11/11/2020";  
////			Date date30 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate30);
////			_log.info(sDate30+"\t"+date30);
////			
////			long difference30 = new Date().getTime() - date30.getTime();
////		    long daysBetween30 = (difference30 / (1000*60*60*24));
////		    _log.info("daysBetween30 : " + daysBetween30);
////		    
////		} catch (ParseException e1) {
////			_log.error(e1.getMessage(),e1);
////		}  
//		
//		for (Quotations q : list) {
//			long difference = new Date().getTime() - q.getVehicleEstExpiryDate().getTime();
//		    long daysBetween = (difference / (1000*60*60*24));
////		    _log.info("policyNo " + q.getPolicyRefNo() +"daysBetween " + daysBetween);
//		    if(daysBetween==(-30) || daysBetween==(-15) || daysBetween==(0)){
////				String mobile = String.valueOf(q.getInsuredMobile());
//		    	String mobile = "6569004455";
//				String email = null;
//				String[] mailArgs = {};
//				String[] smsArgs = {String.valueOf(daysBetween), q.getPolicyRefNo()};
//				
//				Locale locale = new Locale("en", "US");
//				_log.info("Logging Locale:" + locale.toString());
//
//				locale = getUserLocale(); 
//				_log.info("Logging Locale Sent:" + locale.toString());
//				
//				List<File> files = new ArrayList<>();
//				List<String> filesname = new ArrayList<String>();
////				
////				try {
////					NotificationsLocalServiceUtil.notifyUser(locale, Type.QUOTATION_PRE_EXPIRY.val(), email, mobile, mailArgs, smsArgs,files,filesname,null,0,0);
////				} catch (PortalException e) {
////					_log.error(e.getMessage(),e);
////				}
//		    }
//		}
//		
//		List<Quotations> expireList = QuotationLocalServiceUtil.getQuotsByQuoteStatus(EXPIRE);
//		_log.info("Count Expire Quotation : " + expireList.size());
//		
//		for (Quotations q : expireList) {
//			long difference = q.getVehicleEstExpiryDate().getTime() - new Date().getTime();
//		    long daysBetween = (difference / (1000*60*60*24));
//			if(daysBetween==1 || daysBetween==7 || daysBetween==30){
//				String daysLeft = String.valueOf(30-daysBetween);
////				String mobile = String.valueOf(q.getInsuredMobile());
//				String mobile = "6569004455";
//				String email = null;
//				String[] mailArgs = {};
//				String[] smsArgs = {q.getPolicyNo(), !"0".equals(daysLeft) ? "next " + daysLeft : "today"};
//				
//				Locale locale = new Locale("en", "US");
//				_log.info("Logging Locale:" + locale.toString());
//
//				locale = getUserLocale(); 
//				_log.info("Logging Locale Sent:" + locale.toString());
//				
//				List<File> files = new ArrayList<File>();
//				List<String> filesname = new ArrayList<String>();
//				
////				try {
////					NotificationsLocalServiceUtil.notifyUser(locale, Type.QUOTATION_POST_EXPIRY.val(), email, mobile, mailArgs, smsArgs,files,filesname,null,0,0);
////				} catch (PortalException e) {
////					_log.error(e.getMessage(),e);
////				}
//
//			}
//		}
//		
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
//		_log.info("Notification scheduler activated.....");
//		
////		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(), 1, TimeUnit.DAY));
//		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),new Date(),"0 0 7 1/1 * ? *"));
////		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),new Date(),"0 0/5 * 1/1 * ? *"));
//		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
//
//	}
//	
//	private Locale getUserLocale()
//	{
//		return LocaleUtil.US;
//	}
//
//	private static final Log _log = LogFactoryUtil.getLog(NotifyQuotesListener.class);
//}