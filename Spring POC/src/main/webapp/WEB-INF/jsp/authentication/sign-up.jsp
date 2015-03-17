<%@include file="../header.jsp" %>
<body>
	<div id="content">
		 <div id="signup-box">
		  <s:form commandName="user">
		    <c:if test="${error != null}">
	            <div class="field-wrapper errorMsg">
	                  ${error}
	            </div>
		    </c:if>
            <div class="field-wrapper">
                <s:label path="emailId" > 
                    Email-ID 
                    <s:errors path="emailId" cssClass="field-wrapper errorMsg"/>
                </s:label>
                <s:input path="emailId" />
            </div>
            
            <div class="field-wrapper">
                <s:label path="userName" > 
                    Username 
                    <s:errors path="userName" cssClass="field-wrapper errorMsg"/>
                </s:label>
                <s:input path="userName" />
            </div>
            
            <div class="field-wrapper">
                <s:label path="password" > 
                    Password 
                    <s:errors path="password" cssClass="field-wrapper errorMsg"/>
                </s:label>
                <s:password path="password" />
            </div>
            <div id="form-controls">
                <div class="field-wrapper">
                    <button type="submit" value="Sign Up!" > Sign Up! </button>
                </div>
                <div class="link-block link">
                    <a href="login.html"> Existing Account? </a>
                </div>
                <div class="clear"></div>
            </div>
         </s:form>
		</div>
	</div>
</body>
</html>