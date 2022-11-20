$(document).ready(function () {
    getMessages();
})

function getMessages() {
    $('#cards-box').empty();
    $.ajax({
        type: "GET",
        url: "/api/memos",
        data: {},
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let message = response[i];
                let id = message['id'];
                let username = message['name'];
                let contents = message['content'];
                let modifiedAt = message['modifiedAt'];
                addHTML(id, username, contents, modifiedAt);
            }
        }
    });
}

function addHTML(id, username, contents, modifiedAt) {
    let tempHtml = makeMessage(id, username, contents, modifiedAt);
    $('#cards-box').append(tempHtml);
}

function makeMessage(id, username, contents, modifiedAt, i) {
    return `<div class="card">
                        <!-- date/username 영역 -->
            <div class="metadata">
            <div class="date">
                ${modifiedAt}
            </div>
            <div id="${id}-username" class="username">
                ${username}
            </div>
            </div>
                <!-- contents 조회/수정 영역-->
            <div class="contents">
            <div id="${id}-contents" class="text">
                ${contents}
            </div>
            <div id="${id}-editarea" class="edit">
            <textarea id="${id}-textarea" class="te-edit" name="" id="" cols="30" rows="5"></textarea>
            </div>
            </div>
                <!-- 버튼 영역-->
            <div class="footer">
            <img id="${id}-edit" class="icon-start-edit" src="images/edit.png" alt="" onclick="editPost('${id}')">
            <img id="${id}-delete" class="icon-delete" src="images/delete.png" alt="" onclick="deleteOne('${id}')">
            <img id="${id}-submit" class="icon-end-edit" src="images/done.png" alt="" onclick="submitEdit('${id}')">
            </div>
            </div>`;
}