<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- @@Generated file, please edit UserSections only -->
<web-app xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"
         version="2.4">

<#list genPackage.classes as class>
<#if class.hasStereotype("WebService") = true >
<#assign servletName=class.getGeneratedName("ws.Servlet")/>
  <servlet>
    <servlet-name>${servletName}</servlet-name>
    <servlet-class>${class.getQualifiedName("ws.Servlet")}</servlet-class>
<!-- @@UserSection-Begin ${servletName} -->
<!-- Custom env entries to configure web service endpoint -->
<!-- @@UserSection-End ${servletName} -->
  </servlet>

  <servlet-mapping>
    <servlet-name>${servletName}</servlet-name>
    <url-pattern>/${class.name}</url-pattern>
  </servlet-mapping>

</#if>
</#list>
</web-app>