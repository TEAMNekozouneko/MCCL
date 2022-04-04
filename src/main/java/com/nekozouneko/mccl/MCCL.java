package com.nekozouneko.mccl;

import com.nekozouneko.mccl.cmd.login;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCCL extends JavaPlugin {

    public static MCCL instance;

    public static MCCL getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("login").setExecutor(new login());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
