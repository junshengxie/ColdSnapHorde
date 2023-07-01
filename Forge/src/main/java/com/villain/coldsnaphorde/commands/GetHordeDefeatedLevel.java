package com.villain.coldsnaphorde.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class GetHordeDefeatedLevel {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("coldsnaphorde").then(Commands.literal("getHighestTierDefeated").requires(cs -> {return cs.hasPermission(0);})
               .executes(context -> getHorde(context.getSource()))));
    }

    private static int getHorde(CommandSourceStack sourceStack) {
        sourceStack.sendSuccess(() -> Component.translatable("command.coldsnaphorde.getsuccess", ForgeColdSnapHorde.hordeDataManager.getHighestLevelBeaten()), false);
        return 0;
    }
}
