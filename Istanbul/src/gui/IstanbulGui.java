package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import locations.Location;
import locations.LocationGui;
import logic.GameLogic;

/**
 * all x and y coordinates point to the upper left position of a component all
 * lists are treated as 0 being the bottom and size-1 being the top piece
 * 
 */
public class IstanbulGui extends JPanel {
	
	private static final long serialVersionUID = 3951307773685425235L;
	
	private static final int BOARD_START_X = 0;
	private static final int BOARD_START_Y = 0;

	private static final int SQUARE_WIDTH = 300;
	private static final int SQUARE_HEIGHT = 206;

	private static final int PIECE_WIDTH = 300;
	private static final int PIECE_HEIGHT = 206;
	
	private static final int PIECES_START_X = BOARD_START_X + (int)(SQUARE_WIDTH/2.0 - PIECE_WIDTH/2.0);
	private static final int PIECES_START_Y = BOARD_START_Y + (int)(SQUARE_HEIGHT/2.0 - PIECE_HEIGHT/2.0);
	
	private static final int DRAG_TARGET_SQUARE_START_X = BOARD_START_X - (int)(PIECE_WIDTH/2.0);
	private static final int DRAG_TARGET_SQUARE_START_Y = BOARD_START_Y - (int)(PIECE_HEIGHT/2.0);

	private Image imgBackground;
	
	private GameLogic chessGame;
	private List<LocationGui> guiPieces = new ArrayList<LocationGui>();

	public IstanbulGui() {
		this.setLayout(null);

		// background
		URL urlBackgroundImg = getClass().getResource("/img/bo.png");
		this.imgBackground = new ImageIcon(urlBackgroundImg).getImage();

		// create chess game
		this.chessGame = new GameLogic();
		
		//wrap game pieces into their graphical representation
		for (Location piece : this.chessGame.getLocations()) {
			createAndAddGuiPiece(piece);
		}

		JFrame f = new JFrame();
		f.setSize(80, 80);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.setSize(imgBackground.getWidth(null), imgBackground.getHeight(null));
	}

	private void createAndAddGuiPiece(Location piece) {
		Image img = this.getImageForPiece(piece.getName());
		LocationGui guiPiece = new LocationGui(img, piece);
		this.guiPieces.add(guiPiece);
	}

	private Image getImageForPiece(String type) {

		String filename = type+".png";

		URL urlPieceImg = getClass().getResource("/img/" + filename);
		return new ImageIcon(urlPieceImg).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, null);

		for (LocationGui guiPiece : this.guiPieces) {
				g.drawImage(guiPiece.getImage(), guiPiece.getX(), guiPiece.getY(), null);
		}
	}

	public static void main(String[] args) {
		new IstanbulGui();
	}
	
	public static int convertColumnToX(int column){
		return PIECES_START_X + SQUARE_WIDTH * column;
	}
	
	public static int convertRowToY(int row){
		return PIECES_START_Y + SQUARE_HEIGHT * (Location.ROW_4 - row);
	}
	
	public static int convertXToColumn(int x){
		return (x - DRAG_TARGET_SQUARE_START_X)/SQUARE_WIDTH;
	}
	
	public static int convertYToRow(int y){
		return Location.ROW_4 - (y - DRAG_TARGET_SQUARE_START_Y)/SQUARE_HEIGHT;
	}

}
