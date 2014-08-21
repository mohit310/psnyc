<!DOCTYPE HTML>
<html>
<head>
    <title>Pickup Soccer NYC - ${navigationData.menu?html}</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content="Pickup Soccer NYC"/>
    <meta name="keywords" content="pickup soccer nyc"/>
    <!--[if lte IE 8]>
    <script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/jquery.dropotron.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/skel-layers.min.js"></script>
    <script src="js/init.js"></script>
    <script src="js/jssor.core.js"></script>
    <script src="js/jssor.utils.js"></script>
    <script src="js/jssor.slider.js"></script>
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
<div id="banner-wrapper">
    <div id="banner" class="box container">
        <span>Please select the region where you play!!</span>
        <img id="imgid" src="images/world_map.png" width="900px" height="550px" alt="World" usemap="#worldmap">
        <map name="worldmap">
            <area shape="poly" coords="158,246,137,226,125,194, 126,172, 222,167, 287,167, 251, 202, 230, 240,158,246 " href="/us" alt="usa">
            <area shape="rect" coords="425,88,548,185" onClick="/eu" alt="europe">
        </map>
    </div>
</div>
<script type="text/javascript">
</script>
<#include "us/footer.ftl">
</body>
</html>