// 상품 등록
var main = {
    init : function() {
        var _this = this;
        $('#btn-space-save').on('click', function() {
            _this.save();
        });
        $('#btn-space-delete').on('click', function() {
            _this.deleteSpace();
        });
        $('#btn-space-update').on('click', function() {
            _this.updateSpace();
        });
        $('#btn-enroll-seller').on('click', function() {
            if(_this.enrollSeller()) {
                _this.enrollComplete();
            }
        });
        $('#btn-email-verify').on('click', function() {
            _this.emailVerify();
        });
        $('#btn-email-key').on('click', function() {
            _this.checkEmailKey();
        });
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
        });

        var optionTitleList = [];
        $('input[name="typeTitle"]'.each(function(i) {
            optionTitleList.push($(this).val());
        }));

        var startTimeList = [];
        $('input[name="startTime"]').each(function(i) {
            var v = $(this).val();
            var vv;
            if (v.substring(0,1) == 0) {
                vv = v.substring(1,2);
            }
            else {
                vv = v.substring(0,2);
            }
            startTimeList.push(vv);
        });

        var endTimeList = [];
        $('input[name="endTime"]').each(function(i) {
            var v = $(this).val();
            var vv;
            if (v.substring(0,1) == 0) {
                vv = v.substring(1,2);
            }
            else {
                vv = v.substring(0,2);
            }
            endTimeList.push(vv);
        });

        var data = {
            p_owner_id: $('#p_owner_id').val(),
            p_name: $('#p_name').val(),
            p_location: $('#p_location').val(),
            p_city: $('#p_city').val(),
            p_category: $('#p_category').val(),
            p_weekdayPrice: $('#p_weekdayPrice').val(),
            p_weekendPrice: $('#p_weekendPrice').val(),
            p_introduce: $('#p_introduce').val(),
            p_maxNum: $('#p_maxNum').val(),
            p_liked: $('#p_liked').val(),
            p_avgRating: $('#p_avgRating').val(),
            facility : facilityList,
            notice : noticeList,
            policy : policyList,
            optionTitle : optionTitleList,
            startTime : startTimeList,
            endTime : endTimeList
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
        var id = $("#p_id").val();
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/products/delete/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('해당 게시물이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
    },

    updateSpace : function() {

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
            p_name: $('#p_name').val(),
            p_location: $('#p_location').val(),
            p_city: $('#p_city').val(),
            p_category: $('#p_category').val(),
            p_weekdayPrice: $('#p_weekdayPrice').val(),
            p_weekendPrice: $('#p_weekendPrice').val(),
            p_introduce: $('#p_introduce').val(),
            p_maxNum: $('#p_maxNum').val(),
            facility : facilityList,
            notice : noticeList,
            policy : policyList
        };

        var id = $('#p_id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/products/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('게시글 수정 완료');
            window.location.href = '/';
        }).fail(function() {
            alert(JSON.stringify(error));
        })
    },

    enrollSeller : function() {
        if($('#sellerCheck1').prop("checked")) {
            if($('#sellerCheck2').prop("checked")) {
                return true;
            }
            else {
                alert('두번째 항목이 체크되지 않았습니다.');
            }
        }
        else {
            alert('첫번째 항목이 체크되지 않았습니다.');
        }
        return false;
    },

    enrollComplete : function() {
        var userEmail = $('#userEmail').val();

        $.ajax({
            type: 'PUT',
            url: '/api/user/'+userEmail,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(userEmail)
        }).done(function() {
            alert('판매자 등록이 완료되었습니다.\n다시 로그인 해주세요.');
            window.location.href = '/logout';
//            window.location.href = '/seller/enroll/complete';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    },

    emailVerify : function() {
        var userEmail = $('#userEmail').val();
        $.ajax({
            	type : 'POST',
            	url : '/api/guestUser/email/verify',
        		data : { userEmail:userEmail },
            	dataType :'json'
            }).done(function() {
                alert(userEmail+"로 인증번호가 전송되었습니다.");
                window.location.href = '/myPage/user/checkEmail';
            }).fail(function() {
                alert('fail');
            });
    },

    checkEmailKey : function() {
        var inputKey = $('#verification_code').val();
        var userEmail = $('#userEmail').val();
        if(inputKey=="") {
            alert('인증번호가 입력되지 않았습니다.');
        }
        else {
            $.ajax({
                type: 'PUT',
                url: '/api/guestUser/email/check',
                data : { inputKey:inputKey, userEmail:userEmail },
                dataType :'json',
                success : function(result) {
                    if(result == true) {
                        alert('인증이 완료되었습니다.\n다시 로그인 해주세요.');
                        window.location.href = '/logout';
                    }
                    else {
                        alert('인증번호가 일치하지 않습니다.\n다시 입력해주세요.');
                    }
                }
            })
//            $.ajax({
//                type: 'PUT',
//                url: '/api/guestUser/email/check',
//                data : { inputKey:inputKey, userEmail:userEmail },
//                dataType :'json',
//            }).done(function() {
//                alert('인증이 완료되었습니다.\n다시 로그인 해주세요.');
//                window.location.href = '/logout';
//            }).fail(function() {
//                alert('인증번호가 일치하지 않습니다.\n다시 입력해주세요.');
//            })
        }
    }


};

main.init();