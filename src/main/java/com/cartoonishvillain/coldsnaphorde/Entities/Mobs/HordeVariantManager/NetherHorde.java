package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class NetherHorde {
    public static class NetherStabber extends ColdSnapStabber{
        public NetherStabber(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(1);
        }
    }
    public static class NetherGunner extends ColdSnapGunner {
        public NetherGunner(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(1);
        }
    }
    public static class NetherSnowballer extends ColdSnapSnowballer {
        public NetherSnowballer(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(1);
        }
    }
    public static class NetherGifter extends ColdSnapGifter {
        public NetherGifter(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(1);
        }
    }
    public static class NetherZapper extends ColdSnapZapper {
        public NetherZapper(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(1);
        }
    }
    public static class NetherBrawler extends ColdSnapBrawler {
        public NetherBrawler(EntityType<? extends MonsterEntity> type, World worldIn) {
            super(type, worldIn);
            setHordeVariant(1);
        }
    }
}
