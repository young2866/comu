'use strict';

let commentIndex = {
    init: function () {
        $("#comment-btn-save").on("click", () => {
            this.commentSave();
        });
    },

    commentSave: function () {
        let data = {
            content: $("#comment-content").val(),
        }
        let postId = $("#postId").val();
        console.log(data);
        console.log(postId);
        $.ajax({
            type: "POST",
            url: `/api/v1/post/${postId}/comment`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text"
        }).done(function (res) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/post/${postId}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },
    commentDelete: function (postId, commentId) {
        $.ajax({
            type: "DELETE",
            url: `/api/v1/post/${postId}/comment/${commentId}`,
            dataType: "text"
        }).done(function (res) {
            alert("댓글삭제가 완료되었습니다.");
            location.href = `/post/${postId}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

}
commentIndex.init();