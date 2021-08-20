package com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ColdSnapGifterModel<C extends GenericHordeMember> extends EntityModel<ColdSnapGifter> {
	private final ModelRenderer lowbody;
	private final ModelRenderer body;
	private final ModelRenderer right_hand;
	private final ModelRenderer left_hand;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer present;
	private final ModelRenderer bow2_r1;
	private final ModelRenderer bow1_r1;

	public ColdSnapGifterModel() {
		texWidth = 128;
		texHeight = 128;

		lowbody = new ModelRenderer(this);
		lowbody.setPos(0.0F, 24.0F, 0.0F);
		lowbody.texOffs(0, 0).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 13.0F, 0.0F);
		body.texOffs(0, 24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setPos(-5.0F, 6.0F, 0.0F);
		setRotationAngle(right_hand, 0.0F, -1.5272F, 0.0F);
		right_hand.texOffs(48, 11).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setPos(5.0F, 6.0F, 0.0F);
		setRotationAngle(left_hand, 0.0F, 1.5272F, 0.0F);
		left_hand.texOffs(48, 11).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, true);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 4.0F, 0.0F);
		head.texOffs(40, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		head.texOffs(0, 0).addBox(-0.95F, -4.05F, -4.45F, 1.0F, 1.0F, 1.0F, -0.05F, false);
		head.texOffs(4, 0).addBox(-0.95F, -4.05F, -5.35F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.texOffs(30, 34).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.texOffs(0, 44).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

		present = new ModelRenderer(this);
		present.setPos(-0.45F, 7.0F, -10.0F);
		present.texOffs(32, 46).addBox(-5.0F, -3.0F, -3.0F, 11.0F, 3.0F, 5.0F, -0.1F, false);
		present.texOffs(36, 0).addBox(-6.0F, -5.0F, -4.0F, 13.0F, 4.0F, 7.0F, -0.6F, false);

		bow2_r1 = new ModelRenderer(this);
		bow2_r1.setPos(0.5F, -4.4F, -0.5F);
		present.addChild(bow2_r1);
		setRotationAngle(bow2_r1, 0.0F, -0.7418F, 0.0F);
		bow2_r1.texOffs(0, 58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, -0.5F, false);

		bow1_r1 = new ModelRenderer(this);
		bow1_r1.setPos(0.5F, -4.4F, -0.5F);
		present.addChild(bow1_r1);
		setRotationAngle(bow1_r1, 0.0F, 0.7418F, 0.0F);
		bow1_r1.texOffs(0, 58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, -0.5F, false);
	}

	@Override
	public void setupAnim(ColdSnapGifter entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		present.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}