package hacker.l.venderapp.utilities;

import android.os.Environment;

public class Contants {
    public static final Boolean IS_DEBUG_LOG = true;

    public static final String LOG_TAG = "vender";
    public static final String APP_NAME = "appName"; // Do NOT change this value; meant for user preference
    public static final String DEFAULT_APPLICATION_NAME = "mom";
    public static final String APP_DIRECTORY = "/E" + DEFAULT_APPLICATION_NAME + "Directory/";
    public static final String DATABASE_NAME = "mom.db";// Environment.getExternalStorageDirectory() +  APP_DIRECTORY + "evergreen.db";

    public static String SERVICE_BASE_URL = "http://bhatiyacab.khudaganjup.com/API/";
    public static final int StoreId = 1;
    public static String outputBasePath = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String outputDirectoryLocation = outputBasePath + "/momUnzipped/";
    public static final String Dont_SEND_MESSAGE = "Please Try Again ";
    public static final String OFFLINE_MESSAGE = "Oops! You are Offline. Please check your Internet Connection.";
    public static final String Register = "setLogin.php";
    public static final String Login = "getLogin.php";
    public static final String VerifyOTP = "Login/VerifyOTP";
    public static final String menuList = "MenuMaster/GetAllMenuList";
    public static final String Category = "Category/GetAllCategoryList";
    public static final String GetAllLocationList = "LocationMaster/GetAllLocationList";
    public static final String GetAllDepartmentList = "LocationMaster/GetAllDepartmentList";
    public static final String CashierBySale = "MasterSummary/CashierBySale";
    public static final String CategoryBySale = "MasterSummary/CategoryBySale";
    public static final String BillBySale = "MasterSummary/BillNoBySale";
    public static final String TodayToLastWeekSale = "MasterSummary/TodayAndLastWeekSale";
    public static final String GetAllStoreByUser = "Store/GetAllStoreByUser";
    public static final String StockSummary = "StockMaster/StockSummary";


}
