<%@include file="../header.jsp" %>
<body>
	<div id="content">
		 <div id="login-box">
		      <c:if test="${error != null}">
	                <div class="field-wrapper errorMsg">
	                      Invalid credentials!
	                </div>
              </c:if>
		 <c:url value="/perform_login" var="loginUrl" />
		 <s:form commandName="user" action="${loginUrl}" method="post" >
		 	<div class="field-wrapper">
		 		<s:label path="userName" > Username </s:label>
		 		<s:input path="userName" />
		 	</div>
		 	
		 	<div class="field-wrapper">
		 		<s:label path="password" > Password </s:label>
		 		<s:password path="password" />
		 	</div>
		 	<div id="form-controls">
				<div class="field-wrapper">
					<button type="submit" value="Sign In" > Sign In </button>
				</div>
				<div class="link-block link">
					<a href="sign-up.html"> Create new Account? </a>
				</div>
				<div class="clear"></div>
			</div>
		 </s:form>
		</div>
	</div>
</body>
</html>