
public class Coordinates {
    private int rowIndex;
    private int columnIndex;

    public Coordinates(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String toString() {
        return "rowIndex: " + this.rowIndex + " columnIndex: " + this.columnIndex;
    }
}