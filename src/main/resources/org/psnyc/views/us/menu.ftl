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
                <li
                <#if navigationData.menu = "Home">class="current"</#if>
                ><a href="/us">Home</a></li>
                <li
                <#if navigationData.menu = "Fields">class="current"</#if>
                >
                <a href="/fields">Fields</a>
                <ul>
                    <li><a href="/fields?city=manhattan">Manhattan</a></li>
                    <li><a href="/fields?city=brooklyn">Brooklyn</a></li>
                </ul>
                </li>
                <li
                <#if navigationData.menu = "Schedule">class="current"</#if>
                ><a href="/schedule">Schedule</a></li>
                <li
                <#if navigationData.menu = "Forum">class="current"</#if>
                ><a href="/forum">Forum</a></li>
                <li
                <#if navigationData.menu = "AboutUs">class="current"</#if>
                ><a href="/aboutus">About Us</a></li>
                <li
                <#if navigationData.menu = "ContactUs">class="current"</#if>
                ><a href="/contactus">Contact Us</a></li>
                <li
                <#if navigationData.menu = "Login">class="current"</#if>
                ><a href="#" id="login">Login</a></li>
            </ul>
        </nav>
    </header>
</div>

<div id="logindiv" style="display: none;">
    <div style="width: 315px;">
        <span class="b-close"><span><a href="javascript:window.close();">X</a></span></span>
    </div>
    <div style="width: 315px;">
        <form id="loginform" autocomplete="on" action="login">
            <label for="email">Email</label>
            <input id="email" type="email" name="email" autocomplete="off" required>
            <label for="password">Password</label>
            <input id="password" type="password" name="password" autocomplete="off" required>
            <br>
            <input type="Submit" value="Login"><span>&nbsp;&nbsp;</span>
            <input id="signup" type="button" name="signup" value="Sign Up">
        </form>
        <div style="top: 3px; ;width: 315px;"><a id="forgotp" href="#">Forgot Password</a></div>
        <span id="loginresult" style="position: relative; width: 300px;"></span>
    </div>
</div>

<div id="signupdiv" style="display: none;">
    <div style="width: 315px;">
        <span class="b-close"><span><a href="javascript:window.close();">X</a></span></span>
    </div>
    <div style="width: 315px;">
        <form id="signupform" autocomplete="on" action="signup">
            <label for="useremail">Email</label>
            <input id="useremail" type="email" name="useremail" autocomplete="off" required>
            <label for="fname">First Name</label>
            <input id="fname" type="text" name="fname" maxlength="100" required>
            <label for="lname">Last Name</label>
            <input id="lname" type="text" name="lname" maxlength="100" required>
            <label for="phone">Phone</label>
            <input id="phone" type="text" name="phone" maxlength="10" required>
            <label for="signuppassword">Password</label>
            <input id="signuppassword" type="password" name="signuppassword" autocomplete="off" required>
            <label for="confirmpassword">Confirm Password</label>
            <input id="confirmpassword" type="password" name="confirmpassword" autocomplete="off" required>
            <br>
            <input type="submit" value="Submit">
        </form>
        <span id="resultdata" style="position: relative; width: 300px;"></span>
    </div>
</div>

<div id="forgotpdiv" style="display: none;">
    <div style="width: 315px;">
        <span class="b-close"><span><a href="javascript:window.close();">X</a></span></span>
    </div>
    <div style="width: 315px;">
        <form id="forgotpform" autocomplete="on" action="login/forgotpassword">
            <label for="forgotpemail">Email</label>
            <input id="forgotpemail" type="email" name="forgotpemail" autocomplete="off" required>
            <br>
            <input type="submit" id="forgotpsubmit" name="forgotpsubmit" value="Submit">
        </form>
        <span id="forgotpresult" style="position: relative; width: 300px;"></span>
    </div>

</div>


<script type="text/javascript">

    $(document).ready(function() {

        var userid = $.jStorage.get("id");
        var emailIdFromStorage = $.jStorage.get("emailId");
        if (undefined != userid && null != userid && undefined != emailIdFromStorage && null != emailIdFromStorage){
            $('#login').text("Logout");
            $('#login').attr("href","/logout");
        }

        $("#login").click(function() {
            $("#loginresult").text();
            $('#logindiv').bPopup({
                easing: 'easeOutBack', //uses jQuery easing plugin
                speed: 350,
                transition: 'slideDown',
                opacity: 0.8,
                modalColor: "#ffffff"

            });
        });

        $("#forgotp").click(function() {
            $('#logindiv').bPopup().close();
            $("#forgotpresult").text();
            $('#forgotpdiv').bPopup({
                easing: 'easeOutBack', //uses jQuery easing plugin
                speed: 350,
                transition: 'slideDown',
                opacity: 0.8,
                modalColor: "#ffffff"

            });
        });

        $("#signup").click(function() {
            $('#logindiv').bPopup().close();
            $("#resultdata").html();
            $('#signupdiv').bPopup({
                easing: 'easeOutBack', //uses jQuery easing plugin
                speed: 350,
                transition: 'slideDown',
                opacity: 0.8,
                modalColor: "#ffffff"

            });
        });


        $("#loginform").validate({
            rules: {
                email: {
                    required: true,
                    minlength: 2
                },
                password: {
                    required: true,
                    minlength: 8,
                    maxlength: 50
                }
            },
            messages: {
                email: {
                    required: "Please enter a valid email",
                    minlength: "Your email must be at least {0} characters long"
                },
                password: {
                    required: "Password is required",
                    minlength: "Password should be atleast {0} characters long",
                    maxlength: "Password cannot be greater than {0} characters long",
                }
            },
            submitHandler: function() {
                var form = $("#loginform");
                var url = form.attr("action");
                var data = '{';
                data = data + '"email":"' + $('#loginform').find('input[name="email"]').val() + '",';
                data = data + '"password":"' + $('#loginform').find('input[name="password"]').val() + '"';
                data = data + "}";
                $.ajax({
                    url: url,
                    data: data,
                    type: "POST",
                    contentType: "application/json; charset=utf-8"
                })
                .done(function( data ) {
                    if(data.message == "success"){
                        $.jStorage.set("emailId", data.emailId);
                        $.jStorage.set("role", data.role);
                        $.jStorage.set("id", data.id);
                        $('#loginform').trigger("reset");
                        $('#login').text("Logout");
                        $('#login').attr("href","/logout");
                        $('#logindiv').bPopup().close();
                    }
                })
                .fail(function(jqXHR, textStatus){
                    if(jqXHR.status == 422){
                        var errorsObj = jQuery.parseJSON(jqXHR.responseText);
                        $("#loginresult").text(errorsObj.error);
                    }
                    else if (jqXHR.status === 0)
                    {
                        alert('Not connect.n Verify Network.');
                    }
                    else if (jqXHR.status == 404)
                    {
                        alert('Requested page not found. [404]');
                    }
                    else if (jqXHR.status == 500)
                    {
                        alert('Internal Server Error [500].');
                    }
                    else
                    {
                        alert('Uncaught Error.n' + jqXHR.responseText);
                    }
                });
            }
        });

        $("#signupform").validate({
            rules: {
                fname: {
                    required: true,
                    minlength: 2
                },
                lname: {
                    required: true,
                    minlength: 2
                },
                useremail: {
                    required: true,
                    minlength: 2,
                    email: true,
                    remote: "checkemail"
                },
                phone: {
                    required: true,
                    phoneUS: true
                },
                signuppassword: {
                    required: true,
                    minlength: 8,
                    maxlength: 50
                },
                confirmpassword: {
                    required: true,
                    minlength: 8,
                    maxlength: 50,
                    equalTo: "#signuppassword"
                }
            },
            messages: {
                fname: {
                    required: "Please enter your firstname",
                    minlength: "Your firstname must be at least {0} characters long"
                },
                fname: {
                    required: "Please enter your lastname",
                    minlength: "Your lastname must be at least {0} characters long"
                },
                useremail: {
                    required: "Please enter a valid email",
                    minlength: "Your email must be at least {0} characters long",
                    email:  "Please enter valid email",
                    remote: jQuery.validator.format("Email is already in use")
                },
                phone: {
                    required: "Please enter phone number",
                    phoneUS: "Please enter a valid phone number"
                },
                password: {
                    required: "Password is required",
                    minlength: "Password should be atleast {0} characters long",
                    maxlength: "Password cannot be greater than {0} characters long",
                },
                confirmpassword: {
                    required:  "Confirm password is required",
                    equalTo: "Confirm password should be same as Password"
                }
            },
            submitHandler: function() {
                var form = $("#signupform");
                var url = "signup";
                var data = "{";
                data = data + '"fname":"' + $('#signupform').find('input[name="fname"]').val() + '",';
                data = data + '"lname":"' + $('#signupform').find('input[name="lname"]').val() + '",';
                data = data + '"useremail":"' + $('#signupform').find('input[name="useremail"]').val() + '",';
                data = data + '"phone":"' + $('#signupform').find('input[name="phone"]').val() + '",';
                data = data + '"password":"' + $('#signupform').find('input[name="signuppassword"]').val() + '",';
                data = data + '"confirmpassword":"' + $('#signupform').find('input[name="confirmpassword"]').val() + '"';
                data = data + "}";
                $.ajax({
                    url: url,
                    data: data,
                    type: "POST",
                    contentType: "application/json; charset=utf-8"
                })
                .done(function( result ) {
                    var finalMessage = "<ul>";
                    finalMessage = finalMessage + "<li>SignUp Successful. You will receive an email with details. You can close this window</li>";
                    finalMessage = finalMessage + "</ul>";
                    $("#resultdata").html(finalMessage);
                    $('#signupform').trigger("reset");

                })
                .fail(function(jqXHR, textStatus){
                    if (jqXHR.status == 422)
                    {
                        var errorsObj = jQuery.parseJSON(jqXHR.responseText);
                        var errorMessage = "<ul>";
                        $.each(errorsObj.errors, function(index, value) {
                            errorMessage =  errorMessage + "<li>" + value + "</li>";
                        });
                        errorMessage = errorMessage + "</ul>";
                        $("#resultdata").html(errorMessage);

                    }else if (jqXHR.status === 0)
                    {
                        alert('Not connect.n Verify Network.');
                    }
                    else if (jqXHR.status == 404)
                    {
                        alert('Requested page not found. [404]');
                    }
                    else if (jqXHR.status == 500)
                    {
                        alert('Internal Server Error [500].');
                    }
                    else
                    {
                        alert('Uncaught Error.n' + jqXHR.responseText);
                    }
                });
            }
        });


        $("#forgotpform").validate({
            rules: {
                forgotpemail: {
                    required: true,
                    minlength: 2,
                    email: true
                }
            },
            messages: {
                forgotpemail: {
                    required: "Please enter a valid email",
                    minlength: "Your email must be at least {0} characters long",
                    email: "Please enter valid email"
                }
            },
            submitHandler: function() {
                var form = $("#forgotpform");
                var url = form.attr("action");
                var data = '{';
                data = data + '"email":"' + $('#forgotpform').find('input[name="forgotpemail"]').val() + '"';
                data = data + "}";
                $.ajax({
                    url: url,
                    data: data,
                    type: "POST",
                    contentType: "application/json; charset=utf-8"
                })
                .done(function( data ) {
                    if(data.message == "success")
                        $("#forgotpform").trigger("reset");
                        $("#forgotpresult").text("You will receive an email with password reset instructions");

                })
                .fail(function(jqXHR, textStatus){
                    if(jqXHR.status == 422){
                        var errorsObj = jQuery.parseJSON(jqXHR.responseText);
                        $("#forgotpresult").text(errorsObj.error);
                    }
                    else if (jqXHR.status === 0)
                    {
                        alert('Not connect.n Verify Network.');
                    }
                    else if (jqXHR.status == 404)
                    {
                        alert('Requested page not found. [404]');
                    }
                    else if (jqXHR.status == 500)
                    {
                        alert('Internal Server Error [500].');
                    }
                    else
                    {
                        alert('Uncaught Error.n' + jqXHR.responseText);
                    }
                });
            }
        });
    });

</script>