package Calendar;

/**
 * The purpose of this class is to store the variables with getters and setters so they can get called from other classes
 * @author Mathias
 *
 */
public class ColumnRow {

	//Initializes variables
	private int row;
	private int column;
	private String description;
	
	//Creates the method ColumnRow with parameters
	public ColumnRow(int row, int column, String description){
		this.column=column;
		this.row=row;
		this.description=description;
	}
	
	//Getters & setters
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
