<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href='<s:url value="/styles/crudapp.css"/>' media="screen, projection"/>
    <link rel="stylesheet" type="text/css" href='<s:url value="/styles/displaytag.css"/>' media="screen, projection"/>
    <script type="text/javascript" src='<s:url value="/scripts/jquery-1.7.1.min.js"/>'></script>
    <script type="text/javascript" src='<s:url value="/scripts/jquery.dataTables.min.js"/>'></script>

    <s:head/>
</head>
<body>
<h1>Displaytag with client side table search</h1>
<display:table name="${users}" class="its" uid="usr" sort="list"
               requestURI=""
               export="true">
    <display:setProperty name="export.csv.filename" value="Users.csv"/>
    <display:setProperty name="export.xls.filename" value="Users.xls"/>
    <display:setProperty name="export.pdf.filename" value="Users.pdf"/>
    <display:setProperty name="export.rtf.filename" value="Users.rtf"/>

    <display:header>
        <thead id="sBar">
        <tr>
            <th><input type="text" name="s_firstName" class="search_init"/></th>
            <th><input type="text" name="s_lastName" class="search_init"/></th>
            <th><input type="text" name="s_city" class="search_init"/></th>
        </tr>
        </thead>
    </display:header>

    <display:column property="firstName" title="First Name"/>
    <display:column property="lastName" title="Last Name"/>
    <display:column property="city" title="City"/>
</display:table>
<script type="text/javascript">
    var confirmed = false;
    $(function () {
        /* Search functionality */
        var oTable = $('#usr').dataTable({
            "bPaginate":false,
            "bLengthChange":false,
            "bFilter":true,
            "bSort":false,
            "bInfo":false,
            "bAutoWidth":false,
            "bStateSave":false
        });
        $("thead input").keyup(function () {
            /* Filter on the column (the index) of this element */
            oTable.fnFilter(this.value, $("thead input").index(this));
        });

        $("thead input").focus(function () {
            if (this.className == "search_init") {
                this.className = "";
                this.value = "";
            }
        });

        $("thead input").blur(function (i) {
            if (this.value == "") {
                this.className = "search_init";
                this.value = asInitVals[$("thead input").index(this)];
            }
        });
    });
</script>
</body>
</html>
	