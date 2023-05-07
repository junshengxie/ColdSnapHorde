package com.villain.coldsnaphorde.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import com.villain.villainoushordemanager.hordes.EntityTypeHorde;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import com.villain.villainoushordemanager.hordes.EntityEnumHorde;


public class StopHorde {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("coldsnaphorde").then(Commands.literal("stopHorde").requires(cs -> {return cs.hasPermission(2);})
                .executes(context -> stopHorde(context.getSource()))));
    }

    private static int stopHorde(CommandSourceStack sourceStack) {
        if (ForgeColdSnapHorde.hordeDataManager.getCurrentHordeLevel() != 0) {
            switch (ForgeColdSnapHorde.hordeDataManager.getCurrentHordeLevel()) {
                case 1 -> {
                    ForgeColdSnapHorde.hordeTier1.Stop(EntityTypeHorde.HordeStopReasons.DEFEAT);
                }
                case 2 -> {
                    ForgeColdSnapHorde.hordeTier2.Stop(EntityEnumHorde.HordeStopReasons.DEFEAT);
                }
                case 3 -> {
                    ForgeColdSnapHorde.hordeTier3.Stop(EntityEnumHorde.HordeStopReasons.DEFEAT);
                }
            }
            sourceStack.sendSuccess(Component.translatable("command.coldsnaphorde.stopsuccess"), false);
            ForgeColdSnapHorde.hordeDataManager.setCurrentHordeLevel(0);
        } else {
            sourceStack.sendFailure(Component.translatable("command.coldsnaphorde.stopfailure"));
        }

        return 0;
    }
}
