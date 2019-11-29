import com.sbt.javaschool.rnd.A;
import com.sbt.javaschool.rnd.AlphabetSuper;
import com.sbt.javaschool.rnd.MyInvocationHandler;
import com.sbt.javaschool.rnd.ProxyUtils;

public class AppCache {
    public static void main(String[] args) throws IllegalAccessException {
        A day = new A();
        AlphabetSuper cacheDays =  ProxyUtils.makeCached(day);
        System.out.println(cacheDays.getNumberDay("MONDAY"));
        System.out.println(cacheDays.getNumberDay("MONDAY"));
        System.out.println(cacheDays.getNumberDay("лвов"));
        System.out.println(cacheDays.getNumberDay("лвов"));
        System.out.println(cacheDays.getAllDays());
        System.out.println(cacheDays.getAllDays());
    }
}
