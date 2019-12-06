import com.jvschool.rnd.api.Plugin;
import plugin.PluginLoader;
import plugin.PluginManager;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Plugin[] plugins = null;

        PluginManager pluginManager = new PluginManager(".\\Lesson7\\Plugins\\out\\");
        plugins = pluginManager.loadAllPlugins();

        for (int i = 0; i < plugins.length; i++) {
            plugins[i].run();
            plugins[i].close();
        }
    }
}
