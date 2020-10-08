$(document).ready(function() {

    // index.html
    // 지역 선택 영역
    $("#location").keyup(function() {
        var k = $(this).val();
        if(k=="서울"){
          $("#location-link").text("서울");
        }

    });

    $("#location-link").click(function() {
      var k = $("#location").val();
      $("#location-dropdown").text(k);
    });

    // 카테고리 선택 영역
    $("#category-instrument,#category-sing,#category-dance,#category-cooking,#category-musical,#category-study").click(function() {
       var k = $(this).text();
       $("#category-dropdown").text(k);
    })

    // Search button
    $("#mainpage-search-button").click(function() {
      var location = $("#location").val();
      var category = $("#category-dropdown").text();
      alert(location);
      alert(category);
    })

})
