package com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ColdSnapStabberModel<C extends GenericHordeMember> extends EntityModel<ColdSnapStabber> {
	private final ModelRenderer lowbody;
	private final ModelRenderer body;
	private final ModelRenderer left_hand;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer right_hand;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;

	public ColdSnapStabberModel() {
		texWidth = 128;
		texHeight = 128;

		lowbody = new ModelRenderer(this);
		lowbody.setPos(0.0F, 24.0F, 0.0F);
		lowbody.texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 13.0F, 0.0F);
		body.texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
		body.texOffs(0, 96).addBox(-2.9F, -4.3F, -2.9F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		body.texOffs(0, 80).addBox(-2.9F, -11.3F, -2.9F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		body.texOffs(32, 96).addBox(1.48F, -11.3F, 0.6F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setPos(4.5F, 5.7F, 0.0F);
		setRotationAngle(left_hand, 0.0F, 0.0F, 1.1345F);
		left_hand.texOffs(32, 0).addBox(-0.6105F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 3.3F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		head.texOffs(0, 60).addBox(-5.0F, -3.9F, -5.0F, 10.0F, 7.0F, 10.0F, -0.7F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.texOffs(63, 13).addBox(-5.0F, -8.1F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.texOffs(31, 11).addBox(-4.0F, -13.1F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setPos(-4.5F, 5.7F, 0.0F);
		setRotationAngle(right_hand, 0.0F, -0.2618F, 1.4835F);
		right_hand.texOffs(32, 0).addBox(-11.3895F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, true);

		bone = new ModelRenderer(this);
		bone.setPos(0.6F, 1.0F, 0.8F);
		right_hand.addChild(bone);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 3.1416F, 0.0F, 0.0F);
		cube_r1.texOffs(45, 35).addBox(-12.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, -0.1F, false);
		cube_r1.texOffs(56, 42).addBox(-12.0F, -0.4F, 6.6F, 2.0F, 1.0F, 4.0F, -0.1F, false);
		cube_r1.texOffs(50, 43).addBox(-11.1F, -0.4F, 2.8F, 2.0F, 1.0F, 4.0F, -0.1F, false);
		cube_r1.texOffs(44, 43).addBox(-12.0F, -0.4F, 2.8F, 2.0F, 1.0F, 4.0F, -0.1F, false);
	}

	@Override
	public void setupAnim(ColdSnapStabber entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
		float ANITIMER = entity.getANITIMER();

		if(ANITIMER > 0){
			if(ANITIMER > 10) this.right_hand.yRot -= 0.05236;
			else this.right_hand.yRot += 0.05236;
		}
		if(ANITIMER <= 0){
			this.right_hand.yRot = -0.2618F;
		}
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}