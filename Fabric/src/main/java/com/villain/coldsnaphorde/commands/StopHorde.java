package com.villain.coldsnaphorde.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.villain.cartoonishhorde.Horde;
import com.villain.coldsnaphorde.FabricColdSnapHorde;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class StopHorde {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("coldsnaphorde").then(Commands.literal("stopHorde").requires(cs -> {return cs.hasPermission(2);})
                .executes(context -> stopHorde(context.getSource()))));
    }

    private static int stopHorde(CommandSourceStack sourceStack) {
        if (FabricColdSnapHorde.hordeDataManager.getCurrentHordeLevel() != 0) {
            switch (FabricColdSnapHorde.hordeDataManager.getCurrentHordeLevel()) {
                case 1 -> {
                    FabricColdSnapHorde.hordeTier1.Stop(Horde.HordeStopReasons.DEFEAT);
                }
                case 2 -> {
                    FabricColdSnapHorde.hordeTier2.Stop(Horde.HordeStopReasons.DEFEAT);
                }
                case 3 -> {
                    FabricColdSnapHorde.hordeTier3.Stop(Horde.HordeStopReasons.DEFEAT);
                }
            }
            sourceStack.sendSuccess(Component.translatable("command.coldsnaphorde.stopsuccess"), false);
            FabricColdSnapHorde.hordeDataManager.setCurrentHordeLevel(0);
        } else {
            sourceStack.sendFailure(Component.translatable("command.coldsnaphorde.stopfailure"));
        }

        return 0;
    }
}
