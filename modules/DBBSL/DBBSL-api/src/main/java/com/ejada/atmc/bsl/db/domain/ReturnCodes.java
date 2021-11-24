package com.ejada.atmc.bsl.db.domain;

import com.ejada.atmc.acl.db.exception.NoSuchNajmCaseNoException;
import com.ejada.atmc.acl.db.exception.NoSuchNajmOtherPartyException;
import com.ejada.atmc.acl.db.exception.NoSuchNajmVehicleNoException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.liferay.portal.kernel.captcha.CaptchaConfigurationException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.CookieNotSupportedException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PasswordExpiredException;
import com.liferay.portal.kernel.exception.RequiredReminderQueryException;
import com.liferay.portal.kernel.exception.SendPasswordException;
import com.liferay.portal.kernel.exception.UserActiveException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserReminderQueryException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.security.auth.AuthException;

import java.util.Hashtable;
import java.util.Map;

public interface ReturnCodes {

	static final String SUCCESS = "0000";
	static final String FAIL = "9999";
	static final String PASSWORD_EXPIRED = "0001";
	static final String USER_LOCKOUT = "0002";
	static final String AUTH_FAIL = "0003";
	static final String COMPANY_MAX_USERS = "0004";
	static final String COOKIE_NOT_SUPPORTED = "0005";
	static final String NO_SUCH_USER = "0006";
	static final String USER_ID_FAIL = "0010";
	static final String USER_PASSWORD_FAIL = "0011";
	static final String USER_SCREEN_NAME_FAIL = "0012";
	static final String USER_SCREEN_NAME_NULL = "0013";
	static final String USER_SCREEN_NAME_DUPLICATE = "0014";
	static final String USER_EMAIL_ADDRESS_FAIL = "0015";
	static final String USER_EMAIL_ADDRESS_DUPLICATE = "0016";
	static final String USER_NOT_ACTIVE = "0017";
	static final String USER_REMINDER_QUERY_FAIL = "0018";
	static final String USER_REMINDER_QUERY_REQUIRED = "0019";
	static final String CAPTCHA_CONFIGURATION_FAIL = "0020";
	static final String CAPTCHA_TEXT_FAIL = "0021";
	static final String SEND_PASSWORD_FAIL = "0022";
	static final String USER_PASSWORD_EQUAL_CURRENT = "0023";
	static final String USER_PASSWORD__SHORT = "0024";
	static final String USER_PASSWORD_TRIVIAL = "0025";
	static final String USER_PASSWORD_DICTIONARY_WORDS = "0026";
	static final String USER_PASSWORD_RECENTLY_USED = "0027";

	static final String NO_SUCH_NAJM_CASE_NO = "0100";
	static final String NO_SUCH_NAJM_VEH_NO = "0101";
	static final String NO_SUCH_NAJM_OTHER_PARTY = "0102";
	static final String NO_SUCH_POLICY = "0103";
	static final String NO_SUCH_POLICY_VEH = "0104";

	// Specific to Mobile App. Fictitious error code
	static final String ZERO_BASE_PREMIUM = "1515";
	static final String PARAM_TAMPERING_ERROR = "6666";

	static final String INVALID_IBAN = "INVALID_IBAN";

	static final String YAQEEN_ERROR_VEH_AGE_OLD = "YAQEEN_ERROR_VEH_AGE_OLD";
	static final String RENEWABLE_POLICY_EXISTS_REG_ERROR = "RENEWABLE_POLICY_EXISTS_REG_ERROR";
	static final String RENEWABLE_POLICY_EXISTS_LOGIN_ERROR = "RENEWABLE_POLICY_EXISTS_LOGIN_ERROR";
	static final String POLICY_EXISTS_ERROR = "POLICY_EXISTS_ERROR";

	static final Map<Class, String> errorsMap = getErrorsMap();

	static Map<Class, String> getErrorsMap() {
		Hashtable<Class, String> errorsMap = new Hashtable<Class, String>();
		errorsMap.put(PasswordExpiredException.class, PASSWORD_EXPIRED);
		errorsMap.put(UserLockoutException.class, USER_LOCKOUT);
		errorsMap.put(AuthException.class, AUTH_FAIL);
		errorsMap.put(CompanyMaxUsersException.class, COMPANY_MAX_USERS);
		errorsMap.put(CookieNotSupportedException.class, COOKIE_NOT_SUPPORTED);
		errorsMap.put(NoSuchUserException.class, NO_SUCH_USER);
		errorsMap.put(UserEmailAddressException.class, USER_EMAIL_ADDRESS_FAIL);
		errorsMap.put(UserIdException.class, USER_ID_FAIL);
		errorsMap.put(UserPasswordException.class, USER_PASSWORD_FAIL);
		errorsMap.put(UserScreenNameException.class, USER_SCREEN_NAME_FAIL);
		errorsMap.put(UserEmailAddressException.MustNotBeDuplicate.class, USER_EMAIL_ADDRESS_DUPLICATE);
		errorsMap.put(UserScreenNameException.MustNotBeDuplicate.class, USER_SCREEN_NAME_DUPLICATE);
		errorsMap.put(UserScreenNameException.MustNotBeNull.class, USER_SCREEN_NAME_NULL);
		errorsMap.put(CaptchaConfigurationException.class, CAPTCHA_CONFIGURATION_FAIL);
		errorsMap.put(CaptchaTextException.class, CAPTCHA_TEXT_FAIL);
		errorsMap.put(RequiredReminderQueryException.class, USER_REMINDER_QUERY_REQUIRED);
		errorsMap.put(SendPasswordException.class, SEND_PASSWORD_FAIL);
		errorsMap.put(UserActiveException.class, USER_NOT_ACTIVE);
		errorsMap.put(UserReminderQueryException.class, USER_REMINDER_QUERY_FAIL);

		errorsMap.put(NoSuchNajmCaseNoException.class, NO_SUCH_NAJM_CASE_NO);
		errorsMap.put(NoSuchNajmVehicleNoException.class, NO_SUCH_NAJM_VEH_NO);
		errorsMap.put(NoSuchNajmOtherPartyException.class, NO_SUCH_NAJM_OTHER_PARTY);
		errorsMap.put(NoSuchPolicyHDRException.class, NO_SUCH_POLICY);
		errorsMap.put(NoSuchPolicyVEHException.class, NO_SUCH_POLICY_VEH);

		errorsMap.put(UserPasswordException.MustNotBeEqualToCurrent.class, USER_PASSWORD_EQUAL_CURRENT);
		errorsMap.put(UserPasswordException.MustBeLonger.class, USER_PASSWORD__SHORT);
		errorsMap.put(UserPasswordException.MustNotBeTrivial.class, USER_PASSWORD_TRIVIAL);
		errorsMap.put(UserPasswordException.MustNotContainDictionaryWords.class, USER_PASSWORD_DICTIONARY_WORDS);
		errorsMap.put(UserPasswordException.MustNotBeRecentlyUsed.class, USER_PASSWORD_RECENTLY_USED);
		return errorsMap;
	}

	static String getErrorCode(Class errorClass) {

		if (errorsMap.containsKey(errorClass))
			return errorsMap.get(errorClass);
		else
			return FAIL;
	}

}
