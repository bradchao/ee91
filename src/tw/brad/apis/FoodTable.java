package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FoodTable extends JTable {
	private FoodModel model;
	private FoodDB db;
	
	public FoodTable() {
		try {
			db = new FoodDB();
			db.query();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		model = new FoodModel();
		setModel(model);
		model.setColumnIdentifiers(db.getFieldNames());
	}
	
	public void delRow() {
		db.delData(getSelectedRow());
		repaint();
	}

	private class FoodModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}
		
		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}
		
	}
	
}
