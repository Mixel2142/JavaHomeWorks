import com.jvschool.rnd.api.Plugin;
import plugin.PluginLoader;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Plugin[] plugins = null;
        try {
            plugins = PluginLoader.initAsPlugin(PluginLoader.loadDirectoryC(".\\Lesson7\\Plugins\\out\\", "MANIFEST.MF"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < plugins.length; i++) {
            plugins[i].run();
            plugins[i].close();
        }
    }
}
