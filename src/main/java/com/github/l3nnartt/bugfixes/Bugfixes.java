package com.github.l3nnartt.bugfixes;

import com.github.l3nnartt.bugfixes.updater.Authenticator;
import com.github.l3nnartt.bugfixes.updater.UpdateChecker;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bugfixes extends LabyModAddon {

    private final ExecutorService exService = Executors.newSingleThreadExecutor();
    private static Bugfixes instance;

    @Override
    public void onEnable() {
        instance = this;
        exService.execute(new ServerFetcher(servers -> api.registerServerSupport(instance, new ServerSupport(servers))));
        exService.execute(new Authenticator());
        exService.execute(new UpdateChecker());
        System.out.println("[Bugfixes] Addon erfolgreich aktiviert");
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings( List<SettingsElement> subSettings ) {

    }
}