FROM payara/server-full:latest

EXPOSE 80 4848

COPY EJBEar.ear $DEPLOY_DIR

ENV LIB_DIR ${PAYARA_DIR}/glassfish/lib/
COPY mysql-connector-j-8.2.0.jar ${LIB_DIR}
COPY mysql-connector-java-8.0.30.jar ${LIB_DIR}

ENV DEPLOY_DROPS=--contextroot=/

COPY domain.xml ${PAYARA_DIR}/glassfish/domains/domain1/config/domain.xml


