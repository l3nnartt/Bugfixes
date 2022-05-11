package com.github.l3nnartt.bugfixes;

import com.github.l3nnartt.bugfixes.updater.Authenticator;
import com.github.l3nnartt.bugfixes.updater.UpdateChecker;
import com.github.l3nnartt.bugfixes.utils.ButtonElement;
import com.github.l3nnartt.bugfixes.utils.LoggingUtil;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bugfixes extends LabyModAddon {

    private final ExecutorService exService = Executors.newSingleThreadExecutor();

    @Override
    public void onEnable() {
        exService.execute(new Authenticator());
        exService.execute(new UpdateChecker());
        LoggingUtil.info("Bugfixes has been enabled");
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings( List<SettingsElement> subSettings ) {
        subSettings.add(new ButtonElement("GitHub", () -> LabyMod.getInstance().openWebpage("https://github.com/l3nnartt/Bugfixes-1.8", false)));
    }
}