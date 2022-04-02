CREATE VIEW hannah_simple AS
	SELECT department
    FROM employee
    WHERE department = "nursing" OR department = "outpatient"
    ORDER BY employee_id;
    
CREATE VIEW hannah_aggregate AS
	SELECT UPPER(room_number)
    FROM room
    GROUP BY employee_id;
    
CREATE VIEW hannah_complex AS
	SELECT employee_name, room_number
    FROM employee
    INNER JOIN room
    ON employee.employee_id = room.employee_id;