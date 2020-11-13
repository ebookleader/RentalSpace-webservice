// 상품 등록
var main = {
    init : function() {
        var _this = this;
        $('#btn-space-save').on('click', function() {
            _this.save();
        });
        $('#btn-space-delete').on('click', function() {
            _this.deleteSpace();
        })
    },

    save : function() {
        var facilityList = [];
        $('input[name="facility"]').each(function(i) {
            facilityList.push($(this).val());
        });

        var noticeList = [];
        $('input[name="notice"]').each(function(i) {
            noticeList.push($(this).val());
        });

        var policyList = [];
        $('input[name="policy"]').each(function(i) {
            policyList.push($(this).val());
        })

        var data = {
            p_owner_id: $('#p_owner_id').val(),
            p_name: $('#p_name').val(),
            p_location: $('#p_location').val(),
            p_city: $('#p_city').val(),
            p_category: $('#p_category').val(),
            p_weekdayPrice: $('#p_weekdayPrice').val(),
            p_weekendPrice: $('#p_weekendPrice').val(),
            p_introduce: $('#p_introduce').val(),
            p_policy: $('#p_policy').val(),
            p_maxNum: $('#p_maxNum').val(),
            p_liked: $('#p_liked').val(),
            p_avgRating: $('#p_avgRating').val(),
            facility : facilityList,
            notice : noticeList,
            policy : policyList
        };

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
    },

    deleteSpace : function() {

    }
};

main.init();