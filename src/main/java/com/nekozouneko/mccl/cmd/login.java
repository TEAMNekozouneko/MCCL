package com.nekozouneko.mccl.cmd;

import com.nekozouneko.mccl.MCCL;

import org.apache.commons.lang.RandomStringUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class login implements CommandExecutor, TabCompleter {

    private MCCL instance = MCCL.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String privkey = RandomStringUtils.random(6, "0123456789abcdefghijklmnopqrstuv")

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }
}
