package tw.brad.tutor;

/*
    SELECT e.EmployeeID,e.LastName,SUM(od.UnitPrice*od.Quantity) rev
	FROM orders o
	JOIN orderdetails od ON (o.OrderID = od.OrderID)
	JOIN employees e ON (o.EmployeeID = e.EmployeeID)
	GROUP BY o.EmployeeID
	ORDER BY rev DESC
	
	4 Peacock 250187.4500
	
	驗算
	SELECT SUM(UnitPrice*Quantity) SUM FROM orderdetails
	WHERE OrderID IN (
		SELECT OrderID FROM orders WHERE EmployeeID = 4
	)
 */
public class Brad75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
