varying vec4 vcolor;

void main() {
	gl_Position = vec4(gl_Vertex.xy, 0, 1.0);
	gl_Position = vec4(0.1, 0.2, 0.0, 1.0);
	vcolor = vec4(0.8, 0.2, 0.3, 1.0);
}