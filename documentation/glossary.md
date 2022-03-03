## Glossary
1. [Entity](#Entity)
1. [Relationship](#Relationship)
1. [Attribute](#Attribute)
2. [Miscellaneous](#Miscellaneous)
# Entity
- patient
  - Synonym: ill person, victim
  - Description: person being treated for COVID-19 at a hospital
- hospital
  - Synonym: health center, infirmary
  - Description: an institution that is built, staffed, and equipped for the diagnosis of disease; for the treatment, both medical and surgical, of the sick and the injured; and for their housing during this process.
- preexisiting_conditions
  - Synonyms: health standing, status
  - Description: Health risks or injuries that have occured or as still occuring for patient in hospital before contracting COVID
- country
  - Synonym: community, region
  - Description: A nation that has it's own government and population
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
- patient_has_preexisting_condition M(0)
# Attribute
- patient_id (pk) 1-1 (1) NOT NULL SMALLINT UNSIGNED
- age M-1 (1) NOT NULL SMALLINT UNSIGNED
- vaccination_status M-1 (1) NOT NULL VARCHAR(3)
- preexisting_conditions M-M (0) NULL VARCHAR(3)
  - condition_name 3-M (1) NOT NULL VARCHAR(60)
     - condition1 M-1 (1) NOT NULL VARCHAR(60)
     - condition2 M-1 (0) NULL VARCHAR(60)
     - condition3 M-1 (0) NULL VARCHAR(60)
- hospitalization_date M-1 (1) NOT NULL DATE
- hospital_id (pk) 1-1 (1) NOT NULL SMALLINT UNSIGNED
- hospital_address 1-1 (1) NOT NULL VARCHAR(100)
- hospital_name M-1 (1) NOT NULL VARCHAR(60)
- country_id (pk) 1-1 (1) NOT NULL SMALLINT UNSIGNED
- country_name 1-1 (1) NOT NULL VARCHAR(60)
- population M-1 (0) NULL INT
- room_number (pk) 1-1 (1) NOT NULL SMALLINT UNSIGNED
- patient_id 1-M (1) NOT NULL SMALLINT UNSIGNED
- employee_id 1-M (1) NOT NULL SMALLINT UNSIGNED
- bill_id (pk) 1-1 (1) NOT NULL SMALLINT UNSIGNED
- cost M-1 (1) NOT NULL INT
- patient_id 1-1 (1) NOT NULL SMALLINT UNSIGNED
- employee_id (pk) 1-1 (1) NOT NULL SMALLINT UNSIGNED
- name M-1 (1) NOT NULL VARCHAR(60)
- department 1-1 (1) NOT NULL VARCHAR(60)
# Miscellaneous
- Plural attribute: condition_name is a plural attrbiute because a patient can have multiple pre-existing conditions and therefore will need a place for these conditions to be listed.
