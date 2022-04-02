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
    
CREATE VIEW suhabe_simple AS
    	SELECT patient_id
    FROM patient
    WHERE age > '70'
    ORDER BY age;
    
CREATE VIEW suhabe_aggregate AS
    	SELECT COUNT(hospitalization_date)
    FROM patient
    WHERE hospitalization_date > '12/04/2021 12:00:00 AM'
    ORDER BY hospitalization_date;
    
CREATE VIEW suhabe_complex AS
    	SELECT patient_id
    FROM patient
    WHERE EXISTS (
        	SELECT condition_id, condition_name
        FROM patient_preexisting_conditions
        WHERE condition_name = 'diabetes');

CREATE VIEW maseeh_simple AS
    SELECT *
    FROM bill
    WHERE cost > 100
    ORDER BY cost;

CREATE VIEW maseeh_aggregate AS
    SELECT AVG(cost)
    FROM bill;

CREATE VIEW maseeh_complex AS
    SELECT cost, 
    FROM bill
    WHERE cost > (
        SELECT AVG(cost)
        FROM bill);
