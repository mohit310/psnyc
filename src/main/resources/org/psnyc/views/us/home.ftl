<!-- Banner -->
<div id="banner-wrapper">
    <div id="banner" class="box container">
        <!-- Caption Style -->
        <style>
            .captionOrange, .captionBlack
            {
            color: #fff;
            font-size: 20px;
            line-height: 30px;
            text-align: center;
            border-radius: 4px;
            }
            .captionOrange
            {
            background: #EB5100;
            background-color: rgba(235, 81, 0, 0.6);
            }
            .captionBlack
            {
            font-size:16px;
            background: #000;
            background-color: rgba(0, 0, 0, 0.4);
            }
            a.captionOrange, A.captionOrange:active, A.captionOrange:visited
            {
            color: #ffffff;
            text-decoration: none;
            }
            a.captionOrange:hover
            {
            color: #eb5100;
            text-decoration: underline;
            background-color: #eeeeee;
            background-color: rgba(238, 238, 238, 0.7);
            }
            .bricon
            {
            background: url(../img/browser-icons.png);
            }

       </style>




        <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px;
        height: 300px;">
            <!-- Slides Container -->
            <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px;
            overflow: hidden">
                <div>
                    <img u="image" src="images/psnyc_1.png" />
                    <div u="caption" t="MCLIP|B" style="position: absolute; top: 250px; left: 0px;
                    width: 600px; height: 50px;">
                        <div style="position: absolute; top: 0px; left: 0px; width: 600px; height: 50px;
                        background-color: Black; opacity: 0.5; filter: alpha(opacity=50);">
                        </div>
                        <div style="position: absolute; top: 0px; left: 0px; width: 600px; height: 50px;
                        color: White; font-size: 16px; font-weight: bold; line-height: 50px; text-align: center;">
                            Brooklyn Pier 5 Park
                        </div>
                    </div>
                </div>
                <!-- Slide -->
                <div>
                    <img u="image" src="images/psnyc_2.png" />
                    <div u="caption" t="MCLIP|B" t2="T" style="position: absolute; top: 250px; left: 0px;
                    width: 600px; height: 50px;">
                        <div style="position: absolute; top: 0px; left: 0px; width: 600px; height: 50px;
                        background-color: Black; opacity: 0.5; filter: alpha(opacity=50);">
                        </div>
                        <div style="position: absolute; top: 0px; left: 0px; width: 600px; height: 50px;
                        color: White; font-size: 16px; font-weight: bold; line-height: 50px; text-align: center;">
                            Charity Match at Nike Field - 23rs St. and Houston Ave
                        </div>
                    </div>
                </div>
            </div>
            <a style="display: none" href="http://www.jssor.com">javascript</a>
        </div>
    </div>
</div>
<script>

        jQuery(document).ready(function ($) {

            var _CaptionTransitions = [];
            _CaptionTransitions["WAVE|L"] = { $Duration: 1500, $FlyDirection: 5, $Easing: { $Left: $JssorEasing$.$EaseLinear, $Top: $JssorEasing$.$EaseOutWave }, $ScaleVertical: 0.4, $Round: { $Top: 2.5} };
            _CaptionTransitions["MCLIP|B"] = { $Duration: 600, $Clip: 8, $Move: true, $Easing: $JssorEasing$.$EaseOutExpo };




             var options = {
                $AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)
                $CaptionSliderOptions: {                            //[Optional] Options which specifies how to animate caption
                    $Class: $JssorCaptionSlider$,                   //[Required] Class to create instance to animate caption
                    $CaptionTransitions: _CaptionTransitions,       //[Required] An array of caption transitions to play caption, see caption transition section at jssor slideshow transition builder
                    $PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
                    $PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
                }
            };

            var jssor_slider1 = new $JssorSlider$("slider1_container", options);
        });


</script>