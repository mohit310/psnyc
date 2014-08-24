<div id="banner-wrapper">
    <div id="banner" class="box container">
        <div style="position: relative; top: 0px; left: 0px; width: 600px;">
            <form id="contactus" autocomplete="on">
                <label for="fname">First Name</label>
                <input id="fname" type="text" name="fname" maxlength="100" required>
                <label for="lname">Last Name</label>
                <input id="lname" type="text" name="lname" maxlength="100" required>
                <label for="useremail">Email</label>
                <input id="useremail" type="email" name="useremail" maxlength="100" required>
                <label for="query">Query</label>
                <textarea id="query" rows="2" cols="40" name="query" required maxlength="500"></textarea><br>
                <input type="submit" value="Submit">
            </form>
            <span id="resultdata" style="position: relative; width: 600px;"></span>
            <script>


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
                            useremail: {
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
                            lname: {
                                required: "Please enter your lastname",
                                minLength: "Your lastname must be at least 2 characters long"
                            },
                            useremail: {
                                required: "Please enter a valid email",
                                minLength: "Your email must be at least 2 characters long"
                            },
                            query: {
                                required: "Please enter your query",
                                minLength: "Your query must be at least 10 characters long",
                                maxLength: "Your query cannot be greater than 500 characters long",
                            }
                        },
                        submitHandler: function() {
                            var form = $("#contactus");
                            var url = "/contactus/send";
                            var data = '{';
                            data = data + '"fname": "' + $('#contactus').find('input[name="fname"]').val() + '",';
                            data = data + '"lname": "' + $('#contactus').find('input[name="lname"]').val() + '",';
                            data = data + '"useremail": "' + $('#contactus').find('input[name="useremail"]').val() + '",';
                            data = data + '"query": "' + $('#contactus').find('textarea[name="query"]').val() + '"';
                            data = data + '}';
                            $.ajax({
                                url: url,
                                data: data,
                                type: "POST",
                                contentType: "application/json; charset=utf-8"
                            })
                            .done(function( data ) {
                                $("#resultdata").text(data.message);
                                $("#contactus").trigger("reset");
                            })
                            .fail(function(jqXHR, type ){
                                if (jqXHR.status == 422)
                                {
                                    var errorsObj = jQuery.parseJSON(jqXHR.responseText);
                                    var errorMessage = "<ul>";
                                    $.each(errorsObj.errors, function(index, value) {
                                        errorMessage =  errorMessage + "<li>" + value + "</li>";
                                    });
                                    errorMessage = errorMessage + "</ul>";
                                    alert(errorMessage);
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
                                    alert('Uncaught Error' + jqXHR.responseText + ":" + jqXHR.status);
                                }
                            });
                        }
                    });
                 });

         </script>
        </div>
    </div>
</div>