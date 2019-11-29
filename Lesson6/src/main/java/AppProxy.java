
import com.sbt.javaschool.rnd.*;
import com.sun.deploy.net.proxy.ProxyUtils;

import java.lang.reflect.Proxy;

public class AppProxy {
    public static void main(String[] args) throws IllegalAccessException {
        A days1 = new A();// имплементировать AlphabetWeek должен именно этот класс "А", а не В и не С!
        days1.getAllDays();
        days1.getNumberDay("MONDAY");

        AlphabetSuper proxyDays = (AlphabetSuper) Proxy.newProxyInstance(A.class.getClassLoader(), A.class.getInterfaces(), new MyInvocationHandler(days1));

        System.out.println(proxyDays.getAllDays());

        System.out.println(proxyDays.getNumberDay("Moday"));
    }
}
