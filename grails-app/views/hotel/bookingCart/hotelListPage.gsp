
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Hotel Results</title>
  </head>
  <body>
    <div class="body">
    <g:form action="bookingCart" method="post">
        <h1>Hotel Results</h1>
        <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
        </g:if>
        <div class="list">
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="name" title="Name" />
                        <g:sortableColumn property="address" title="Address" />
                        <g:sortableColumn property="city" title="City, State" />
                        <g:sortableColumn property="zip" title="Zip" />
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                <g:each in="${hotelResults}" status="i" var="hotel">
                  <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    <td>${fieldValue(bean:hotel, field:'name')}</td>
                    <td>${fieldValue(bean:hotel, field:'address')}</td>
                    <td>${fieldValue(bean:hotel, field:'city')},
                      ${fieldValue(bean:hotel, field:'state')}</td>
                    <td>${fieldValue(bean:hotel, field:'zip')}</td>
                    <td><g:link action="bookingCart" event="view" id="${hotel.id}">View Hotel</g:link></td>
                  </tr>
                </g:each>
                </tbody>
            </table>
        </div>
        <div class="paginateButtons">
            <g:paginate total="${hotelResults.size()}" />
        </div>
        <p>
          <g:submitButton name="back" value="back to search"/>
        </p>
    </g:form>
    </div>
  </body>
</html>
