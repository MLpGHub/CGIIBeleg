varying vec4 color;

void main() {
	float z = 1.0f - (gl_ModelViewProjectionMatrix * gl_Vertex).z * 0.5f;
	color = vec4(0, z, z, 0);
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
}
