## Glossary
1. [Entity](#Entity)
1. [Relationship](#Relationship)
1. [Attribute](#Attribute)
# Entity
- patient
  - Synonym:
  - Description: 
- hospital
  - Synonym:
  - Description: 
- country
  - Synonym:
  - Description: 
# Relationship
- patient_checkedinto_hospital 1(1)
- hospital_existsin_country 1(1)
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
