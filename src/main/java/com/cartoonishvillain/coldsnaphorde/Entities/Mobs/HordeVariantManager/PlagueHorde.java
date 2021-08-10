package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class PlagueHorde {
    public static class PlagueStabber extends ColdSnapStabber{
        public PlagueStabber(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(3);
        }
    }
    public static class PlagueGunner extends ColdSnapGunner {
        public PlagueGunner(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(3);
        }
    }
    public static class PlagueSnowballer extends ColdSnapSnowballer {
        public PlagueSnowballer(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(3);
        }
    }
    public static class PlagueGifter extends ColdSnapGifter {
        public PlagueGifter(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(3);
        }
    }
    public static class PlagueZapper extends ColdSnapZapper {
        public PlagueZapper(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(3);
        }
    }
    public static class PlagueBrawler extends ColdSnapBrawler {
        public PlagueBrawler(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(3);
        }
    }
}
