
public class Vertax {
	private Vertax parent;
	private Vertax leftV,rightV;
	private int score;
	private boolean visited;
	
	public Vertax(int score, Vertax parent , Vertax leftV, Vertax rightV) {
		super();
		this.score = score;
		this.parent = parent;
		this.leftV = leftV;
		this.rightV = rightV;
	}

	public Vertax getParent() {
		return parent;
	}
	public void setParent(Vertax parent) {
		this.parent = parent;
	}
	public Vertax getLeftV() {
		return leftV;
	}
	public void setLeftV(Vertax leftV) {
		this.leftV = leftV;
	}
	public Vertax getRightV() {
		return rightV;
	}
	public void setRightV(Vertax rightV) {
		this.rightV = rightV;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}
