package com.github.l3nnartt;

import com.google.gson.JsonObject;
import net.labymod.api.events.TabListEvent;
import net.labymod.api.permissions.Permissions;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.PacketBuffer;
import java.util.List;

public class TestServer extends Server {

    public TestServer() {
        super( "Bugfixes", "%.pvpgym.net", "pvpgym.net", "gommehd.net", "hypixel.net", "4renagang.aternos.me", "skywars.world", "royalpixels.de", "antiac.net", "minemen.club", "hypixel.net", "mc.hypixel.net", "lunar.gg" );
    }

    public boolean isAllowed(Permissions.Permission permission) {
        return true;
    }

    @Override
    public void onJoin( ServerData serverData ) {

    }

    @Override
    public ChatDisplayAction handleChatMessage( String clean, String formatted ) throws Exception {
        return ChatDisplayAction.NORMAL;
    }

    @Override
    public void handlePluginMessage( String channelName, PacketBuffer packetBuffer ) throws Exception {
    }

    @Override
    public void handleTabInfoMessage( TabListEvent.Type tabInfoType, String formattedText, String unformattedText ) throws Exception {

    }

    @Override
    protected void initConfig( JsonObject config ) {
    }

    @Override
    public void fillSubSettings( List<SettingsElement> subSettings ) {
    }

    @Override
    public void addModuleLines( List<DisplayLine> lines ) {
    }
}