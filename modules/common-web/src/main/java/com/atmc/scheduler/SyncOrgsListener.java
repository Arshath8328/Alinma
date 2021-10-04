package com.atmc.scheduler;

//package com.atmc.scheduler;
//
//import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
//import com.liferay.portal.kernel.messaging.DestinationNames;
//import com.liferay.portal.kernel.messaging.Message;
//import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
//import com.liferay.portal.kernel.scheduler.SchedulerException;
//import com.liferay.portal.kernel.scheduler.TimeUnit;
//import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.util.PropsUtil;
//
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
//public class SyncOrgsListener extends BaseSchedulerEntryMessageListener {
//
//	private SchedulerEngineHelper _schedulerEngineHelper;
//	private static final Log _log = LogFactoryUtil.getLog(SyncOrgsListener.class);
//	private long orgSyncSleepTime = Long.valueOf(PropsUtil.get("org.sync.sleeptime"));
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
//	protected void doReceive(Message message) throws Exception {
//
//		_log.info("Sync Org executed...====================================================");
//		_log.info("Sync Org sleeping...====================================================");
//		Thread.sleep(orgSyncSleepTime);
//		_log.info("Sync Org executing...====================================================");
//		UserMgmtLocalServiceUtil.synchronizeOrgs(new ServiceContext());
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
//				TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(), 1 , TimeUnit.DAY));
//		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
//
//	}
//
//}