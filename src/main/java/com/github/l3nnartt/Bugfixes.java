package com.github.l3nnartt;

import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.SettingsElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bugfixes extends LabyModAddon {

    private final ExecutorService exService = Executors.newCachedThreadPool();
    private static Bugfixes instance;

    //Authenticator
    private Authenticator authenticator;

    @Override
    public void onEnable() {
        instance = this;
        authenticator = new Authenticator();

        api.registerServerSupport(this, new TestServer());
        request();
        System.out.println("Bugfixes erfolgreich aktiviert");
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings( List<SettingsElement> subSettings ) {

    }

    public static void request() {
        if (Bugfixes.getInstance().getAuthenticator().authenticate()) {
            Bugfixes.getInstance().getExService().execute(() -> {
                try {
                    HttpURLConnection con = (HttpURLConnection) (new URL(
                            "http://hosting151773.a2e37.netcup.net/lennart/timolia/addon/bugfixes.php?name=" + LabyMod.getInstance().getLabyModAPI().getPlayerUsername() + "&uuid=" + LabyMod.getInstance().getLabyModAPI().getPlayerUUID())).openConnection();
                    con.setRequestProperty("User-Agent",
                            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                    con.connect();
                    int code = con.getResponseCode();
                    if (code == 200) {
                        System.out.println("Bugfixes » Request successful");
                    } else {
                        System.out.println("FEHLERCODE:" + code);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static Bugfixes getInstance() {
        return instance;
    }

    public ExecutorService getExService() {
        return exService;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

}