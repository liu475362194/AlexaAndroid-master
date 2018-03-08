package com.willblaschko.android.alexavoicelibrary.global;

/**
 * @author will on 5/30/2016.
 */

public class Constants {
    public static final String PRODUCT_ID = "AlexaAndroid";


    //the debug switch whether display  user debug info, open function when true
    public static final boolean TRACE_DEBUG = true;//change to false when release

    //the debug switch whether echo  update result to band, close function when true
    public static final boolean UPDATE_DEBUG = false;//change to false when release

    //the debug switch whether auto update backgroud, close function when true
    public static final boolean UPDATE_DEBUG1 = false;//change to false when release

    public static final boolean DISABLE_DAEMON = false;

    //the debug switch firmware updata with outer resoures, close function when true
    public static final boolean UPDATE_DEBUG2 = false;//change to false when release
    public static final boolean DISABLE_CLOUDY_FUN = false;//change to false when release
    public static final boolean ACCOUNT_DEBUG = false;//change to false when release


    public static final String PATH_ROOT = "data/";
    public static final String PATH_IMG = "img/";
    public static final String PATH_LOG = "log/";
    public static final String PATH_UPDATE = "update/";

    public static String ACHIEVEMENT_SHARE_BROADCASET="achievement_share_broadcast";

    public static final String SERVICECMD = "com.android.music.musicservicecommand";
    public static final String CMDNAME = "command";
    public static final String CMDTOGGLEPAUSE = "togglepause";
    public static final String CMDSTOP = "stop";
    public static final String CMDPAUSE = "pause";
    public static final String CMDPREVIOUS = "previous";
    public static final String CMDNEXT = "next";
    public static final String TOGGLEPAUSE_ACTION = "com.android.music.musicservicecommand.togglepause";
    public static final String PAUSE_ACTION = "com.android.music.musicservicecommand.pause";
    public static final String PREVIOUS_ACTION = "com.android.music.musicservicecommand.previous";
    public static final String NEXT_ACTION = "com.android.music.musicservicecommand.next";

    public static final String PROTOCOL_UPDATE = "com.spark.PROTOCOL_UPDATE";
    public static final String PROTOCOL_BATTERYINFO = "com.spark.PROTOCOL_BATTERYINFO";
    public static final String PROTOCOL_FIRMWARE = "com.spark.PROTOCOL_FIRMWARE";
    public static final String PROTOCOL_BANDNAME = "com.sparkPROTOCOL_BANDNAME";
    public static final String PROTOCOL_RSSI_DATA = "com.spark.PROTOCOL_RSSI_DATA";
    public static final String PROTOCOL_PROCESS_RUN = "com.spark.PROTOCOL_PROCESS_RUN";
    public static final String PROTOCOL_REAL_STEPS = "com.spark.PROTOCOL_REAL_STEPS";
    public static final String PROTOCOL_TIME_DATA= "com.spark.PROTOCOL_TIME_DATA";
    public static final String PROTOCOL_NET_ERROR = "com.spark.PROTOCOL_NET_ERROR";
    public static final String PROTOCOL_START_SCAN = "com.spark.PROTOCOL_START_SCAN";
    public static final String PROTOCOL_STOP_SCAN = "com.spark.PROTOCOL_STOP_SCAN";
    public static final String PROTOCOL_RESTART_APP = "com.spark.PROTOCOL_RESTART_APP";
    public static final String PROTOCOL_UPDATE_DEVICE = "com.spark.PROTOCOL_UPDATE_DEVICE";
    public static final String PROTOCOL_UPDATE_DATA = "com.spark.PROTOCOL_UPDATE_DATA";
    public static final String PROTOCOL_DIALOG = "com.spark.PROTOCOL_DIALOG";
    public static final String PROTOCOL_TRY_CONNECT = "com.spark.PROTOCOL_TRY_CONNECT";
    public static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final String ACTION_NOTIFICATION_LISTENER_SETTINGS = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
    public static final String ACTION_NLS_CONTROL = "com.spark.NLSCONTROL";
    public static final String SOFTWARE_ID = "TCL-MOVEBAND";
    public static final String CURRENT_USER = "user";
    public static final String LAST_ACCOUNT = "old_account";
    public static final String LAST_ADDRESS = "old_address";
    public static final String CURRENT_ACCOUNT = "account";
    public static final String CURRENT_ADDRESS = "address";
    public static final String NEW_SCAN = "new_scan";

    public static final String DEST_INTERVALS = "destIntervals";
    public static final String GOALS_STEPS = "goalsSteps";
    public static final String GOALS_CALORIES = "goalsCalories";
    public static final String GOALS_DISTANCE = "goalsDistance";
    public static final String GOALS_DURATION = "goalsDuratio";
    public static final String CURRENT_SELECT_GESTURES = "currentSelectGestures";
    public static final String ENABLE_OR_DISABLE_GESTURES = "enableOrDisableGestures";
    public static final String ENABLE_OR_DISABLE_MISSEDCALLS = "enableOrDisableMissedCalls";
    public static final String ENABLE_OR_DISABLE_EMAIL = "enableOrDisableEmail";
    public static final String ENABLE_OR_DISABLE_MESSAGE = "enableOrDisableMessage";
    public static final String ENABLE_OR_DISABLE_INCOMING_CALL = "enableOrDisableIncomingCall";
    public static final String ENABLE_OR_DISABLE_LOW_BATTERY = "enableOrDisableLowBattery";
    public static final String ENABLE_OR_DISABLE_WHATSAPP = "enableOrDisableWhatsAPP";
    public static final String NOTIFICATIONS_MISSEDCALLS  = "notificationCountersMissedCalls";
    public static final String NOTIFICATIONS_EMAIL  = "notificationCountersEmail";
    public static final String NOTIFICATIONS__MESSAGE  = "notificationCountersMessage";
    public static final String NOTIFICATIONS__INCOMING_CALL  = "notificationCountersIncomingCall";
    public static final String NOTIFICATIONS__WHATSAPP  = "notificationCountersWhatsAPP";
    public static final String SHOCK_NOTIFICATION = "shockNotification";
    public static final String START_SCAN_DEVICE = "com.spark.service.start.scan.device";
    public static final String STOP_SCAN_DEVICE = "com.spark.service.stop.scan.device";
    public static final String GET_SCAN_DEVICE = "com.spark.service.get.scan.device";
    public static final String SEND_SCAN_DEVICE = "com.spark.service.send.scan.device";
    public static final String SEND_SCAN_DEVICES = "com.spark.service.send.scan.devices";
    public static final String CLICK_FINDED_DEVICE = "com.spark.service.click.find.device";

    public static final String BLUETOOTH_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    public static final String BLUETOOTH_ACTION = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    public static final String REAL_STEPS = "real_steps";
    public static final String UPDATE_DATA = "update_data";
    public static final String CHARGING_DATE = "chargingDate";
    public static final String CLEAR_AFTER_UPDATE = "clearAfterUpdate";
    public static final String DEVICE_ID = "DEVICE_ID-";
    public static final String DEVICE_FIRMWARE = "DEVICE_FIRMWARE-";
    public static final String DEVICE_HARDWARE = "DEVICE_HARDWARE-";
    public static final String DEVICE_SERIAL = "DEVICE_SERIAL-";

    //public static final String FIRST_DATAS = "firstData";
    //public static final String LAST_DATAS = "lastData";
    public static final String LOCALE_ALARM_INFO1 = "localeAlarmInfo1";
    public static final String LOCALE_ALARM_INFO2 = "localeAlarmInfo2";
    public static final String LOCALE_ALARM_INFO3 = "localeAlarmInfo3";
    public static final String LOCALE_ALARM_INFO4 = "localeAlarmInfo4";
    public static final String DEVICE_MODE = "deviceMode";
    public static final String RESET_TICK = "resetTick";

    //	/*********SharedPreferences store parameters as above**************/
//   public static final String SERVICER = "http://121.40.137.250:80/spk-server/";//domestic
    public static final String SERVICER = "https://52.58.165.254:443/spk-server/";//abroad
//	public static final String SERVICER = "https://52.58.165.254:443/spk-server-newTest/";//abroad
//	public static final String SERVICER = "http://192.168.201.128:8080/spk-server/";//abroad
//	public static final String SERVICER = "http://52.58.165.254:80/spk-server/";//abroad
//  public static final String SERVICER = "http://yangxingwangzl.6655.la:48912/spk-server/";
//	public static final String SERVICER = "http://yangxingwangzl.6655.la:25312/spk-server/";

    public static final String FILE_TYPE_IMG = "img";
    public static final String FROM = "from";
    public static final String HEAD_LOGO = "_headLogo.jpg";

    public static final String FORMAT_Y_M_D_H = "yyyy-MM-dd HH";
    public static final String FORMAT_Y_M_D_H_M = "yyyy-MM-dd HH:mm";
    //    public static final String FORMAT_Y_M_D_WEEKDAY = "yyyy年MM月dd日  E";
//    public static final String FORMAT_Y_M_D1 = "yyyy年MM月dd日";
    public static final String FORMAT_Y_M_D = "yyyy-MM-dd";
    public static final String FORMAT_Y_M = "MMM";
    public static final String FORMAT_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_M_D_H_M = "MM-dd HH:mm";
    public static final String FORMAT_M_D = "dd-MMM";
    //    public static final String FORMAT_M_D1 = "MM月dd日";
    public static final String FORMAT_H_M = "HH:mm";
    //    public static final String FORMAT_H_M_S = "HH:mm:ss";
    public static final String FORMAT_D = "dd";
    public static final String CHARSET_UTF_8 = "utf-8";

    public static final String REGISTER = SERVICER + "user/reg";
    //    public static final String GET_USER_INFO = SERVICER + "user/info";
//    public static final String GET_USER_DETAILINFO = SERVICER + "user/detailInfo";
    public static final String EDITPED = SERVICER + "user/editPwd";
    public static final String OPT_REG = "reg";
    public static final String OPT_ACTIVATE = "activate";
    public static final String OPT_EDITPWD = "editPwd";
    public static final String OPT_UPDATE = "update";
    public static final String USER_UPDATE = SERVICER + "user/update";
    public static final String USER_DELETE = SERVICER + "user/deleteUser";
    //http://host:port/spk-server/data/medalList
    //http://host:port/spk-server/data/updateMedal
    public static final String SEND_MYACHIEVEMENT = SERVICER + "data/updateMedal";
    public static final String GET_MYACHIEVEMENT_LIST = SERVICER + "data/medalList";
    // commitSportsDataList
    public static final String SEND_HISTORYDB1 = SERVICER + "data/commitSleepDataList";
    public static final String SEND_HISTORYDATA = SERVICER + "data/commitSportsDataList";
    public static final String GET_HISTORYDATA_LIST = SERVICER + "data/getSportsDataMinute";
    //http://host:port/spk-server/data/getSportsDataMinutePaging
    public static final String GET_HISTORYDB1_LIST_PAGING = SERVICER + "data/getSleepDataList";
    public static final String GET_HISTORYDATA_LIST_PAGING = SERVICER + "data/getSportsDataMinutePaging";
    public static final String USER_HISTORYDATA_LIST = SERVICER + "data/commitSportsDataList";
    public static final String GET_USER_HISTORYDATA_LIST = SERVICER + "data/getSportsNewDate";
    public static final String DELETE_DEVICE = SERVICER + "serial/deleteSerial";
    public static final String SAVE_DEVICE = SERVICER + "serial/saveSerial";
    public static final String GET_DEVICE = SERVICER + "serial/getSerial";
    public static final String GET_TICK = SERVICER + "auth/getTick";
    public static final String GET_DEVICE_BY_SERIALNO = SERVICER + "serial/getSerialBySerialNo";
    public static final String LOGIN = SERVICER + "auth/login";
    public static final String LOGOUT = SERVICER + "auth/logout";
    public static final String LOGIN_STATUS = SERVICER + "auth/isLogin";
    public static final String CHECK_IS_REGISTER = SERVICER + "user/isRegister";
    public static final String GET_SESSION = SERVICER + "auth/getSessionStatus";
    public static final String GET_AUTHCODE = SERVICER + "auth/getVerifyNum";
    public static final String AUTH = SERVICER + "auth/verify";
    public static final String GET_FILE = SERVICER + "file/get";
    public static final String UPLOAD_URL= SERVICER+"file/upload?type=TYPE&length=LENGTH&index=INDEX";
    public static final String CHECK_FILE_EXIST = SERVICER + "file/checkExist";
    public static final String USER_TYPE_MOBILE = "mobile";
    public static final String USER_TYPE_EMAIL = "email";
    public static final String USER_TYPE_PLATFORM = "thirdParty";

    public static final String USERINFO = "userinfo";
    public static final String SERIAL = "serial";
    public static final String SERIALLIST = "serialList";
    public static final String USERKEY = "userKey";
    public static final String USERID = "userId";
    public static final String PWD = "password";
    public static final String OPT = "opt";
    public static final String OPT_FEEDBACK = "userFeedback";
    public static final String KEYTYPE = "keyType";
    public static final String LANGUAGE = "language";
    public static final String TOKEN = "token";

    public static final long DAY_MILLISECONDS = (1000L * 60 * 60 * 24);
    public static final long DAY_SECONDS = ( 60 * 60 * 24);
    public static final long AUTO_UPDATE_INTERVALS = (5*60*1000);
    public static final int MAX_ALARMS = 4;
    public static final int DEFAULT_GOALS_STEPS = 6000;
    public static final int MAX_GOALS_STEPS = 24000;
    public static final int MIN_GOALS_STEPS = 4000;
    public static final int ADD_GOALS_STEPS = 2000;

    public static final int DEFAULT_GOALS_CALORIES = 250;
    public static final int MAX_GOALS_CALORIES = 600;
    public static final int MIN_GOALS_CALORIES = 100;
    public static final int ADD_GOALS_CALORIES = 50;

    public static final int DEFAULT_GOALS_DISTANCE = 7000;
    public static final int MAX_GOALS_DISTANCE = 16000;
    public static final int MIN_GOALS_DISTANCE = 3000;
    public static final int ADD_GOALS_DISTANCE = 1000;

    public static final int DEFAULT_GOALS_DURATION = 180;
    public static final int MAX_GOALS_DURATION = 360;
    public static final int MIN_GOALS_DURATION = 60;
    public static final int ADD_GOALS_DURATION = 30;

    public static final int SORT_TYPE_DAY = 0;
    public static final int SORT_TYPE_WEEK = 1;
    public static final int SORT_TYPE_MONTH = 2;

    public static final String NORMAL_ACCESS = "normalAccess";
    public static final String REGISTER_ACCESS = "registerAccess";
    public static final String COMPLETE_ACCESS = "completeAccess";

    public static final int MSG_NET_ERROR = 1314;
    public static final int MSG_FRESH_SLEEP = MSG_NET_ERROR + 1;
    public static final int MSG_SYNC_OVER = MSG_FRESH_SLEEP + 1;
    public static final int MSG_BIND_FAILED = MSG_SYNC_OVER + 1;
    public static final int MSG_BIND_SUCCESS = MSG_BIND_FAILED + 1;
    public static final int MSG_LOGIN_FAILED = MSG_BIND_SUCCESS + 1;
    public static final int MSG_LOGIN_SUCCESS = MSG_LOGIN_FAILED + 1;
    public static final int MSG_VERIFY_FAILED = MSG_LOGIN_SUCCESS + 1;
    public static final int MSG_VERIFY_SUCCESS = MSG_VERIFY_FAILED + 1;
    public static final int MSG_DELETE_FAILED = MSG_VERIFY_SUCCESS + 1;
    public static final int MSG_DELETE_SUCCESS = MSG_DELETE_FAILED + 1;
    public static final int MSG_UPLOAD_FAILED = MSG_DELETE_SUCCESS + 1;
    public static final int MSG_UPLOAD_SUCCESS = MSG_UPLOAD_FAILED+ 1;
    public static final int MSG_REGISTER_FAILED = MSG_UPLOAD_SUCCESS + 1;
    public static final int MSG_REGISTER_SUCCESS = MSG_REGISTER_FAILED + 1;
    public static final int MSG_GET_ICON_FAILED = MSG_REGISTER_SUCCESS + 1;
    public static final int MSG_GET_ICON_SUCCESS = MSG_GET_ICON_FAILED + 1;
    public static final int MSG_CHANGE_PWD_FAILED = MSG_GET_ICON_SUCCESS + 1;
    public static final int MSG_CHANGE_PWD_SUCCESS = MSG_CHANGE_PWD_FAILED + 1;
    public static final int MSG_UPDATE_USER_FAILED = MSG_CHANGE_PWD_SUCCESS + 1;
    public static final int MSG_UPDATE_USER_SUCCESS = MSG_UPDATE_USER_FAILED + 1;
    public static final int MSG_GET_SESSION_FAILED = MSG_UPDATE_USER_SUCCESS + 1;
    public static final int MSG_GET_SESSION_SUCCESS = MSG_GET_SESSION_FAILED + 1;
    public static final int MSG_UPDATE_GOALS_FAILED = MSG_GET_SESSION_SUCCESS + 1;
    public static final int MSG_UPDATE_GOALS_SUCCESS = MSG_UPDATE_GOALS_FAILED + 1;
    public static final int MSG_QUERY_BINDED_FAILED = MSG_UPDATE_GOALS_SUCCESS + 1;
    public static final int MSG_QUERY_BINDED_SUCCESS = MSG_QUERY_BINDED_FAILED + 1;
    public static final int MSG_PWD_RECOVERY_FAILED = MSG_QUERY_BINDED_SUCCESS + 1;
    public static final int MSG_PWD_RECOVERY_SUCCESS = MSG_PWD_RECOVERY_FAILED + 1;
    public static final int MSG_QUERY_REGISTER_FAILED = MSG_PWD_RECOVERY_SUCCESS + 1;
    public static final int MSG_QUERY_REGISTER_SUCCESS = MSG_QUERY_REGISTER_FAILED + 1;
    public static final int MSG_QUERY_BAND_INFORMATION = MSG_QUERY_REGISTER_SUCCESS + 1;
    public static final int MSG_FRESH_USERINFO_FAILED = MSG_QUERY_BAND_INFORMATION + 1;
    public static final int MSG_FRESH_USERINFO_SUCCESS = MSG_FRESH_USERINFO_FAILED + 1;
    public static final int MSG_GET_VERIFY_CODE_FAILED = MSG_FRESH_USERINFO_SUCCESS + 1;
    public static final int MSG_GET_VERIFY_CODE_SUCCESS = MSG_GET_VERIFY_CODE_FAILED + 1;
    public static final int MSG_GET_VERIFY_CODE = MSG_GET_VERIFY_CODE_SUCCESS + 1;
    public static final int MSG_DELETE_USER_FAILED = MSG_GET_VERIFY_CODE + 1;
    public static final int MSG_DELETE_USER_SUCCESS = MSG_DELETE_USER_FAILED + 1;
    public static final int MSG_LOGOUT_FAILED = MSG_DELETE_USER_SUCCESS + 1;
    public static final int MSG_LOGOUT_SUCCESS = MSG_LOGOUT_FAILED + 1;
    public static final int MSG_CLEAR_EDITTEXT = MSG_LOGOUT_SUCCESS + 1;

    public static final int MSG_GET_HISTROYDB1 = MSG_CLEAR_EDITTEXT + 1;
    public static final int MSG_GET_HISTROYDB1_FAIL = MSG_GET_HISTROYDB1 + 1;
    public static final int MSG_GET_HISTROYDB1_SUCESS = MSG_GET_HISTROYDB1_FAIL + 1;

    public static final int MSG_SEND_HISTORYDB1 = MSG_GET_HISTROYDB1_SUCESS + 1;
    public static final int MSG_SEND_HISTORYDB1_FAIL = MSG_SEND_HISTORYDB1 + 1;
    public static final int MSG_SEND_HISTORYDB1_SUCCESS = MSG_SEND_HISTORYDB1_FAIL + 1;

    public static final int MSG_GET_HISTROYDATA = MSG_SEND_HISTORYDB1_SUCCESS + 1;
    public static final int MSG_GET_HISTROYDATA_FAIL = MSG_GET_HISTROYDATA + 1;
    public static final int MSG_GET_HISTROYDATA_SUCESS = MSG_GET_HISTROYDATA_FAIL + 1;

    public static final int MSG_SEND_HISTORYDATA = MSG_GET_HISTROYDATA_SUCESS + 1;
    public static final int MSG_SEND_HISTORYDATA_FAIL = MSG_SEND_HISTORYDATA + 1;
    public static final int MSG_SEND_HISTORYDATA_SUCCESS = MSG_SEND_HISTORYDATA_FAIL + 1;

    public static final int MSG_DATA_TRANSLATE_OVER = MSG_SEND_HISTORYDATA_SUCCESS + 1;

    public static final int MSG_SYS_ERR = MSG_DATA_TRANSLATE_OVER + 1;
    public static final int MSG_NOT_REG = MSG_SYS_ERR + 1;
    public static final int MSG_OPEN_BLE = MSG_NOT_REG + 1;
    public static final int MSG_CLOSE_BLE = MSG_OPEN_BLE + 1;
    public static final int MSG_TIME_OUT = MSG_CLOSE_BLE + 1;
    public static final int MSG_GET_TICK = MSG_TIME_OUT + 1;
    public static final int MSG_GET_DEVICE = MSG_GET_TICK + 1;
    public static final int MSG_SERVER_ERR = MSG_GET_DEVICE + 1;
    public static final int MSG_EMAIL_EXIST = MSG_SERVER_ERR + 1;
    public static final int MSG_PASSWORD_ERR = MSG_EMAIL_EXIST + 1;
    public static final int MSG_FRESH_SYNCH_TIME = MSG_PASSWORD_ERR + 1;
    public static final  int MSG_SET_ANTI_LOST_INFO = MSG_FRESH_SYNCH_TIME+ 1;
    public static final int MSG_CHGECK_BAND_STATUS = MSG_SET_ANTI_LOST_INFO + 1;
    public static final int MSG_ACCOUNT_NOT_ACTIVITY = MSG_CHGECK_BAND_STATUS + 1;
    public static final int MSG_FINISH_ACTIVITY = MSG_ACCOUNT_NOT_ACTIVITY + 1;

    public static final int MSG_INIT_RECYCLEVIEW_DAY = MSG_FINISH_ACTIVITY + 1;
    public static final int MSG_INIT_RECYCLEVIEW_WEEK = MSG_INIT_RECYCLEVIEW_DAY + 1;
    public static final int MSG_INIT_RECYCLEVIEW_MONTH = MSG_INIT_RECYCLEVIEW_WEEK + 1;
    public static final int MSG_SHOW_CURRENTDATE_DAY = MSG_INIT_RECYCLEVIEW_MONTH + 1;
    public static final int MSG_SHOW_CURRENTDATE_WEEK = MSG_SHOW_CURRENTDATE_DAY + 1;
    public static final int MSG_SHOW_CURRENTDATE_MONTH = MSG_SHOW_CURRENTDATE_WEEK + 1;
    public static final int MSG_STATE_CONNECTED_AND_READY= MSG_SHOW_CURRENTDATE_MONTH + 1;
    public static final int MSG_INIT_CHARTS_DAY = MSG_STATE_CONNECTED_AND_READY + 1;
    public static final int MSG_INIT_CHARTS_WEEK = MSG_INIT_CHARTS_DAY + 1;
    public static final int MSG_INIT_CHARTS_MONTH = MSG_INIT_CHARTS_WEEK + 1;
    public static final int MSG_RECYCLEVIEW_POSITION = MSG_INIT_CHARTS_MONTH + 1;
    public static final int MSG_LOAD_USER_ICON = MSG_RECYCLEVIEW_POSITION + 1;
    public static final int MSG_ERROR_TOAST = MSG_LOAD_USER_ICON + 1;
    public static final int MSG_LOGIN_INFO = MSG_ERROR_TOAST + 1;
    public static final int MSG_LOGIN_CANCELED = MSG_LOGIN_INFO + 1;
    public static final int MSG_UID_EXIST = MSG_LOGIN_CANCELED + 1;
    public static final int MSG_AUTH_ERROR= MSG_UID_EXIST + 1;
    public static final int MSG_DELAY_EXIT= MSG_AUTH_ERROR + 1;
    public static final int MSG_STOP_SCAN0= MSG_DELAY_EXIT + 1;
    public static final int MSG_STOP_SCAN1= MSG_STOP_SCAN0 + 1;
    public static final int MSG_STOP_SCAN2= MSG_STOP_SCAN1 + 1;
    public static final int MSG_SYNCH_TASK= MSG_STOP_SCAN2 + 1;
    public static final int MSG_REMOVE_ERR= MSG_SYNCH_TASK + 1;
    public static final int MSG_HANDER_CMD= MSG_REMOVE_ERR + 1;
    public static final int MSG_UPDATA_BACKUP = MSG_HANDER_CMD + 1;
    public static final int MSG_UPDATA_TIME = MSG_UPDATA_BACKUP + 1;
    public static final int MSG_RECONNECT_DEVICE = MSG_UPDATA_TIME + 1;
    public static final int MSG_KEEP_SESSION = MSG_RECONNECT_DEVICE + 1;
    public static final int MSG_FIND_DEVICE = MSG_KEEP_SESSION + 1;
    public static final int MSG_SEARCH_DEVICE = MSG_FIND_DEVICE + 1;
    public static final int MSG_COMPLETE_UPDATE = MSG_SEARCH_DEVICE + 1;
    public static final int MSG_UPDATE = MSG_COMPLETE_UPDATE + 1;
    public static final int MSG_LOWPOWER_TOGLLE = MSG_UPDATE + 1;
    public static final int MSG_ERRORCODE = MSG_LOWPOWER_TOGLLE + 1;
    public static final int MSG_FIRMWARE = MSG_ERRORCODE + 1;
    public static final int MSG_NOTICATION_SWITCH = MSG_FIRMWARE + 1;
    public static final int MSG_NICEALARM_ALARM = MSG_NOTICATION_SWITCH + 1;
    public static final int MSG_ANTILOSS = MSG_NICEALARM_ALARM + 1;
    public static final int MSG_SEARCH = MSG_ANTILOSS + 1;
    public static final int MSG_SPORTS_TYPE = MSG_SEARCH + 1;
    public static final int MSG_SPORTS_GOALS = MSG_SPORTS_TYPE + 1;
    // achievement
    public static final int GET_ACHIEVEMENT_SUCCESS = MSG_SPORTS_GOALS + 1;
    public static final int GET_ACHIEVEMENT_FAIL = GET_ACHIEVEMENT_SUCCESS + 1;
    public static final int SEND_ACHIEVEMENT_SUCCESS = GET_ACHIEVEMENT_FAIL+ 1;
    public static final int SEND_ACHIEVEMENT_FAIL = SEND_ACHIEVEMENT_SUCCESS + 1;
    public static final int SEND_HISTORYDATA_SUCCESS = SEND_ACHIEVEMENT_FAIL + 1;
    public static final int SEND_HISTORYDATA_FAIL = SEND_HISTORYDATA_SUCCESS + 1;
    public static final int HOME_TIME_TASK = SEND_HISTORYDATA_FAIL + 1;
    public static final int HOME_STEP_TASK = HOME_TIME_TASK + 1;
    public static final int DURATION_TIME_FORMAT = HOME_STEP_TASK + 1;
    public static final int ACHIEVEMENT_TIME_TASK = DURATION_TIME_FORMAT + 1;
    public static final int HISTORY_DATA_TIME_TASK = ACHIEVEMENT_TIME_TASK + 1;
    public static final int GRAY_SERVICE_ID = HISTORY_DATA_TIME_TASK + 1;
    public static final int REQUEST_IGNORE_BATTERY_CODE = GRAY_SERVICE_ID + 1;
    public static final int JOB_ID = REQUEST_IGNORE_BATTERY_CODE + 1;

    public static final int GET_HISTROYDATA = JOB_ID + 1;
    public static final int GET_HISTROYDATA_FAIL = GET_HISTROYDATA + 1;
    public static final int GET_HISTROYDATA_SUCESS = GET_HISTROYDATA_FAIL + 1;
    public static final int CONVERT_DATABASE = GET_HISTROYDATA_SUCESS + 1;

    public static final String MY_ACHIEVEMENT_DETAIL = "MY_ACHIEVEMENT_DETAIL";

    //add by peng 20161003
    public static boolean isFirstConnect = true;

    //achievement数据
    public static final String ID="id";
    public static final String SERIANO="serialNo";
    public static final String DEGREE="degree";
    public static final String TYPE="type";
    public static final String REACHDATE="reachDate";
    public static final String CAREATEDATE="createDate";
    public static final String UPDATEDATE="updateDate";
    public static final String ISREACH="isReach";
    public static final String ACHIEVEMENT_DATABASE_NAME="achievement_table_test";
    public static final String ACHIEVEMENT_TABLE_NAME="achievement";


    public static final String GET_UPDATE_URI= SERVICER+"system/upgrade";
    public static final int GET_UPDATE_URI_FAIL = 104;
    public static final int GET_UPDATE_URI_SUCCESS = 105;

    // sxf add 0804
    public static final String FRESH_TOKEN=SERVICER+"/auth/refreshToken";

    public static final String IS_THIRD_PARTY_LOGIN = "isOnThirdPartyLogin";
    public static final String USER_UID = "useruid";
    private static void fillCheckSumByte(byte[] buf) {
        byte checksum;
        int i;
        checksum = 0;
        for (i = 0; i < buf.length - 1; i++)
            checksum = (byte) (checksum + buf[i]);
        checksum = (byte) (((~checksum) + 1) & 0x7F);
        buf[buf.length - 1] = checksum;
    }

    private static byte[] writeProtocolDataBytes(byte[] bytes) {
        int n = 0;
        int i, j, leastBit = 0;
        int bit7 = 0;
        int count = (bytes.length * 8 + 7 - 1) / 7;
        byte[] d = new byte[count];

        for (i = 0; i < bytes.length; i++) {
            for (j = 0; j < 8; j++) {
                leastBit = (bytes[i] >> j) & 0x01;
                d[n] |= leastBit << (bit7++);
                if (7 == bit7) {
                    bit7 = 0;
                    n++;
                }
            }
        }
        return d;
    }

    public static byte[] writeByte(byte header, byte[] data) {
//        Trace.e("test", "input " + CHexConver.byte2HexStr(data, data.length));
        byte[] encodeData = writeProtocolDataBytes(data);
//        Trace.e("test", "output " + CHexConver.byte2HexStr(encodeData, encodeData.length));
        final byte[] byte_send = new byte[3 + encodeData.length];
        byte_send[0] = header;
        byte_send[1] = (byte) (encodeData.length + 1);
        for (int i = 2; i < encodeData.length + 2; i++) {
            byte_send[i] = encodeData[i - 2];
        }
        fillCheckSumByte(byte_send);

        boolean isValid = isCheckSumValid(byte_send);
        if (!isValid) {
            throw new RuntimeException("runtime_exception");
        }
        return byte_send;
    }

    public static byte[] readProtocolDataBytes(byte[] s) {
        int n = 0;
        int bit8 = 0;
        int i, j;
        int leastBit = 0;
        int length = s.length;
        int count = length * 7 / 8;
        byte[] d = new byte[length];
        for (i = 0; i < length; i++) {
            for (j = 0; j < 7; j++) {
                leastBit = (s[i] >> j) & 0x01;
                d[n] |= leastBit << (bit8++);
                if (8 == bit8) {
                    bit8 = 0;
                    n++;
                }
            }
        }
        byte[] rt = new byte[count];
        System.arraycopy(d, 0, rt, 0, count);
        return rt;
    }


    public static byte[] stripByte(byte[] buf) {
        byte[] data = new byte[buf.length - 3];
        for (int i = 0; i < buf.length - 3; i++) {
            data[i] = buf[i + 2];
        }
        return data;
    }

    public static boolean isCheckSumValid(byte[] rcvBuff) {
        byte checksum;
        int i = 0;
        checksum = rcvBuff[0];
        for (i = 1; i < rcvBuff.length; i++) {
            if (rcvBuff[i] >= 0x80)
                return false;
            checksum = (byte) (checksum + rcvBuff[i]);
        }
        checksum &= 0x7F;
        if (0 == checksum)
            return true;
        return false;
    }

}
