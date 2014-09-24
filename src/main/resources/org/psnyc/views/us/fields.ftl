<#-- @ftlvariable dataMap="" type="org.psnyc.views.us.MainView" -->
<#assign fields = dataMap["field"]/>
<div id="banner-wrapper">
    <div id="banner" class="box container">
        <ul>
            <#list fields as field>
            <li>${field.name}</li>
            </#list>
        </ul>
    </div>
</div>