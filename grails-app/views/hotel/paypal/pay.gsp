
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Pay it Via Paypal</title>
  </head>
  <body>
    <div class="body">
      <g:form action="paypal" method="post">
        Did you pay for the hotel via paypal?<br/>
        Yes: <g:radio name="paid" value="0"/> &nbsp;
        No: <g:radio name="paid" value="1" checked="true"/>
        <br/>
      <g:submitButton name="submit" value="Mark Payment"></g:submitButton>
      </g:form>
    </div>
  </body>
</html>
