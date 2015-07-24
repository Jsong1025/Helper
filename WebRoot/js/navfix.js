$(document).ready(function(){
 $(function () {
    $(window).scroll(function(){
      if ($(window).scrollTop()>80){
      $("#navbar").addClass("navbar-fixed-top");
      }
      else
      {
      $("#navbar").removeClass("navbar-fixed-top");
      }
    });
  });
});


        $(document).ready(function(){
                       
          $('#scrollUp3').hover(
          function(){
            $('.weixinbox').show();
          },
          function(){
            setTimeout(function () { 
              $('.weixinbox').hide(0);
              }, 1000);
          });
          
        });



        $(function(){
        var btn =  $(".btn-load")
        btn.click(function(){
            btn.button('loading');
            setTimeout(function(){
                btn.button("reset")
            },1200)
        })
      })  