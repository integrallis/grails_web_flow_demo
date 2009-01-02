<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Book Hotel</title>
  </head>
  <body>
    <div class="body">
      <g:form action="bookingCart" method="post">
        <h1>Finalize - ${fieldValue(bean:hotel, field:'name')}</h1>
        Name: ${fieldValue(bean:hotel, field:'name')}<br/>
        Address: ${fieldValue(bean:hotel, field:'address')}<br/>
        City: ${fieldValue(bean:hotel, field:'city')}<br/>
        State: ${fieldValue(bean:hotel, field:'state')}<br/>
        Zip: ${fieldValue(bean:hotel, field:'zip')}<br/>
        Country: ${fieldValue(bean:hotel, field:'country')}<br/>
        Nightly rate: ${fieldValue(bean:hotel, field:'price')}<br/>
        Check In Date: ${fieldValue(bean:booking, field:'checkinDate')}<br/>
        Check Out Date: ${fieldValue(bean:booking, field:'checkoutDate')}<br/>

        <g:submitButton name="cancel" value="Cancel"></g:submitButton>
        <g:submitButton name="submit" value="Submit"></g:submitButton>        
      </g:form>
    </div>
  </body>
</html>
