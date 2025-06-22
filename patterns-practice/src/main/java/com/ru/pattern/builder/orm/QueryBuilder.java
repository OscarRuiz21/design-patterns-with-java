package com.ru.pattern.builder.orm;

// QueryBuilder para construir consultas SQL
/**
 * Debe de tener los siguientes métodos:
 * - constructor(table: string)
 * - select(fields: string[]): QueryBuilder -- si no se pasa ningún campo, se seleccionan todos con el (*)
 * - where(condition: string): QueryBuilder - opcional
 * - orderBy(field: string, order: string): QueryBuilder - opcional
 * - limit(limit: number): QueryBuilder - opcional
 * - execute(): string - retorna la consulta SQL
 *
 ** Ejemplo de uso:
 const usersQuery = new QueryBuilder("users") // users es el nombre de la tabla
 .select("id", "name", "email")
 .where("age > 18")
 .where("country = 'Cri'")
 .orderBy("name", "ASC")
 .limit(10)
 .execute();

 console.log('Consulta: ', usersQuery);
 // Select id, name, email from users where age > 18 and country = 'Cri' order by name ASC limit 10;
 */

public class QueryBuilder {
    private final String table;
    private String[] fields = new String[0];
    private final StringBuilder conditions = new StringBuilder();
    private final StringBuilder orderFields = new StringBuilder();
    private Integer limitCount = null;

    public QueryBuilder(String table) {
        this.table = table;
    }

    public QueryBuilder select(String... fields) {
        if (fields.length == 0) {
            this.fields = new String[]{"*"};
        } else {
            this.fields = fields;
        }
        return this;
    }

    public QueryBuilder where(String condition) {
        if (conditions.length() > 0) {
            conditions.append(" AND ");
        }
        conditions.append(condition);
        return this;
    }

    public QueryBuilder orderBy(String field, String direction) {
        if (orderFields.length() > 0) {
            orderFields.append(", ");
        }
        orderFields.append(field).append(" ").append(direction.toUpperCase());
        return this;
    }

    public QueryBuilder limit(int count) {
        this.limitCount = count;
        return this;
    }

    public String execute() {
        StringBuilder query = new StringBuilder();

        // SELECT clause
        query.append("SELECT ");
        query.append(String.join(", ", fields));

        // FROM clause
        query.append(" FROM ").append(table);

        // WHERE clause
        if (conditions.length() > 0) {
            query.append(" WHERE ").append(conditions);
        }

        // ORDER BY clause
        if (orderFields.length() > 0) {
            query.append(" ORDER BY ").append(orderFields);
        }

        // LIMIT clause
        if (limitCount != null) {
            query.append(" LIMIT ").append(limitCount);
        }

        query.append(";");

        return query.toString();
    }
}
