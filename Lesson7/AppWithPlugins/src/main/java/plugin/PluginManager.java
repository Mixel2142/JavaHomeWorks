package plugin;

import com.jvschool.rnd.api.Plugin;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
       return null;
    }

    public Plugin[] loadAllPlugins() {
            return PluginLoader.initAsPlugins(PluginLoader.loadAllClasses(pluginRootDirectory));
    }

}
