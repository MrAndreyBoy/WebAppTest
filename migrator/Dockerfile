FROM flyway/flyway:6.5.3
COPY --chown=flyway:flyway sql /flyway/sql/

USER flyway

ENTRYPOINT exec flyway \
    -url=${POSTGRESQL_URL} \
    -user=${POSTGRESQL_USER} \
    -password=${POSTGRESQL_PASSWORD} \
    -baselineOnMigrate=true \
    migrate
