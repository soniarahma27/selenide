# ISP Documentation for match(TextCheck textCheck, String actualText, String expectedText)
Pada direktori src/main/java/com/codeborne/selenide/conditions/CaseInsensitiveTextCondition.java

## Input Domain Model

| Characteristics        | b1    | b2           | b3              |
|------------------------|-------|--------------|-----------------|
| textCheck FULL_TEXT    | Valid | Invalid Word |                 |
| textCheck PARTIAL_TEXT | Valid | Invalid Word |                 |
| equals                 | Valid | Invalid Word | Invalid Command |
| contains               | Valid | Invalid Word | Invalid Command |



## IDM Relabeling Table

| Characteristics | b1  | b2  | b3  |
|-----------------|-----|-----|-----|
| A               | A1  | A2  |     |
| B               | B1  | B2  |     |
| C               | C1  | C2  | C3  |
| D               | D1  | D2  | D3  |

## Constraints

- Method hanya menjalankan salah satu condition dari tipe textCheck dan salah satu method equals atau contains. 
Sehingga ada 2 characteristik yang selalu valid.


## Test Values and Example I/O

Criteria Used: BCC


| Test Value | Example Input                        | Expected Output |
|------------|--------------------------------------|-----------------|
| A1B1C1D3   | match(FULL_TEXT,hello,hello)         | True            |
| A1B2C2D3   | match(FULL_TEXT,hello,world)         | False           |
| A2B1C3D1   | match(PARTIAL_TEXT,helloworld,hello) | True            |
| A2B1C3D2   | match(PARTIAL_TEXT,hello,world)      | False           |
