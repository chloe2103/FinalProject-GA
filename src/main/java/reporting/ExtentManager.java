package reporting;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");
            String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
            extent = new ExtentReports(System.getProperty("user.dir")+"/Extent-Report/ExtentReport "+df+".html", true);
            Reporter.log("Extent Report Directory"+ resultDirectory, true);
            extent.addSystemInfo("Host Name", "PNT").addSystemInfo("Environment","QA")
                    .addSystemInfo("User Name", "Chloe Hoang");
            extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        ExtentManager.context = context;

    }
}