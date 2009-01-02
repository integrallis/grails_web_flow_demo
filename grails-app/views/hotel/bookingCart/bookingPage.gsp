<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Book Hotel</title>
  </head>
  <body>
    <div class="body">
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${booking}">
        <div class="errors">
            <g:renderErrors bean="${booking}" as="list" />
        </div>
      </g:hasErrors>
      <g:form action="bookingCart" method="post">
        <h1>Book - ${fieldValue(bean:hotel, field:'name')}</h1>
        Name: ${fieldValue(bean:hotel, field:'name')}<br/>
        Address: ${fieldValue(bean:hotel, field:'address')}<br/>
        City: ${fieldValue(bean:hotel, field:'city')}<br/>
        State: ${fieldValue(bean:hotel, field:'state')}<br/>
        Zip: ${fieldValue(bean:hotel, field:'zip')}<br/>
        Country: ${fieldValue(bean:hotel, field:'country')}<br/>
        Nightly rate: ${fieldValue(bean:hotel, field:'price')}<br/>
        Check In Date: <g:datePicker name="checkinDate" value="${new Date()}" precision="day" years="${2008..2015}"/><br/>
        Check Out Date: <g:datePicker name="checkoutDate" value="${new Date()}" precision="day" years="${2008..2015}"/><br/>
        Payment Type: Credit Card: <g:radio name="paymentType" value="creditCard"/> &nbsp;
          Paypal: <g:radio name="paymentType" value="paypal" checked="true"/><br/>
        # of Beds: <g:textField name="beds"/>
        <br/>
        <g:submitButton name="cancel" value="Cancel"></g:submitButton>
        <g:submitButton name="proceed" value="Proceed"></g:submitButton>        
      </g:form>
    </div>
  </body>
</html>
