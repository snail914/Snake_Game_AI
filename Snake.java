import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;
import java.util.HashSet;

class Snake implements Constants{
	private LinkedList<Cell> nodes;
	private HashSet<Integer> hashSet;

	public Snake(Cell node){
		nodes=new LinkedList<Cell>();
		hashSet=new HashSet<Integer>();
		addHead(node);
	}

	public Cell getHead(){
		return nodes.get(0);
	}

	public void addHead(Cell node){
		nodes.addFirst(node);
		hashSet.add(node.hashCode());
	}

	public Cell removeTail(){
		Cell node=nodes.removeLast();
		hashSet.remove(node.hashCode());
		return node;
	}

	public boolean contains(Cell node){
		return hashSet!=null && hashSet.contains(node.hashCode());
	}

	public void paint(Graphics g) {
          Graphics2D g2 = (Graphics2D) g;
          g.setColor(SNAKE_COLOR);
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);
    	  for (Cell cell : this.nodes) {
              g.fillOval(cell.getX()*CELL_EDGE_PIXELS, cell.getY()*CELL_EDGE_PIXELS, cell.getSize(), cell.getSize());
        }
	}
}