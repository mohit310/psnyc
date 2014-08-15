<#-- @ftlvariable menu="" type="org.psnyc.views.MainView" -->
<header>
    <div class="inner relative">
        <a class="logo" href="#"><img src="images/psnyc_logo.png" alt="pickup soccer nyc"></a>
        <nav id="navigation">
            <ul id="main-menu">
                <li <#if navigationData.menu = "Home">class="current-menu-item"</#if>><a href="/"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li class="parent <#if navigationData.menu = "Fields">current-menu-item</#if>">
                    <a href="/fields"><i class="fa fa-list"></i>&nbsp;Fields</a>
                    <ul class="sub-menu">
                        <li><a href="/fields?city=manhattan"><i class="fa fa-globe fa-fw"></i>&nbsp;Manhattan</a></li>
                        <li><a href="/fields?city=brooklyn"><i class="fa fa-globe fa-fw"></i>&nbsp;Brookyln</a></li>
                    </ul>
                </li>
                <li <#if navigationData.menu = "Register">class="current-menu-item"></#if>><a href="/register"><i class="fa fa-plus"></i>&nbsp;Register</a></li>
                <li <#if navigationData.menu = "Forum">class="current-menu-item"></#if>><a href="#"><i class="fa fa-wechat"></i>&nbsp;Forum</a></li>
                <li <#if navigationData.menu = "AboutUs">class="current-menu-item"></#if>><a href="/aboutus"><i class="fa fa-asterisk"></i>&nbsp;About Us</a></li>
                <li <#if navigationData.menu = "ContactUs">class="current-menu-item"></#if>><a href="#"><i class="fa fa-comment"></i>&nbsp;Contact Us</a></li>
                <li <#if navigationData.menu = "Login">class="current-menu-item"></#if>><a href="#"><i class="fa fa-key"></i>&nbsp;Login</a></li>
            </ul>
        </nav>
        <div class="clear"></div>
    </div>
</header>