package com.cartoonishvillain.coldsnaphorde.commands;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.commands.GiveCommand;
import net.minecraft.server.commands.TeleportCommand;
import org.jline.utils.Log;

public class SetHordeDefeatedLevel {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("coldsnaphorde").then(Commands.literal("setHighestTierDefeated").requires(cs -> cs.hasPermission(2))
                .then(Commands.argument("tier", IntegerArgumentType.integer(0, 3)).executes(context ->
                        setHorde(context.getSource(), IntegerArgumentType.getInteger(context, "tier"))))));
    }

    private static int setHorde(CommandSourceStack sourceStack, int level) {
        ColdSnapHorde.hordeDataManager.setHighestLevelBeaten(sourceStack.getServer(), level);
        sourceStack.sendSuccess(new TranslatableComponent("command.coldsnaphorde.setsuccess", level), false);
        return 0;
    }
}
