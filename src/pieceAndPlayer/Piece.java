package pieceAndPlayer;

public class Piece {
	private int side1;
	private int side2;

	public int getSide1() {
		return this.side1;
	}

	public int getSide2() {
		return this.side2;
	}

	public void setSide1(int value) {
		this.side1 = value;
	}

	public void setSide2(int value) {
		this.side2 = value;
	}

// REGRAS PARA AVALIAÇÃO DE PEÇA
	public int rules() {
		if (this.side1 == this.side2) {
			return (this.side1 + this.side2) * 2;
		} else if (this.side1 % 2 != 0 && this.side2 % 2 != 0 && this.side1 != this.side2) {
			if (this.side1 > this.side2) {
				return (2 * this.side1) - this.side2;
			} else {
				return (2 * this.side2) - this.side1;
			}

		} else {
			return this.side1 + this.side2;
		}
	}

}
