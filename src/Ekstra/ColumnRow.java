package Ekstra;

public class ColumnRow {

	private int row;
	private int column;
	private String description;
	
	public ColumnRow(int row, int column, String description){
		this.column=column;
		this.row=row;
		this.description=description;
	}
	
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
