package com.nekozouneko.mccl.cmd;

import com.google.gson.Gson;
import com.nekozouneko.mccl.MCCL;

import com.nekozouneko.mccl.lib.VerifyData;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.RandomStringUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class login implements CommandExecutor, TabCompleter {

    private MCCL instance = MCCL.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 認証コードを作成
        String privkey = RandomStringUtils.random(6, "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

        Player register;
        try {
            register = (Player) sender;
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "ユーザーでのみ実行可能です。");
            return true;
        }

        register.sendMessage(ChatColor.GREEN + "認証コードを生成中です...");

        VerifyData vd = new VerifyData();

        vd.setName(sender.getName());
        vd.setKey(privkey);
        vd.setTimestamp(new Date().getTime());

        Gson gson = new Gson();
        String output = gson.toJson(vd);

        File v = new File(instance.getDataFolder(), "auth.json");

        if (!instance.getDataFolder().exists()) {
            try {
                instance.getDataFolder().mkdir();
            } catch (Exception ignored) {}
        }

        try {
            FileWriter opf = new FileWriter(v);
            opf.write(output);
            opf.close();
        } catch (IOException e) {
            register.sendMessage("なんか跳ねられた"+e.getMessage());
        }

        BaseComponent code = new TextComponent(ChatColor.AQUA + privkey);
        code.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, privkey));

        BaseComponent ct = new TextComponent(ChatColor.GREEN + "認証コード: ");
        ct.addExtra(code);
        ct.addExtra("\n"+ChatColor.RED+"絶対に他人に公開しないでください。");

        register.spigot().sendMessage(ct);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }
}
