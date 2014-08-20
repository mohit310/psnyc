<div id="banner-wrapper">
    <div id="banner" class="box container">
        <div style="position: relative; top: 0px; left: 0px; width: 600px;">
            <form id="contactus" autocomplete="on" action="/contactus/send">
                <label for="fname">First Name</label>
                <input id="fname" type="text" name="fname" maxlength="100">
                <label for="lname">Last Name</label>
                <input id="lname" type="text" name="lname" maxlength="100">
                <label for="email">Email</label>
                <input id="email" type="email" name="email" autocomplete="off" maxlength="100">
                <label for="query">Query</label>
                <textarea id="query" rows="2" cols="40" name="query"></textarea><br>
                <input type="submit" value="Submit">
            </form>
            <div id="message" style="position: relative; top: 0px; left: 0px; width: 600px;"></div>
            <script>

                 $( "#contactus" ).submit(function( event ) {
                    event.preventDefault();

                    var form = $(this);
                    var url = form.attr( "action" );
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
                        $("#message").text(data);
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
                });
            </script>
        </div>
    </div>
</div>