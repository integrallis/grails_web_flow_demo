
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Hotel Booking Application</title>
  </head>
  <body>
    <div class="body">
      <h1>Search Hotel</h1>
      <g:form action="bookingCart" method="post">
        Search Hotels<br/>
        <g:textField name="hotelName"/><br/>
        Maximum Results<br/>
        <g:select name="maxResults" from="${5..20}"/><br/>
        <br/>
        <g:submitButton name="showHotels" value="Find Hotels"></g:submitButton>
      </g:form>
    </div>
  </body>
</html>
