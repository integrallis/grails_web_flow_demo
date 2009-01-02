<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Hotel View</title>
  </head>
  <body>
    <div class="body">
      <h1>${fieldValue(bean:hotel, field:'name')}</h1>
      Name: ${fieldValue(bean:hotel, field:'name')}<br/>
      Address: ${fieldValue(bean:hotel, field:'address')}<br/>
      City: ${fieldValue(bean:hotel, field:'city')}<br/>
      State: ${fieldValue(bean:hotel, field:'state')}<br/>
      Zip: ${fieldValue(bean:hotel, field:'zip')}<br/>
      Country: ${fieldValue(bean:hotel, field:'country')}<br/>
      Nightly rate: ${fieldValue(bean:hotel, field:'price')}<br/>
      <br/>
      <g:form action="bookingCart" method="post">
        <g:submitButton name="back" value="Back to Search"></g:submitButton>
        <g:submitButton name="book" value="Book Hotel"></g:submitButton>
      </g:form>
    </div>
  </body>
</html>
