package cinema_reservations;

public class Reservation {
	
	private int id;
	private String name;
	private int projection_id;
	private int row;
	private int col;
	
	public Reservation() {
		
	}
	
	public Reservation(String name, int projection_id, int row, int col) {
		super();
		this.name = name;
		this.projection_id = projection_id;
		this.row = row;
		this.col = col;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjection_id() {
		return projection_id;
	}

	public void setProjection_id(int projection_id) {
		this.projection_id = projection_id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	

}
