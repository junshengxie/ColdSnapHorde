package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class EndHorde {
    public static class EndStabber extends ColdSnapStabber{
        public EndStabber(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(2);
        }
    }
    public static class EndGunner extends ColdSnapGunner {
        public EndGunner(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(2);
        }
    }
    public static class EndSnowballer extends ColdSnapSnowballer {
        public EndSnowballer(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(2);
        }
    }
    public static class EndGifter extends ColdSnapGifter {
        public EndGifter(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(2);
        }
    }
    public static class EndZapper extends ColdSnapZapper {
        public EndZapper(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(2);
        }
    }
    public static class EndBrawler extends ColdSnapBrawler {
        public EndBrawler(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(2);
        }
    }
}
