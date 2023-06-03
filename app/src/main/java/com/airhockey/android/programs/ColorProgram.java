package com.airhockey.android.programs;

import android.content.Context;
import com.airhockey.android.R;

import static android.opengl.GLES20.*;

public class ColorProgram extends ShaderProgram {
    // Uniform locations
    private final int uMatrixLocation;
    // Attribute locations
    private final int aPositionLocation;
    private final int uColorLocation;

    public ColorProgram(Context context) {
        super(context, R.raw.simple_vertex_shader,
                R.raw.simple_fragment_shader);
        // Retrieve uniform locations for the shader program.
        uMatrixLocation = glGetUniformLocation(program, U_MATRIX);
        // Retrieve attribute locations for the shader program.
        aPositionLocation = glGetAttribLocation(program, A_POSITION);
        uColorLocation = glGetAttribLocation(program, U_COLOR);
    }

    public void setUniforms(float[] matrix, float r, float g, float b) {
        // Pass the matrix into the shader program.
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);
        glUniform4f(uColorLocation, r, g, b, 1f);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;
    }

    public int getColorAttributeLocation() {
        return uColorLocation;
    }
}