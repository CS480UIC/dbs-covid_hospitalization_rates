## Glossary
1. [Entity](#Entity)
1. [Relationship](#Relationship)
1. [Attribute](#Attribute)
# Entity
- patient
  - Synonym:
  - Description: 
- hospital
  - Synonym: health center, infirmary
  - Description: an institution that is built, staffed, and equipped for the diagnosis of disease; for the treatment, both medical and surgical, of the sick and the injured; and for their housing during this process.
- country
  - Synonym:
  - Description: 
- room
  - Synonym: lodge, board, stay
  - Description: The room is the specific location in the hospital that a patient stays in and employees attend 
- bill
  - Synonym: invoice, statement
  - Description: an amount of money owed for goods supplied or services rendered, set out in a printed or written statement of charges.
- employee
  - Synonym: worker, staff
  - Description: An employee is a person who works at the hospital and may be a doctor, nurse, or from any other department in the hospital.
# Relationship
- patient_checkedinto_hospital 1(1)
- hospital_existsin_country 1(1)
- patient_staysin_room M(0)
- patient_receives_bill 1(1)
- employee_attendsto_room M(0) 
- employee_treats_patient M(0)
- employee_worksat_hospital 1(1)
# Attribute
- patient_id (pk) 1-1 (1)
- age M-1 (1)
- vaccination_status M-1 (1)
- preexisting_conditions M-M (0)
- hospitalization_date M-1 (1)
- hospital_id (pk) 1-1 (1)
- hospital_address 1-1 (1)
- hospital_name M-1 (1)
- country_id (pk) 1-1 (1)
- country_name 1-1 (1)
- population M-1 (0)
- room_number (pk) 1-1 (1)
- patient_id 1-M (1)
- employee_id 1-M (1)
- bill_id (pk) 1-1 (1)
- cost M-1 (1)
- patient_id 1-1 (1)
- employee_id (pk) 1-1 (1)
- name M-1 (1)
- department 1-1 (1)
