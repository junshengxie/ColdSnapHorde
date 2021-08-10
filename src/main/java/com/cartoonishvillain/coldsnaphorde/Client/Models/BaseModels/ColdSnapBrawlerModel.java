package com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapBrawler;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ColdSnapBrawlerModel<C extends GenericHordeMember> extends EntityModel<ColdSnapBrawler> {
	private final ModelRenderer lowbody;
	private final ModelRenderer body;
	private final ModelRenderer left_hand;
	private final ModelRenderer lglove;
	private final ModelRenderer cube_r1;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer right_hand;
	private final ModelRenderer lglove2;
	private final ModelRenderer cube_r2;

	public ColdSnapBrawlerModel() {
		textureWidth = 128;
		textureHeight = 128;

		lowbody = new ModelRenderer(this);
		lowbody.setRotationPoint(0.0F, 24.0F, 0.0F);
		lowbody.setTextureOffset(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 13.0F, 0.0F);
		body.setTextureOffset(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setRotationPoint(4.5F, 5.8F, 0.0F);
		setRotationAngle(left_hand, -1.1007F, 1.2321F, -0.6458F);
		left_hand.setTextureOffset(32, 0).addBox(-0.5F, -0.5F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		lglove = new ModelRenderer(this);
		lglove.setRotationPoint(7.2F, 0.857F, -0.075F);
		left_hand.addChild(lglove);
		setRotationAngle(lglove, 2.4739F, 0.2217F, 0.2719F);
		lglove.setTextureOffset(48, 48).addBox(-0.5F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, -0.5F, false);
		lglove.setTextureOffset(48, 55).addBox(-1.3F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, -0.6F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.8F, 0.1046F, 1.6954F);
		lglove.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1719F, -0.7703F, -0.2444F);
		cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -1.8F, 2.0F, 1.0F, 2.0F, -0.2F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		head.setTextureOffset(0, 60).addBox(-4.0F, -8.4F, -4.0F, 8.0F, 8.0F, 8.0F, -0.3F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.setTextureOffset(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.setTextureOffset(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(-4.5F, 5.8F, 0.0F);
		setRotationAngle(right_hand, -1.1007F, -1.2321F, 0.6458F);
		right_hand.setTextureOffset(32, 0).addBox(-11.5F, -0.5F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, true);

		lglove2 = new ModelRenderer(this);
		lglove2.setRotationPoint(-7.2F, 0.857F, -0.075F);
		right_hand.addChild(lglove2);
		setRotationAngle(lglove2, 2.4739F, -0.2217F, -0.2719F);
		lglove2.setTextureOffset(48, 48).addBox(-4.5F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, -0.5F, true);
		lglove2.setTextureOffset(48, 55).addBox(-3.7F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, -0.6F, true);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.8F, 0.1046F, 1.6954F);
		lglove2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1719F, 0.7703F, 0.2444F);
		cube_r2.setTextureOffset(0, 0).addBox(-1.5F, -0.5F, -1.8F, 2.0F, 1.0F, 2.0F, -0.2F, true);
	}

	@Override
	public void setRotationAngles(ColdSnapBrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}