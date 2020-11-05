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

    // 동적 input(facility) 추가
    var maxField = 10;
    var wrapper = $('.append');
    var cnt = 1;

    $('.facility_add_btn').click(function() {
      if(cnt<maxField) {
        cnt++;
        var fieldHtml = '<div class="form-inline"><div class="input-group-prepend"><span class="input-group-text" id="facility-'+cnt+'">'+cnt+'</span></div><input type="text" class="form-control" id="p_facility'+cnt+'" aria-label="Username" aria-describedby="facility-'+cnt+'"><a href="#aa" class="facility_remove_btn"><i class="fa fa-minus ml-3"></i></a></div>'
        $('.append').append(fieldHtml);
      }
    });

    $(wrapper).on('click','.facility_remove_btn', function(e) {
      e.preventDefault();
      cnt--;
      $('.append').empty();
      for(var i=2;i<=cnt;i++) {
        var fieldHtml = '<div class="form-inline"><div class="input-group-prepend"><span class="input-group-text" id="facility-'+i+'">'+i+'</span></div><input type="text" class="form-control" id="p_facility'+i+'" aria-label="Username" aria-describedby="facility-'+i+'"><a href="#aa" class="facility_remove_btn"><i class="fa fa-minus ml-3"></i></a></div>'
        $('.append').append(fieldHtml);
      }
    });

})

$(function () {
  $('#datetimepicker1').datetimepicker({ format: 'L'});
  $('#datetimepicker2').datetimepicker({ format: 'L', useCurrent: false });
  $("#datetimepicker1").on("change.datetimepicker", function (e) {
    $('#datetimepicker2').datetimepicker('minDate', e.date);
  });
  $("#datetimepicker2").on("change.datetimepicker", function (e) {
    $('#datetimepicker1').datetimepicker('maxDate', e.date);
  });
});


