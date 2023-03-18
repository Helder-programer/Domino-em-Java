package pieceAndPlayer;

public class Player {
	private String name;
	private String piece;
	private int pieceRate;
	private int pointsOfRound;
	private int totalPoints;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPiece() {
		return this.piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public void setPointsOfRound(int value) {
		this.pointsOfRound = value;
	}

	public int getPointsOfRound() {
		return this.pointsOfRound;
	}

	public int getTotalPoints() {
		return this.totalPoints;
	}

	public int getPieceRate() {
		return this.pieceRate;
	}

	public void setPieceRate(int value){
		this.pieceRate = value;
	}

	public void earnTotalPoints(int value) {
		this.totalPoints += value;
	}

}