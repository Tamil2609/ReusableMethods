package selenium;

public class Check extends Reusable_Methods
{
    public static void main(String[] args) throws InterruptedException {
        Check run=new Check();
        run.launching();
        run.validateUrl(driver);
        run.validate_dialogbox_enabled(driver);
        run.validate_dialogbox_disable(driver);
        run.Login_LinkedIn(driver);
    }
}


