package cinema_reservations;

import java.time.LocalDate;

public class Projection {

	private int id;
	private int movie_id;
	private String type;
	private LocalDate date;
	private String time;

	public Projection() {

	}

	public Projection(int movie_id, String type, LocalDate date, String time) {
		super();
		this.movie_id = movie_id;
		this.type = type;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
