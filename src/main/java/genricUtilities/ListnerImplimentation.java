package genricUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplimentation implements ITestListener{
	
@Override
public void onStart(ITestContext context) {
	System.out.println("suite excution starts");
}
@Override
public void onTestStart(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+" Excution starts");
	
}
@Override
public void onTestSuccess(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Success");
}
@Override
public void onTestFailure(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Fail");
	System.out.println("Failed due to:"+result.getThrowable());
	WebDriverUtility web = new WebDriverUtility();
	web.captureScreenshot(BaseClass.sdriver,result.getMethod().getMethodName(),BaseClass.sjutil);

}
@Override
public void onTestSkipped(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Skipped");
	System.out.println("Skipped due to : "+result.getThrowable());
}
@Override
public void onFinish(ITestContext context) {
	System.out.println("Suite Excution TerminatesO");
}
}
