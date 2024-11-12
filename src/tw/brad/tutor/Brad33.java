package tw.brad.tutor;

public class Brad33 {

	public static void main(String[] args) {
		Graph g = new Graph() {
			@Override
			void drawLine() {
				System.out.println("drawLine");
			}
			@Override
			void drawCircle() {
				System.out.println("drawCircle");
			}
		};
		
		g.drawLine();
		g.drawCircle();
	}

}
abstract class Graph {
	abstract void drawLine();
	abstract void drawCircle();
}
