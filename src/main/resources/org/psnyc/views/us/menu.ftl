<#-- @ftlvariable menu="" type="org.psnyc.views.us.MainView" -->
<!-- Header -->
<div id="header-wrapper">
    <header id="header" class="container">

        <!-- Logo -->
        <div id="logo">
            <h1><a href="/us">Pickup Soccer NYC</a></h1>
        </div>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li <#if navigationData.menu = "Home">class="current"</#if>><a href="/us">Home</a></li>
                <li <#if navigationData.menu = "Fields">class="current"</#if>>
                    <a href="/fields">Fields</a>
                    <ul>
                        <li><a href="/fields?city=manhattan">Manhattan</a></li>
                        <li><a href="/fields?city=brooklyn">Brooklyn</a></li>
                    </ul>
                </li>
                <li <#if navigationData.menu = "Schedule">class="current"</#if>><a href="/schedule">Schedule</a></li>
                <li <#if navigationData.menu = "Forum">class="current"</#if>><a href="/forum">Forum</a></li>
                <li <#if navigationData.menu = "AboutUs">class="current"</#if>><a href="/aboutus">About Us</a></li>
                <li <#if navigationData.menu = "ContactUs">class="current"</#if>><a href="/contactus">Contact Us</a></li>
                <li <#if navigationData.menu = "Login">class="current"</#if>><a href="#">Login</a></li>

            </ul>
        </nav>
    </header>
</div>