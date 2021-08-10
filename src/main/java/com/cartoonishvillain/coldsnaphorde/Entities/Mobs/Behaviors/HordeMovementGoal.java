package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.vector.Vector3d;

import java.util.EnumSet;
import java.util.List;

//based on move towards raid goal
public class HordeMovementGoal<T extends GenericHordeMember> extends Goal {
    private final T Member;

    public HordeMovementGoal(T member){
        this.Member = member;
        this.setMutexFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean shouldExecute() {
        return this.Member.getTarget() != null && this.Member.isHordeMember() && this.Member.getAttackTarget() == null;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return this.Member.getTarget() != null && this.Member.isHordeMember() && this.Member.getAttackTarget() == null;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.Member.ticksExisted % 50 == 0){inviteNearbySnowmentoHorde();}
        if (!this.Member.hasPath()) {
            Vector3d vector3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.Member, 15, 4, Vector3d.copyCenteredHorizontally(Member.getTarget()));
            if (vector3d != null) {
                this.Member.getNavigator().tryMoveToXYZ(vector3d.x, vector3d.y, vector3d.z, 0.5D);
            }
        }
    }

    private void inviteNearbySnowmentoHorde(){
        List<GenericHordeMember> list = this.Member.world.getEntitiesWithinAABB(GenericHordeMember.class, this.Member.getBoundingBox().grow(8));
        for(GenericHordeMember snowman : list){
            if(snowman.getAttackTarget() == null && !snowman.isHordeMember() && snowman.getTarget() == null) snowman.toggleHordeMember(Member.getTarget());
        }
    }
}
