<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>APLICACION BASICA DE STRUTS</title>
            <link href="ccs/style.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>
           <h:form id="form1">
                <h:dataTable headerClass="cabeceraTabla" rowClasses="fila1,fila2" styleClass="tabla"
                  value="#{mensaje}" border="1" var="fila" id="tabladept">
                <h:column>
                    <f:facet name="header">
                        NUMERO
                    </f:facet>
                    <h:outputText value="#{fila.numero}" /> 
                </h:column>
                <h:column>
                    <f:facet name="header">
                        NOMBRE
                    </f:facet>
                    <h:outputText value="#{fila.nombre}" /> 
                </h:column>
                <h:column>
                    <f:facet name="header">
                        LOCALIDAD
                    </f:facet>
                    <h:outputText value="#{fila.localidad}" />
                </h:column>
            </h:dataTable>
            
            </h:form>
        </body>
    </html>
</f:view>
