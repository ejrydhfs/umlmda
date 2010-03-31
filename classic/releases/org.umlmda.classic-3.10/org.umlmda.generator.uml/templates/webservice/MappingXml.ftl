<?xml version="1.0" encoding="UTF-8"?>
<!-- @@Generated file, please edit UserSections only -->
<java-wsdl-mapping version="1.1" xmlns="http://java.sun.com/xml/ns/j2ee" 
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://www.ibm.com/webservices/xsd/j2ee_jaxrpc_mapping_1_1.xsd">

  <!-- Package Mappings -->
<#list genClass.referencedPackages as package>  
  <package-mapping>
    <package-type>${package.qualifiedName}</package-type>
    <namespaceURI>${package.namespace}</namespaceURI>
  </package-mapping>
</#list>

  <!-- Type Mappings -->
<#list genClass.schemaEnumTypes as class>  
  <java-xml-type-mapping>
    <java-type>
      ${class.getQualifiedName("ws.Stub")}
    </java-type>
    <root-type-qname xmlns:wsdlMsgNS="${class.package.namespace}">
      wsdlMsgNS:${class.name}
    </root-type-qname>
    <qname-scope>
      simpleType
    </qname-scope>
  </java-xml-type-mapping>
</#list>  
<#list genClass.schemaComplexTypes as class>  
  <java-xml-type-mapping>
    <java-type>
      ${class.getQualifiedName("ws.Stub")}
    </java-type>
    <root-type-qname xmlns:wsdlMsgNS="${class.package.namespace}">
      wsdlMsgNS:${class.name}
    </root-type-qname>
    <qname-scope>
      complexType
    </qname-scope>
  </java-xml-type-mapping>
</#list>  
  
  <service-interface-mapping>
    <service-interface>${genClass.getQualifiedName("ws.ServletInterface")}</service-interface>
    <wsdl-service-name xmlns:serviceNS="${genClass.package.namespace}">
      serviceNS:${genClass.name}</wsdl-service-name>
    <port-mapping>
      <port-name>${genClass.name}Port</port-name>
      <java-port-name>${genClass.name}Port</java-port-name>
    </port-mapping>
  </service-interface-mapping>

  <service-endpoint-interface-mapping>
    <service-endpoint-interface>${genClass.getQualifiedName("ws.ServletInterface")}</service-endpoint-interface>
    <wsdl-port-type xmlns:portTypeNS="${genClass.package.namespace}">
      portTypeNS:${genClass.name}Port</wsdl-port-type>
    <wsdl-binding xmlns:bindingNS="${genClass.package.namespace}">
      bindingNS:${genClass.name}SoapBinding</wsdl-binding>

<#list genClass.getMethods(true) as method>  
    <service-endpoint-method-mapping>
      <java-method-name>${method.name}</java-method-name>
      <wsdl-operation>${method.name}</wsdl-operation>
<#list method.parameters as param>  
      <method-param-parts-mapping>
        <param-position>0</param-position>
        <param-type>${param.type.WSJavaType}</param-type>
        <wsdl-message-mapping>
          <wsdl-message xmlns:wsdlMsgNS="${genClass.package.namespace}">
            wsdlMsgNS:${method.name}Request</wsdl-message>
          <wsdl-message-part-name>${param.name}</wsdl-message-part-name>
          <parameter-mode>IN</parameter-mode>
        </wsdl-message-mapping>
      </method-param-parts-mapping>
</#list>      
      <wsdl-return-value-mapping>
        <method-return-value>${method.returnType.WSJavaType}</method-return-value>
        <wsdl-message xmlns:wsdlMsgNS="${genClass.package.namespace}">
          wsdlMsgNS:${method.name}Response</wsdl-message>
        <wsdl-message-part-name>return</wsdl-message-part-name>
      </wsdl-return-value-mapping>
    </service-endpoint-method-mapping>
</#list>    

  </service-endpoint-interface-mapping>
</java-wsdl-mapping>