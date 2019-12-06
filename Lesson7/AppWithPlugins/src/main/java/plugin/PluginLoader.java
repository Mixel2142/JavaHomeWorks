package plugin;

import com.jvschool.rnd.api.Plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader extends ClassLoader {

    final static String config = "MANIFEST.MF";

    @Override
    public Class<?> loadClass(String dir) {
        try {
            return loadClass(new File(dir));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Class is not found!");
        }
        return null;
    }

    private static Class<?> loadClass(File dir) throws IOException, ClassNotFoundException {
        final JarFile jf = new JarFile(dir);
        final JarEntry je = jf.getJarEntry(config);

        final BufferedReader br = new BufferedReader(new InputStreamReader(jf.getInputStream(je)));

        final HashMap<String, String> data = new HashMap<>();

        String in;
        while ((in = br.readLine()) != null) {
            if (in.isEmpty() || in.startsWith("#"))
                continue;
            final String[] split = in.split(" ");
            data.put(split[0], split[1]);
        }

        jf.close();

        return Class.forName(data.get("Magic:"), true, new URLClassLoader(new URL[]{dir.toURI().toURL()})); // URLClassLoader поменять на EncryptedClassLoader если нужно расшифровать
    }

    public static Class<?>[] loadAllClasses(String dir) {
        try {
            return loadAllClasses(new File(dir));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Class is not found!");
        }
        return null;
    }

    private static Class<?>[] loadAllClasses(File dir) throws ClassNotFoundException, IOException {
        final File[] files = dir.listFiles();

        final Class<?>[] classes = new Class<?>[files.length];

        for (int i = 0; i < files.length; i++)
            classes[i] = loadClass(files[i]);

        return classes;
    }

    private static Plugin initAsPlugin(Class<?> group) {
        try {
            return (Plugin) group.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Plugin[] initAsPlugins(Class<?>[] group) {
        final Plugin[] plugins = new Plugin[group.length];
        for (int i = 0; i < group.length; i++)
            plugins[i] = initAsPlugin(group[i]);

        return plugins;
    }

}
