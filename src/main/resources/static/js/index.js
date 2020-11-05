// 상품 등록
var main = {
    init : function() {
        var _this = this;
        $('#btn-space-save').on('click', function() {
            _this.save();
        });
    },

    save : function() {
        var data = {
            p_owner_id: $('#p_owner_id').val(),
            p_name: $('#p_name').val(),
            p_location: $('#p_location').val(),
            p_city: $('#p_city').val(),
            p_category: $('#p_category').val(),
            p_weekdayPrice: $('#p_weekdayPrice').val(),
            p_weekendPrice: $('#p_weekendPrice').val(),
            p_introduce: $('#p_introduce').val(),
            p_facility1: $('#p_facility1').val(),
            p_facility2: $('#p_facility2').val(),
            p_facility3: $('#p_facility3').val(),
            p_facility4: $('#p_facility4').val(),
            p_facility5: $('#p_facility5').val(),
            p_facility6: $('#p_facility6').val(),
            p_facility7: $('#p_facility7').val(),
            p_facility8: $('#p_facility8').val(),
            p_facility9: $('#p_facility9').val(),
            p_facility10: $('#p_facility10').val(),
            p_notice: $('#p_notice').val(),
            p_policy: $('#p_policy').val(),
            p_maxNum: $('#p_maxNum').val(),
            p_liked: $('#p_liked').val(),
            p_avgRating: $('#p_avgRating').val(),
        };

        alert(data);
        $.ajax({
            type: 'POST',
            url: '/api/v1/products',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('상품 등록 완료');
            window.location.href = "/";
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();