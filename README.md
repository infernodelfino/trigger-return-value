# trigger-return-value

# Add trigger for insert, update
```sql
CREATE TRIGGER tr_jhi_user
ON jhi_user
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT 'inserted' AS action, inserted.*
        FROM inserted
    END;

    IF EXISTS(SELECT * FROM updated)
    BEGIN
        SELECT 'updated' AS action, updated.*
        FROM updated
    END;
END;
```
# Use this cURL to add data
curl --location 'http://localhost:8080/api/users' \
--header 'Content-Type: application/json' \
--data '{
    "name": "sa1"
}'

# This error will appear
com.microsoft.sqlserver.jdbc.SQLServerException: A result set was generated for update.

# If you try to get the entity and change it 
=> no error will pop but the entity will not be changed at all.
