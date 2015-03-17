<%@include file="../header.jsp" %>
<body>
	<div id="content">
	    <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
        </form>
		<div id="header">
			<div id="home-link">
				<span class="link">
					<a href="search-flights.html" > 
						Home
					</a> 
				</span>
			</div>
			<div id="header-controls">
				Welcome ${ pageContext.request.userPrincipal.name } | 
				<span class="link">
                    <a href='javascript:formSubmit()'> 
                        Log Out 
                    </a> 
                </span>
			</div>
		</div>
		<div id="title">
			Flights search Utility
		</div>
		
		<div id="file-upload-form-wrapper">
			<div id="edit-form">
				<s:form commandName="searchParameters">
				    <table>
                        <tbody>
                                <tr>
                                    <td class="fieldLabel field-wrapper">
                                        <s:label path="departureLocationCode" > 
                                            Departure Location Code 
                                        </s:label>
                                    </td>
                                    <td class="field-wrapper"> 
                                        <s:input path="departureLocationCode" />
                                    </td>
                                    <td class="errorMsg"> 
                                        <s:errors path="departureLocationCode" cssClass="field-wrapper errorMsg"/> 
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td class="fieldLabel field-wrapper">
                                        <s:label path="arrivalLocationCode" > 
                                            Arrival Location Code 
                                        </s:label>
                                    </td>
                                    <td class="field-wrapper"> 
                                        <s:input path="arrivalLocationCode" />
                                    </td>
                                    <td class="errorMsg"> 
                                        <s:errors path="arrivalLocationCode" cssClass="field-wrapper errorMsg"/> 
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td class="fieldLabel field-wrapper">
                                        <s:label path="flightClass" > 
                                            Flight Class 
                                        </s:label>
                                    </td>
                                    <td class="field-wrapper"> 
                                        <s:input path="flightClass" />
                                    </td>
                                    <td class="errorMsg"> 
                                        <s:errors path="flightClass" cssClass="field-wrapper errorMsg"/> 
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td class="fieldLabel field-wrapper">
                                        <s:label path="flightDate" > 
                                            Flight Date (dd-MM-YYYY)
                                        </s:label>
                                    </td>
                                    <td class="field-wrapper"> 
                                         <s:input path="flightDate" />
                                    </td>
                                    <td class="errorMsg"> 
                                        <s:errors path="flightDate" cssClass="field-wrapper errorMsg"/> 
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td></td>
                                    <td>
                                        <div class="custom-button"> 
                                            <button type="submit" value="Search" tabindex="1" > Search </button>
                                        </div>
                                    </td>
                                    <td></td>
                                </tr>
                        </tbody>
                    </table>
	           </s:form>
			</div>
		</div>
	</div>
	<div id="list-uploaded-items">
 	    <c:if test="${searchResults != null}">
 	       <c:choose>
 	          <c:when test="${not empty searchResults}">
	              <table id="user-items">
	                <thead>
	                    <tr>
	                        <th> Flight Number </th>
	                        <th> File Owner </th>
	                        <th> Departure Time </th>
	                        <th> Duration </th>
	                        
	                        <th> Fare </th>
	                        <th> Seat Availability </th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach var="result" items="${ searchResults }">
	                        <tr>
	                            <td> ${ result.flightNumber } </td>
	                            <td> ${ result.flightOwner.ownerName } </td>
	                            <td> ${ result.departureTime } </td>
	                            <td> ${ result.durationInMinutes } </td>
	                            <td> ${ result.fare } </td>
	                            <td class=${ result.isSeatAvailable ? "background-green" : "background-red" }> </td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
	             </table>
           </c:when>
 	          <c:otherwise>
 	              <div class="field-wrapper errorMsg">
 	                  No such flights found!
 	              </div>
 	          </c:otherwise>
 	       </c:choose>
 	    </c:if>
     </div>
</body>
</html>