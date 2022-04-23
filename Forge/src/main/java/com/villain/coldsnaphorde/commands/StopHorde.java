package com.villain.coldsnaphorde.commands;

import com.cartoonishvillain.cartoonishhorde.Horde;
import com.mojang.brigadier.CommandDispatcher;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;

public class StopHorde {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("coldsnaphorde").then(Commands.literal("stopHorde").requires(cs -> {return cs.hasPermission(2);})
                .executes(context -> stopHorde(context.getSource()))));
    }

    private static int stopHorde(CommandSourceStack sourceStack) {
        if (ForgeColdSnapHorde.hordeDataManager.getCurrentHordeLevel() != 0) {
            switch (ForgeColdSnapHorde.hordeDataManager.getCurrentHordeLevel()) {
                case 1 -> {
                    ForgeColdSnapHorde.hordeTier1.Stop(Horde.HordeStopReasons.DEFEAT);
                }
                case 2 -> {
                    ForgeColdSnapHorde.hordeTier2.Stop(Horde.HordeStopReasons.DEFEAT);
                }
                case 3 -> {
                    ForgeColdSnapHorde.hordeTier3.Stop(Horde.HordeStopReasons.DEFEAT);
                }
            }
            sourceStack.sendSuccess(new TranslatableComponent("command.coldsnaphorde.stopsuccess"), false);
            ForgeColdSnapHorde.hordeDataManager.setCurrentHordeLevel(0);
        } else {
            sourceStack.sendFailure(new TranslatableComponent("command.coldsnaphorde.stopfailure"));
        }

        return 0;
    }
}
