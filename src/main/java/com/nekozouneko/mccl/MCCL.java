package com.nekozouneko.mccl;

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

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
