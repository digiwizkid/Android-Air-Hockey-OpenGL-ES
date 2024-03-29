package com.airhockey.android.objects;

import com.airhockey.android.data.VertexArray;
import com.airhockey.android.objects.ObjectBuilder.GeneratedData;
import com.airhockey.android.programs.ColorProgram;
import com.airhockey.android.util.Geometry;

import java.util.List;

public class Mallet {
    private static final int POSITION_COMPONENT_COUNT = 3;
    public final float radius;
    public final float height;
    private final VertexArray vertexArray;
    private final List<ObjectBuilder.DrawCommand> drawList;

    public Mallet(float radius, float height, int numPointsAroundMallet) {
        GeneratedData generatedData = ObjectBuilder.createMallet(new Geometry.Point(0f,
                0f, 0f), radius, height, numPointsAroundMallet);
        this.radius = radius;
        this.height = height;
        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorProgram colorProgram) {
        vertexArray.setVertexAttribPointer(
                0,
                colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT,
                0);
    }

    public void draw() {
        for (ObjectBuilder.DrawCommand drawCommand : drawList) {
            drawCommand.draw();
        }
    }
}
