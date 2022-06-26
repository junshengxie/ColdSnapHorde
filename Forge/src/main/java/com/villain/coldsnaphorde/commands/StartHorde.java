package com.villain.coldsnaphorde.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.jline.utils.Log;

public class StartHorde {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("coldsnaphorde").then(Commands.literal("startHorde").requires(cs -> {return cs.hasPermission(2);})
                .then(Commands.argument("tier", IntegerArgumentType.integer(1, 3)).executes(context ->
                        startHorde(context.getSource(), IntegerArgumentType.getInteger(context, "tier"))))));
    }

    private static int startHorde(CommandSourceStack sourceStack, int level) {
        if (ForgeColdSnapHorde.hordeDataManager.getCurrentHordeLevel() == 0) {
            try {
                switch (level) {
                    case 1 -> {
                        ForgeColdSnapHorde.hordeTier1.SetUpHorde(sourceStack.getPlayerOrException());
                    }
                    case 2 -> {
                        ForgeColdSnapHorde.hordeTier2.SetUpHorde(sourceStack.getPlayerOrException());
                    }
                    case 3 -> {
                        ForgeColdSnapHorde.hordeTier3.SetUpHorde(sourceStack.getPlayerOrException());
                    }
                }
                ForgeColdSnapHorde.hordeDataManager.setCurrentHordeLevel(level);
                sourceStack.sendSuccess(Component.translatable("command.coldsnaphorde.startsuccess", level), false);
            } catch (CommandSyntaxException e) {
                Log.error("startHorde can only be run by live players. Apologies for the inconvenience!");
            }
        } else {
            sourceStack.sendFailure(Component.translatable("command.coldsnaphorde.startfailure"));
        }

        return 0;
    }
}
