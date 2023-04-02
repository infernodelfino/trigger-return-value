package com.ata2.art22;

import org.hibernate.dialect.SQLServer2012Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class CustomSQLServerDialect extends SQLServer2012Dialect {

    public CustomSQLServerDialect() {
        super();
        registerFunction("concat", new StandardSQLFunction("concat", StandardBasicTypes.STRING));
    }

    @Override
    public String getSequenceNextValString(String sequenceName) {
        return "SET NOCOUNT OFF;\n" + super.getSequenceNextValString(sequenceName);
    }
}