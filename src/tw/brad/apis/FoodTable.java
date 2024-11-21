package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FoodTable extends JTable {
	private FoodModel model;
	
	public FoodTable() {
	
		model = new FoodModel();
		setModel(model);
	}

	private class FoodModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return 10;
		}
		
		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return String.format("%s:%d:%d", "brad", row, column);
		}
		
	}
	
}
