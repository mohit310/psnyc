<#-- @ftlvariable menu="" type="org.psnyc.views.MainView" -->
<#-- @ftlvariable template="" type="org.psnyc.views.MainView" -->

<!DOCTYPE HTML>
<html>
<head>
    <title>Pickup Soccer NYC - ${navigationData.menu?html}</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content="Pickup Soccer NYC"/>
    <meta name="keywords" content="pickup soccer nyc"/>
    <!--[if lte IE 8]>
    <script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.dropotron.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/skel-layers.min.js"></script>
    <script src="js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="css/skel.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/style-desktop.css"/>
        <link rel="stylesheet" href="css/font-awesome.min.css"/>
    </noscript>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="css/ie/v8.css"/><![endif]-->
</head>
<body class="homepage">
<#include "menu.ftl">
<#include "${navigationData.template}">
<#include "footer.ftl">
</body>
</html>