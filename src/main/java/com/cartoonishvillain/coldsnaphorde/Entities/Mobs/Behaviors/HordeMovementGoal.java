package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.util.math.vector.Vector3d;

import java.util.EnumSet;
import java.util.List;

//based on move towards raid goal
import net.minecraft.entity.ai.goal.Goal.Flag;

public class HordeMovementGoal<T extends GenericHordeMember> extends Goal {
    private final T Member;

    public HordeMovementGoal(T member){
        this.Member = member;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return this.Member.getLocTarget() != null && this.Member.isHordeMember() && this.Member.getTarget() == null;
    }

    @Override
    public boolean canContinueToUse() {
        return this.Member.getLocTarget() != null && this.Member.isHordeMember() && this.Member.getTarget() == null;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.Member.tickCount % 50 == 0){inviteNearbySnowmentoHorde();}
        if (!this.Member.isPathFinding()) {
            Vector3d vector3d = RandomPositionGenerator.getPosTowards(this.Member, 15, 4, Vector3d.atBottomCenterOf(Member.getLocTarget()));
            if (vector3d != null) {
                this.Member.getNavigation().moveTo(vector3d.x, vector3d.y, vector3d.z, 0.5D);
            }
        }
    }

    private void inviteNearbySnowmentoHorde(){
        List<GenericHordeMember> list = this.Member.level.getEntitiesOfClass(GenericHordeMember.class, this.Member.getBoundingBox().inflate(8));
        for(GenericHordeMember snowman : list){
            if(snowman.getTarget() == null && !snowman.isHordeMember() && snowman.getTarget() == null) snowman.toggleHordeMember(Member.getLocTarget());
        }
    }
}
