package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class StandardHorde {
    public static class StandardStabber extends ColdSnapStabber{
        public StandardStabber(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(0);
        }
    }
    public static class StandardGunner extends ColdSnapGunner {
        public StandardGunner(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(0);
        }
    }
    public static class StandardSnowballer extends ColdSnapSnowballer {
        public StandardSnowballer(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(0);
        }
    }
    public static class StandardGifter extends ColdSnapGifter {
        public StandardGifter(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(0);
        }
    }
    public static class StandardZapper extends ColdSnapZapper {
        public StandardZapper(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(0);
        }
    }
    public static class StandardBrawler extends ColdSnapBrawler {
        public StandardBrawler(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(0);
        }
    }
}
