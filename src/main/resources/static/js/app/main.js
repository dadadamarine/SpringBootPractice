var main = {
    init : function () {
        console.log(1);
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
            console.log(2);

        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
            console.log(error);
        });
    }

};

main.init();