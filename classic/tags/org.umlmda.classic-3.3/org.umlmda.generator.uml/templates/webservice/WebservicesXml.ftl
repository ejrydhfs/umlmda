<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- @@Generated file, please edit UserSections only -->
<webservices xmlns="http://java.sun.com/xml/ns/j2ee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://www.ibm.com/webservices/xsd/j2ee_web_services_1_1.xsd" version="1.1">
    
<#list genPackage.classes as class>
<#if class.hasStereotype("WebService") = true >
    <webservice-description>
        <webservice-description-name>${class.name}</webservice-description-name>
        <wsdl-file>WEB-INF/wsdl/${class.name}.wsdl</wsdl-file>
        <jaxrpc-mapping-file>WEB-INF/${class.name}Mapping.xml</jaxrpc-mapping-file>
        <port-component>
            <port-component-name>${class.name}</port-component-name>
            <wsdl-port>${class.getGeneratedName("ws.ServicePort")}</wsdl-port>
            <service-endpoint-interface>${class.getQualifiedName("ws.ServletInterface")}</service-endpoint-interface>
            <service-impl-bean>
                <servlet-link>${class.name}Servlet</servlet-link>
            </service-impl-bean>
        </port-component>
    </webservice-description>

</#if>
</#list>
</webservices>