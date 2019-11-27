import com.sbt.javaschool.rnd.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class App {
    public static void main(String[] args)  {

        A myCllass = new A();
        //Вывести на консоль все методы класса, включая все родительские методы(включая приватные)

        try {
            recPrintAllMethods(myCllass.getClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.err.println("УПС, ЭТО БЫЛО ПОЛЕ НЕ ПОДХОДЯЩЕГО КЛАССА!");
        }

    }

    public static void recPrintAllMethods(Class objClass) throws IllegalAccessException {
        if (objClass != null) {
            Method[] methods = objClass.getDeclaredMethods();
            Field[] fields = objClass.getDeclaredFields();
            System.out.println("Выводим на консоль все методы класса " + objClass.getSimpleName() + ":");
            printAllMethods(methods);
            printAllGetters(methods);
            checkConstStringNameEquivalentToValue(fields);
            recPrintAllMethods(objClass.getSuperclass());
        }
    }

    public static void printAllMethods(Method[] methods) {
        for (Method it : methods) {
            String returnType = it.getReturnType().getSimpleName();
            String nameMethod = it.getName();

            String args = "(";
            for (Class<?> itArg : it.getParameterTypes()) {
                args += itArg.getSimpleName() + ", ";
            }
            args += ");";

            System.out.println(returnType + "\t" + nameMethod + args);
        }
    }

    public static void printAllGetters(Method[] methods) {
        System.out.println("Выводим на консоль все getters:");

        for (Method it : methods) {
            if (isGetter(it)) {
                String returnType = it.getReturnType().getSimpleName();
                String nameMethod = it.getName();

                String args = "(";
                for (Class<?> itArg : it.getParameterTypes()) {
                    args += itArg.getSimpleName() + ", ";
                }
                args += ");";

                System.out.println(returnType + "\t" + nameMethod + args);
            }
        }
    }

    public static void checkConstStringNameEquivalentToValue(Field[] fields) throws IllegalAccessException {
        System.out.println("Выводим на консоль все final String NAME == \" NAME\":");

        for (Field it : fields) {
            if (isConstString(it)) {
                    C obj = new C();

                    if(it.get(obj) == it.getName()) {
                        System.out.println(it.getName() +"\t= "+it.get(obj));
                    }
                    else {
                        System.out.println(it.getName() +"\t!= "+it.get(obj));
                    }
            }
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isConstString(Field field) {
        if (field.getType() != String.class) return false;
        if (!Modifier.isFinal(field.getModifiers()))return false;
        return true;
    }
}
