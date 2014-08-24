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
    <div id="popup" style="display: none;">
        <div style="width: 315px;">
            <span class="b-close"><span><a href="javascript:window.close();">X</a></span></span>
        </div>
        <div style="width: 315px;">
            <form id="loginform" autocomplete="on" action="/login">
                <label for="email">Email</label>
                <input id="email" type="email" name="email" autocomplete="off" required>
                <label for="password">Password</label>
                <input id="password" type="password" name="password" autocomplete="off" required>
                <br>
                <input type="Submit" value="Login"><span>&nbsp;&nbsp;</span>
                <input id="signup" type="button" name="signup" value="Sign Up">
            </form>
        </div>
        <script>

               $().ready(function() {

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
                                minLength: "Your email must be at least 2 characters long"
                            },
                            password: {
                                required: "Password is required",
                                minLength: "Password should be atleast 8 characters long",
                                maxLength: "Password cannot be greater than 50s characters long",
                            }
                        },
                        submitHandler: function() {
                            var form = $("#loginform");
                            var url = form.attr("action");
                            var data = '{';
                            data = data + '"email":' + '"' + $("#email").val() + '",';
                            data = data + '"password":' + '"' + $("#password").val() + '"';
                            data = data + "}";
                            $.ajax({
                                url: url,
                                data: data,
                                type: "POST",
                                contentType: "application/json; charset=utf-8",
                            })
                            .done(function(  ) {
                                if(data == "success")
                                    document.location.href="/";
                            })
                            .fail(function(jqXHR, textStatus){
                                if (jqXHR.status === 0)
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
    </div>

    <div id="signupdiv" style="display: none;">
        <div style="width: 315px;">
            <span class="b-close"><span><a href="javascript:window.close();">X</a></span></span>
        </div>
        <div style="width: 315px;">
            <form id="signupform" autocomplete="on" action="/signup">
                <label for="useremail">Email</label>
                <input id="useremail" type="email" name="useremail" autocomplete="off" required>
                <label for="fname">First Name</label>
                <input id="fname" type="text" name="fname" maxlength="100" required>
                <label for="lname">Last Name</label>
                <input id="lname" type="text" name="lname" maxlength="100" required>
                <label for="password">Password</label>
                <input id="password" type="password" name="password" autocomplete="off" required>
                <label for="confirmpassword">Retype Password</label>
                <input id="confirmpassword" type="password" name="confirmpassword" autocomplete="off" required>
                <br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <script type="text/javascript">

               $().ready(function() {

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
                                remote: "/signup/checkemail"
                            },
                            password: {
                                required: true,
                                minlength: 8,
                                maxlength: 50
                            },
                            confirmpassword: {
                                required: true,
                                minlength: 8,
                                maxlength: 50,
                                equalTo: "#password"
                            }
                        },
                        messages: {
                            fname: {
                                required: "Please enter your firstname",
                                minLength: "Your firstname must be at least 2 characters long"
                            },
                            fname: {
                                required: "Please enter your lastname",
                                minLength: "Your lastname must be at least 2 characters long"
                            },
                            useremail: {
                                required: "Please enter a valid email",
                                minLength: "Your email must be at least 2 characters long",
                                email: true,
                                remote: jQuery.validator.format("{0} is already in use")
                            },
                            password: {
                                required: "Password is required",
                                minLength: "Password should be atleast 8 characters long",
                                maxLength: "Password cannot be greater than 50s characters long",
                            }
                        },
                        submitHandler: function() {
                            var form = $("#signupform");
                            var url = "/signup";
                            var data = '{';
                            data = data + '"fname":' + '"' + $("#fname").val() + '",';
                            data = data + '"lname":' + '"' + $("#lname").val() + '",';
                            data = data + '"email":' + '"' + $("#email").val() + '",';
                            data = data + '"password":' + '"' + $("#password").val() + '"';
                            data = data + "}";
                            $.ajax({
                                url: url,
                                data: data,
                                type: "POST",
                                contentType: "application/json; charset=utf-8",
                            })
                            .done(function( data ) {
                                alert(data);
                                //Set Header here or maybe on Server.
                                document.location.href="/";
                            })
                            .fail(function(jqXHR, textStatus){
                                if (jqXHR.status === 0)
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
    </div>
    <script>
    $(document).ready(function() {
        $("#login").click(function() {

            $('#popup').bPopup({
                easing: 'easeOutBack', //uses jQuery easing plugin
                speed: 350,
                transition: 'slideDown',
                opacity: 0.8,
                modalColor: "#ffffff"

            });
        });

        $("#signup").click(function() {
            $('#popup').bPopup().close();
            $('#signupdiv').bPopup({
                easing: 'easeOutBack', //uses jQuery easing plugin
                speed: 350,
                transition: 'slideDown',
                opacity: 0.8,
                modalColor: "#ffffff"

            });
        });
    });
    </script>