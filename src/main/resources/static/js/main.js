$(document).ready(function() {

  // index.html
  // 지역 선택 영역
  $("#seoul,#incheon,#daegu,#daejeon,#busan,#gwangju,#ulsan,#saejong,#gyeonggi,#gangwon,#chungn,#chungs,#junn,#juns,#gyeongn,#gyeongs,#jeju").click(function() {
    var k = $(this).text();
    $("#location-dropdown").text(k);
  })

  // 카테고리 선택 영역
  $("#category-instrument,#category-sing,#category-dance,#category-cooking,#category-musical,#category-study").click(function() {
    var k = $(this).text();
    $("#category-dropdown").text(k);
  })

  // Search button
  $("#mainpage-search-button").click(function() {
    var location = $("#location-dropdown").text();
    var category = $("#category-dropdown").text();
    alert(location);
    alert(category);
  })

})
