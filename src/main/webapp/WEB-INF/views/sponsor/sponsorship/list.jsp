<%--
- list.jsp
-
- Copyright (C) 2012-2024 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:list>
	<acme:list-column code="sponsor.sponsorship.list.label.code" path="code" width="15%"/>
	<acme:list-column code="sponsor.sponsorship.list.label.project" path="project" width="15%"/>
	<acme:list-column code="sponsor.sponsorship.list.label.start" path="start" width="20%"/>
	<acme:list-column code="sponsor.sponsorship.list.label.end" path="end" width="20%"/>
	<acme:list-column code="sponsor.sponsorship.list.label.amount" path="amount" width="15%"/>
	<acme:list-column code="sponsor.sponsorship.list.label.type" path="type" width="15%"/>
</acme:list>
<acme:button code="sponsor.sponsorship.list.button.create" action="/sponsor/sponsorship/create"/>