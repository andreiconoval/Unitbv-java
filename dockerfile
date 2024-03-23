FROM payara/server-full

EXPOSE 4848 8080

COPY EJBEar.ear $DEPLOY_DIR

ENV LIB_DIR ${PAYARA_DIR}/glassfish/lib/
COPY mysql-connector-j-8.2.0.jar ${LIB_DIR}
COPY mysql-connector-java-8.0.30.jar ${LIB_DIR}

COPY datasource.xml ${PAYARA_DIR}/glassfish/domains/domain1/config/

ENV DEPLOY_DROPS=--contextroot=/