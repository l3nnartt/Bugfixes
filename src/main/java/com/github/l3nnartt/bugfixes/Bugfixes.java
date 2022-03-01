package com.github.l3nnartt.bugfixes;

import com.github.l3nnartt.bugfixes.updater.Authenticator;
import com.github.l3nnartt.bugfixes.updater.FileDownloader;
import com.github.l3nnartt.bugfixes.updater.UpdateChecker;
import net.labymod.addon.AddonLoader;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bugfixes extends LabyModAddon {

    private final ExecutorService exService = Executors.newSingleThreadExecutor();
    private static Bugfixes instance;
    private boolean labyAddons;

    @Override
    public void onEnable() {
        instance = this;
        exService.execute(new ServerFetcher(servers -> api.registerServerSupport(instance, new ServerSupport(servers))));
        exService.execute(new Authenticator());
        exService.execute(new UpdateChecker());

        //Download LabyAddons
        downloadLabAddons();

        getLogger("LabyAddons successfully downloaded");
    }

    @Override
    public void loadConfig() {
        this.labyAddons = getConfig().has("labyAddons") && getConfig().get("labyAddons").getAsBoolean();
    }

    @Override
    protected void fillSettings( List<SettingsElement> subSettings ) {

    }

    private void downloadLabAddons() {
        exService.execute(() -> {
            if (!labyAddons) {
                File labyAddons = new File(AddonLoader.getAddonsDirectory(), "LabyAddons.jar");
                boolean download = new FileDownloader("http://dl.lennartloesche.de/labyaddons/8/LabyAddons.jar", labyAddons).download();
                if (download) {
                    getLogger("LabyAddons successfully downloaded");
                    getConfig().addProperty("labyAddons", true);
                    saveConfig();
                }
            }
        });
    }

    public static void getLogger(String log) {
        String prefix = "[Bugfixes] ";
        System.out.println(prefix + log);
    }
}