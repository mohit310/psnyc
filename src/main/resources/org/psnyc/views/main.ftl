<#-- @ftlvariable menu="" type="org.psnyc.views.MainView" -->
<#-- @ftlvariable template="" type="org.psnyc.views.MainView" -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Pickup Soccer NYC - ${navigationData.menu?html}</title>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/slider/default.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/slider/dark.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/slider/nivo-slider.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="css/menu.css">
    <!--<script type="text/javascript" src="js/jquery.js"></script>-->
    <script type="text/javascript" src="js/function.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>

</head>
<body>
<div id="wrap">
    <#include "menu.ftl">
    <#include "${navigationData.template}">
    <#include "footer.ftl">
</div>
</body>
</html>