package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.RandomPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;

//based on move towards raid goal
import net.minecraft.world.entity.ai.goal.Goal.Flag;

public class HordeMovementGoal<T extends GenericHordeMember> extends Goal {
    private final T Member;

    public HordeMovementGoal(T member){
        this.Member = member;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return this.Member.getLoc() != null && this.Member.isHordeMember() && this.Member.getTarget() == null;
    }

    @Override
    public boolean canContinueToUse() {
        return this.Member.getLoc() != null && this.Member.isHordeMember() && this.Member.getTarget() == null;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.Member.tickCount % 50 == 0){inviteNearbySnowmentoHorde();}
        if (!this.Member.isPathFinding()) {
            Vec3 vector3d = DefaultRandomPos.getPosTowards(this.Member, 15, 4, Vec3.atBottomCenterOf(Member.getLoc()), (double)((float)Math.PI / 10F));
            if (vector3d != null) {
                this.Member.getNavigation().moveTo(vector3d.x, vector3d.y, vector3d.z, 0.5D);
            }
        }
    }

    private void inviteNearbySnowmentoHorde(){
        List<GenericHordeMember> list = this.Member.level.getEntitiesOfClass(GenericHordeMember.class, this.Member.getBoundingBox().inflate(8));
        for(GenericHordeMember snowman : list){
            if(snowman.getLoc() == null && !snowman.isHordeMember() && snowman.getTarget() == null) snowman.toggleHordeMember(Member.getLoc());
        }
    }
}
