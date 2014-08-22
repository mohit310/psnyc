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
    <div id="login_div" style="display:none;" class="login_div">

        <span class="button b-close"><span>X</span></span>

        <div>
            <form id="loginform" autocomplete="on" action="/login">
                <label for="email">Email</label>
                <input id="email" type="email" name="email" autocomplete="off" required>
                <label for="password">Password</label>
                <input id="password" type="password" name="password" autocomplete="off" required>
                <br>
                <input type="Submit" value="Login"><input type="reset" value="Clear">
            </form>
        </div>
        <div id="message" style="position: relative; top: 0px; left: 0px; width: 600px;"></div>
        <script>

                $.validator.setDefaults({
                    submitHandler: function() {
                        var form = $("#login");
                        var url = form.attr("action");
                        var data = '{';
                        data = data + '"fname":' + '"' + $("#fname").val() + '",';
                        data = data + '"lname":' + '"' + $("#lname").val() + '",';
                        data = data + '"email":' + '"' + $("#email").val() + '",';
                        data = data + '"query":' + '"' + $("#query").val() + '"';
                        data = data + "}";
                        $.ajax({
                            url: url,
                            data: data,
                            type: "POST",
                            contentType: "application/json; charset=utf-8",
                        })
                        .done(function( data ) {
                            $('#message').text(data);
                            $('#contactus').trigger("reset");
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

               $().ready(function() {
                      $("#contactus").validate({
                        rules: {
                            fname: {
                                required: true,
                                minlength: 2
                            },
                            lname: {
                                required: true,
                                minlength: 2
                            },
                            email: {
                                required: true,
                                minlength: 2
                            },
                            query: {
                                required: true,
                                minlength: 10,
                                maxlength: 500
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
                            email: {
                                required: "Please enter a valid email",
                                minLength: "Your email must be at least 2 characters long"
                            },
                            query: {
                                required: "Please enter your query",
                                minLength: "Your query must be at least 10 characters long",
                                maxLength: "Your query cannot be greater than 500 characters long",
                            }
                        }
                    });
                 });



        </script>
    </div>
    <script>
    $(document).ready(function() {
        $("#login").click(function() {

            $('#login_div').bPopup({
                easing: 'easeOutBack', //uses jQuery easing plugin
                speed: 350,
                transition: 'slideDown',
                opacity: 0.7,
                modalColor: "#ffffff"

            });
        });
    });



</script>