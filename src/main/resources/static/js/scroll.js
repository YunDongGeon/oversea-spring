function fnMove(){
    var offset = $("#newsfeed").offset();
    var height = 100;
    $('html, body').animate({scrollTop : offset.top - height }, 400);
}